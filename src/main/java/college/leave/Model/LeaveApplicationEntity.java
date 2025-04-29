package college.leave.Model;

import college.leave.Model.Enums.ApprovalStatus;
import college.leave.Model.Enums.LeaveType;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Entity
@Data
public class LeaveApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveId;
    @OneToMany
    @JoinColumn(name="studentId")
    private StudentsEntity studentId;

    private Date fromDate;
    private Date toDate;
    private String reason;
    private Date appliedDate;

    private ApprovalStatus status= ApprovalStatus.PENDING;

    @OneToMany
    @JoinColumn(name="mentorID")
    private MentorEntity mentor;

    private LeaveType leaveType = LeaveType.CASUAL_LEAVE;

    @Column(nullable = true)
    private String docUrl;
}
