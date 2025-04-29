package college.leave.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DeptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptId;

    private String deptName;

}
