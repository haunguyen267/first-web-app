package com.demoapp.todo;

import java.util.Date;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


public class Todo {
	private int id;
	private String user;
	@NotBlank(message = "{error.desc.blank}")
	@Size(max = 255, message = "{error.desc.max}")
	private String description;
	private Date dueDate;
	private boolean done;

	public Todo() {
	}

	public Todo(int id, String user, String description, Date dueDate, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
		this.dueDate = dueDate;
		this.done = isDone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean isDone) {
		this.done = isDone;
	}

	@Override
	public String toString() {
		return String.format("ToString - Todo [id=%s, user=%s, description=%s, dueDate=%s, isDone=%s]", id, user,
				description, dueDate, done);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return id == other.id;
	}

}
