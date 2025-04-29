package TaskManager.project.project.controllers;

import TaskManager.project.project.models.Task;
import TaskManager.project.project.services.TaskService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService service;

    @GetMapping("/")
    public String greet() {
        return "Hello World";
    }

    @GetMapping("/task")
    public List<Task> getAllTasks() {
        return service.getTasks();
    }

    @PostMapping("/task")
    public Task addNewTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @GetMapping("/task/{id}")
    public Task getByTaskId(@PathVariable int id) {
        return service.getByTaskId(id);
    }

    @PutMapping("/task")
    public Task updateTask(@RequestBody Task task) {
        return service.updateTask(task);
    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }

}
