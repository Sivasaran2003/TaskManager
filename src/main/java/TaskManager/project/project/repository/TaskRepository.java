package TaskManager.project.project.repository;

import TaskManager.project.project.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
