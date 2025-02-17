package com.demoapp.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	static {
		todos.add(new Todo(1, "haunc", "Todo 1", new Date(), false));
		todos.add(new Todo(2, "haunc", "Todo 2", new Date(), true));
		todos.add(new Todo(3, "haunc", "Todo 3", new Date(), false));
	}

	public List<Todo> getListTodo(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}

	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}

	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public Todo retrieveTodo(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	public void updateTodo(Todo todo) {
		for (Todo todoOld : todos) {
			if (todoOld.equals(todo)) {
				todoOld.setDescription(todo.getDescription());
				todoOld.setDone(todo.isDone());
				todoOld.setDueDate(todo.getDueDate());
				break;
			}
		}
	}
}
