package TaskManager.project.project.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String taskName;
    private String description;
    private Date date;
    private String priority; // high / medium / low
    private String status; // done / in progress / to do
}
