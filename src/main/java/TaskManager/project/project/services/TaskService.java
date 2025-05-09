package TaskManager.project.project.services;

import TaskManager.project.project.models.Task;
import TaskManager.project.project.repository.TaskRepository;
import TaskManager.project.project.exceptions.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
public class TaskService {
    @Autowired
    TaskRepository repo;

    //gets all the tasks
    public List<Task> getTasks() {
        return repo.findAll();
    }

    public Task addTask(Task task) {
        return repo.save(task);
    }

    public Task getByTaskId(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));
    }

    //update the task attributes
    public Task updateTask(Task task) {
        return repo.save(task);
    }

    //deletes the task by the given id
    public void deleteTaskById(int id) {
        if(!repo.existsById(id)) {
            throw new TaskNotFoundException("Task with ID " + id + " not found");
        }
        repo.deleteById(id);
    }

    //based on the status, tasks will be returned
    public List<Task> getTasksByStatus(String status) {
        return repo.getTasksByStatus(status);
    }

    //returns the sorted tasks
    public List<Task> getTasksSorted() {
        return repo.getTasksSorted();
    }

}
