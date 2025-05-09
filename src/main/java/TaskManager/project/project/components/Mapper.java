package TaskManager.project.project.components;

import TaskManager.project.project.models.Task;
import TaskManager.project.project.models.TaskDTO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Mapper {
    public TaskDTO toDto(Task task) {
        return new TaskDTO(task.getTaskName(), task.getStatus(), task.getPriority(), task.getDescription(), task.getDate());
    }
}

