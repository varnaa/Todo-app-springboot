package com.swetha.varnaa.todo.model;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	public List<Task> findAll(){
		return repository.findAll();
	}

	public void deleteOne(int id) {
		 repository.deleteById(id);
	}
	
	public void saveTask(Task task) {
		repository.save(task);
	}
	
	public Optional<Task> findByOne(int id) {
		return repository.findById(id);
		
	}
}
