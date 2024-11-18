package com.example.kanban_task_manager.service;

import com.example.kanban_task_manager.model.Task;
import com.example.kanban_task_manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setPriority(updatedTask.getPriority());
        return repository.save(task);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public Task moveTask(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        switch (task.getStatus()) {
            case TO_DO -> task.setStatus(Task.Status.IN_PROGRESS);
            case IN_PROGRESS -> task.setStatus(Task.Status.DONE);
            default -> throw new RuntimeException("Task is already in DONE status");
        }
        return repository.save(task);
    }
}
