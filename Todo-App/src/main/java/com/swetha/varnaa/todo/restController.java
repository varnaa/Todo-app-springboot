package com.swetha.varnaa.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.swetha.varnaa.todo.model.TaskService;

@RestController
public class restController {

	@Autowired
	private TaskService service;
	
	@RequestMapping("/delete/{id}")
	public RedirectView deleteTask(@PathVariable("id") int id) {
		service.deleteOne(id);
		return new RedirectView("/alltasks");
	}
}
