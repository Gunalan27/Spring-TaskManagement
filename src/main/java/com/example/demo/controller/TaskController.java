package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFound;
import com.example.demo.model.TaskManagement;
import com.example.demo.repository.TaskRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class TaskController {
	
	@Autowired
	private TaskRepository repo;
	
	@PostMapping("/saveTask")
	public TaskManagement addNewTask(@RequestBody TaskManagement task){
		
		return repo.save(task);
	}
		
	@GetMapping("/alltasks")
	public ResponseEntity<List<TaskManagement>> getTaskByID() {
		List<TaskManagement> task=repo.findAll();
		return ResponseEntity.ok(task);
	}
	
	@DeleteMapping("/deleteTask/{id}")
	public ResponseEntity<String> deleteByID(@PathVariable int id){
		
		TaskManagement task=repo.findById(id).orElseThrow(
					()->new ResourceNotFound("no record of "+id+" was found!"));
		repo.delete(task);
		return ResponseEntity.ok("Success vro");
	}
	
	@PutMapping("/changeStatus/{id}")
	public ResponseEntity<TaskManagement> updateByID(@PathVariable int id,@RequestBody TaskManagement task){
		TaskManagement newtask=repo.findById(id).orElseThrow(
						()->new ResourceNotFound("no record of "+id+" was found!"));
		newtask.setTaskDate(task.getTaskDate());
		newtask.setTaskHolderName(task.getTaskHolderName());
		newtask.setTaskName(task.getTaskName());
		newtask.setTaskStatus(task.getTaskStatus());
		
		return ResponseEntity.ok(repo.save(newtask));
	}
}
