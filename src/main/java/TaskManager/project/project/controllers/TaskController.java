package TaskManager.project.project.controllers;

import TaskManager.project.project.models.Task;
import TaskManager.project.project.services.TaskService;
import exceptions.TaskNotFoundException;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService service;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(service.getTasks());
    }

    @PostMapping
    public ResponseEntity<Task> addNewTask(@RequestBody Task task) {
        return new ResponseEntity<>(service.addTask(task), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByTaskId(@PathVariable int id) {
        try {
            return new ResponseEntity<>(service.getByTaskId(id), HttpStatus.OK);
        }catch (TaskNotFoundException t) {
            return new ResponseEntity<>(t.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        return new ResponseEntity<>(service.updateTask(task), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id) {
        try {
            service.deleteTask(id);
            return new ResponseEntity<>("Task deleted", HttpStatus.OK);
        }catch (TaskNotFoundException t) {
            return new ResponseEntity<>(t.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable String status) {
        return new ResponseEntity<>(service.getTasksByStatus(status), HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Task>> getTasksSorted() {
        return new ResponseEntity<>(service.getTasksSorted(), HttpStatus.OK);
    }

}
