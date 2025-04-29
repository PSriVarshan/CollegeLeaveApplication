package college.leave.Repo;

import college.leave.Model.LeaveApplicationEntity;
import college.leave.Model.StudentsEntity;
import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepo extends JpaRepository<LeaveApplicationEntity, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE leaves l SET l.ApprovalStatus=l.ApprovalStatus.ACCEPTED WHERE l.leaveId=:lId and l.ApprovalStatus.PENDING")
    void acceptLeave(@Param("lId") Long lId);

    @Transactional
    @Modifying
    @Query("UPDATE leaves l SET l.ApprovalStatus=l.ApprovalStatus.ACCEPTED WHERE studentId=:sId and l.ApprovalStatus.PENDING")
    void acceptLeaveByStudentId(@Param("sId") StudentsEntity sId);
}
