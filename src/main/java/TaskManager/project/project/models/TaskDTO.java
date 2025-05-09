package TaskManager.project.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class TaskDTO {
    private String taskName, priority, status, description;
    private Date deadline;
}