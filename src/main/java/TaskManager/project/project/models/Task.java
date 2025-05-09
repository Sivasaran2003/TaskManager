package TaskManager.project.project.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String taskName;
    private String description;
    private Date date;
    private String priority;
    private String status;

    public Task(String taskName, String priority, String status) {
        this.taskName = taskName;
        this.priority = priority;
        this.status = status;
    }
}
