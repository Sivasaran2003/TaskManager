package TaskManager.project.project.repository;

import TaskManager.project.project.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    //queries based on the type of status provided
    @Query(value = "SELECT * FROM task WHERE status = ?1", nativeQuery = true)
    public List<Task> getTasksByStatus(String status);

    //sorts the tasks based on the date
    @Query(value = "SELECT * FROM task ORDER BY date ASC", nativeQuery = true)
    public List<Task> getTasksSorted();
}
