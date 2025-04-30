package college.leave.Model;

import java.util.Date;

import college.leave.Model.Enums.ApprovalStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "mentorLeaveDetails")
public class MentorLeaveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mentorLeaveId;

    @OneToMany
    @JoinColumn(name = "mentorId")
    private MentorEntity mentorId;

    /**
     * The start date of the leave.
     */
    private Date fromDate;

    /**
     * The end date of the leave.
     */
    private Date toDate;

    /**
     * The reason for the leave application.
     */
    private String reason;

    /**
     * The date when the leave application was submitted.
     */
    private Date appliedDate;

    /**
     * The current approval status of the leave application.
     * Defaults to PENDING.
     */
    private ApprovalStatus status = ApprovalStatus.PENDING;
}
