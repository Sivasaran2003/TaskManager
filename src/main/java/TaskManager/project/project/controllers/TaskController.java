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
    public void addNewTask(@RequestBody Task task) {
        service.addTask(task);
    }

    @GetMapping("/task/{id}")
    public void getByTaskId(@PathVariable int id) {
        service.getByTaskId(id);
    }

    @PutMapping("/task")
    public void updateTask(@RequestBody Task task) {
        service.updateTask(task);
    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }

}
