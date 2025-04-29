package TaskManager.project.project.services;

import TaskManager.project.project.models.Task;
import TaskManager.project.project.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository repo;
    public List<Task> getTasks() {
        return repo.findAll();
    }

    public Task addTask(Task task) {
        return repo.save(task);
    }

    public Task getByTaskId(int id) {
        return repo.findById(id).orElse(null);
    }

    public Task updateTask(Task task) {
        return repo.save(task);
    }

    public void deleteTask(int id) {
        repo.deleteById(id);
    }

}
