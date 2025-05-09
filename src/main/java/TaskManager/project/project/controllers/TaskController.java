package TaskManager.project.project.controllers;

import TaskManager.project.project.components.Mapper;
import TaskManager.project.project.models.Task;
import TaskManager.project.project.models.TaskDTO;
import TaskManager.project.project.services.TaskService;
import TaskManager.project.project.exceptions.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService service;
    @Autowired
    Mapper mapper;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> taskDTOs = service.getTasks()
                                .stream()
                                .map(task -> mapper.toDto(task))
                                .toList();
        return ResponseEntity.ok(taskDTOs);
    }

    @PostMapping
    public ResponseEntity<Task> addNewTask(@RequestBody Task task) {
        return new ResponseEntity<>(service.addTask(task), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByTaskId(@PathVariable int id) {
        return new ResponseEntity<>(mapper.toDto(service.getByTaskId(id)), HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        return new ResponseEntity<>(service.updateTask(task), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id) {
        service.deleteTaskById(id);
        return new ResponseEntity<>("Task deleted", HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TaskDTO>> getTasksByStatus(@PathVariable String status) {
        List<TaskDTO> taskDTOs = service.getTasksByStatus(status)
                .stream()
                .map(task -> mapper.toDto(task))
                .toList();
        return new ResponseEntity<>(taskDTOs, HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<TaskDTO>> getTasksSorted() {
        List<TaskDTO> taskDTOs = service.getTasksSorted()
                                .stream()
                                .map(task -> mapper.toDto(task))
                                .toList();
        return new ResponseEntity<>(taskDTOs, HttpStatus.OK);
    }

}
