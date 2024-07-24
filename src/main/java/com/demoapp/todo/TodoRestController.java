package com.demoapp.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/todos-json")
	public List<Todo> getListTodo() {
		List<Todo> todosByUser = todoService.getListTodo("haunc");
		
		return todosByUser;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/todos-json/{id}")
	public Todo getTodo(@PathVariable int id) {
		Todo todo = todoService.retrieveTodo(id);
		
		return todo;
	}
}
