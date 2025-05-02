package TaskManager.project.project.controllers;

import TaskManager.project.project.models.Task;
import TaskManager.project.project.services.TaskService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService service;

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getTasks();
    }

    @PostMapping
    public Task addNewTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @GetMapping("/{id}")
    public Task getByTaskId(@PathVariable int id) {
        return service.getByTaskId(id);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task) {
        return service.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status) {
        return service.getTasksByStatus(status);
    }

    @GetMapping("/sort")
    public List<Task> getTasksSorted() {
        return service.getTasksSorted();
    }

}
