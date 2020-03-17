package com.swetha.varnaa.todo;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.swetha.varnaa.todo.model.Task;
import com.swetha.varnaa.todo.model.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService service;
	
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("tasks",service.findAll());
		model.addAttribute("mode","MODE_HOME");
		return "index";
	}
	
	@GetMapping("/alltasks")
	public String allTask(Model model){
		List<Task> tasks = service.findAll();
		model.addAttribute("tasks", tasks);
		model.addAttribute("mode","MODE_ALL");
		return "index";
}

	
	@GetMapping("/newtask")
	public String newTask(Model model) {
		model.addAttribute("task", new Task());
		model.addAttribute("mode","MODE_NEW");
		return "index";
	}
	
	@PostMapping("/savetask")
	public String save(@ModelAttribute Task task, Model model){
		task.setCreated_date(new Date());
		service.saveTask(task);
		model.addAttribute("tasks",service.findAll());
		model.addAttribute("mode","MODE_ALL");
		return "index";
		
	}
	
	@GetMapping("/updatetask")
	public String updateTask(@RequestParam("id") int id, HttpServletRequest request, Model model) {
		model.addAttribute("task",service.findByOne(id));
		model.addAttribute("mode","MODE_UPDATE");
		return"index";
	}
}
