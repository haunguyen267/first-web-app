package com.demoapp.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService todoService;
	@Autowired
	MessageSource messageSource;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateformat, false));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/todos")
	public String listTodos(ModelMap model) {
		model.put("name", getLoggedInUsername());
		model.addAttribute("todos", todoService.getListTodo(getLoggedInUsername()));
		return "list-todos";
	}

	private String getLoggedInUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/add-todo")
	public String showNewTodo(ModelMap model) {
		model.put("type", "create");
		model.addAttribute("todo", new Todo(0, getLoggedInUsername(), "", new Date(), false));
		return "todo";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add-todo")
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result, RedirectAttributes redirectAtrr) {
		if (result.hasErrors())
			return "todo";
		todoService.addTodo(getLoggedInUsername(), todo.getDescription(), todo.getDueDate(), todo.isDone());
		model.clear();
		setSuccessMessage(redirectAtrr, "create.success");
		return "redirect:todos";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/update-todo")
	public String showUpdateTodo(ModelMap model, @RequestParam int id) {
		model.put("type", "update");
		model.addAttribute("todo", todoService.retrieveTodo(id));
		return "todo";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update-todo")
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result, RedirectAttributes redirectAtrr) {
		if (result.hasErrors())
			return "todo";
		todo.setUser(getLoggedInUsername());
		todoService.updateTodo(todo);
		model.clear();
		setSuccessMessage(redirectAtrr, "update.success");
		return "redirect:todos";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/delete-todo")
	public String deleteTodo(@RequestParam int id, ModelMap model, RedirectAttributes redirectAtrr) {
		todoService.deleteTodo(id);
		model.clear();
		setSuccessMessage(redirectAtrr, "delete.success");
		return "redirect:todos";
	}

	private void setSuccessMessage(RedirectAttributes redirectAtrr, String code) {
		redirectAtrr.addFlashAttribute("successMessage",
				messageSource.getMessage(code, null, LocaleContextHolder.getLocale()));
	}
}
