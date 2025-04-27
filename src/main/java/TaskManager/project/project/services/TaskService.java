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

    public void addTask(Task task) {
        repo.save(task);
    }

    public Task getByTaskId(int id) {
        return repo.getReferenceById(id);
    }

    public void updateTask(Task task) {
        repo.save(task);
    }

    public void deleteTask(int id) {
        repo.deleteById(id);
    }

}
