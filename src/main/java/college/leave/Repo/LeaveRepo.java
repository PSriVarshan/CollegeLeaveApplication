package college.leave.Repo;

import college.leave.Model.LeaveApplicationEntity;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepo extends JpaRepository<LeaveApplicationEntity, Long> {
    /**
     * TO UPDATE THE APPROVAL STATUSES IN LEAVE APPLICATION AND STUDENTS ENTITY
     */

    @Transactional
    @Modifying
    @Query("UPDATE leaves l SET l.ApprovalStatus=l.ApprovalStatus.APPROVED WHERE l.leaveId=:lId and l.ApprovalStatus.PENDING")
    void acceptLeave(@Param("lId") Long lId);

    @Transactional
    @Modifying
    @Query("UPDATE leaves l SET l.ApprovalStatus=l.ApprovalStatus.APPROVED WHERE studentId=:sId and l.ApprovalStatus.PENDING")
    void acceptLeaveByStudentId(@Param("sId") Long sId);

    @Transactional
    @Modifying
    @Query("UPDATE leaves l SET l.ApprovalStatus=l.ApprovalStatus.REJECTED WHERE studentId=:sId and l.ApprovalStatus.PENDING")
    void rejectLeaveByStudentId(@Param("sId") Long sId);

    @Query("SELECT l FROM LeaveApplicationEntity l WHERE l.ApprovalStatus = l.ApprovalStatus.APPROVED and l.mentorId=:givenId")
    List<LeaveApplicationEntity> allApprovedLeavesByMentor(@Param("givenId") String givenId);

    @Query("SELECT l FROM LeaveApplicationEntity l WHERE l.ApprovalStatus = l.ApprovalStatus.REJECTED and l.mentorId=:givenId")
    List<LeaveApplicationEntity> allRejectedLeavesByMentor(@Param("givenId") String givenId);
}
