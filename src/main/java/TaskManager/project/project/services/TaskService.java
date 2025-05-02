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

    //gets all the tasks
    public List<Task> getTasks() {
        return repo.findAll();
    }

    public Task addTask(Task task) {
        return repo.save(task);
    }

    public Task getByTaskId(int id) {
        return repo.findById(id).orElse(null);
    }

    //update the task attributes
    public Task updateTask(Task task) {
        //if the task is done, deletes from db
        if(task.getStatus().equals("done")) {
            return null;
        }
        return repo.save(task);
    }

    //deletes the task by the given id
    public void deleteTask(int id) {
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
