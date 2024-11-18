package com.example.kanban_task_manager.controller;

import com.example.kanban_task_manager.model.Task;
import com.example.kanban_task_manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(service.createTask(task));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(service.getAllTasks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return ResponseEntity.ok(service.updateTask(id, updatedTask));
    }

    @PutMapping("/{id}/move")
    public ResponseEntity<Task> moveTask(@PathVariable Long id) {
        return ResponseEntity.ok(service.moveTask(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
