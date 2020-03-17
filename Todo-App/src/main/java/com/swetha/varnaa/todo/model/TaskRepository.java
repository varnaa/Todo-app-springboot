package com.swetha.varnaa.todo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository <Task,Integer> {

}
