package college.leave.Repo;

import college.leave.Model.LeaveApplicationEntity;
import college.leave.Model.StudentsEntity;
import college.leave.Model.Enums.ApprovalStatus;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepo extends JpaRepository<LeaveApplicationEntity, Long> {

        List<LeaveApplicationEntity> findByStudentId(StudentsEntity studentId);

        /**
         * Updates the approval status of a leave application to APPROVED.
         *
         * @param lId The ID of the leave application to be updated.
         */
        @Transactional
        @Modifying
        @Query("UPDATE LeaveApplicationEntity l SET l.status = :status WHERE l.leaveId = :lId AND l.status = :currentStatus")
        void acceptLeaveByLeaveId(@Param("lId") Long lId,
                        @Param("status") ApprovalStatus status,
                        @Param("currentStatus") ApprovalStatus currentStatus);

        /**
         * Updates the approval status of a leave application to REJECTED.
         *
         * @param lId The ID of the leave application to be updated.
         */
        @Transactional
        @Modifying
        @Query("UPDATE LeaveApplicationEntity l SET l.status = :status WHERE l.leaveId = :lId AND l.status = :currentStatus")
        void rejectLeave(@Param("lId") Long lId,
                        @Param("status") ApprovalStatus status,
                        @Param("currentStatus") ApprovalStatus currentStatus);

        /**
         * Updates the approval status of all leave applications for a specific student
         * to APPROVED.
         *
         * @param sId The ID of the student.
         */
        @Transactional
        @Modifying
        @Query("UPDATE LeaveApplicationEntity l SET l.status = :status WHERE l.studentId.studentId = :sId AND l.status = :currentStatus")
        void acceptLeaveByStudentId(@Param("sId") Long sId,
                        @Param("status") ApprovalStatus status,
                        @Param("currentStatus") ApprovalStatus currentStatus);

        /**
         * Updates the approval status of all leave applications for a specific student
         * to REJECTED.
         *
         * @param sId The ID of the student.
         */
        @Transactional
        @Modifying
        @Query("UPDATE LeaveApplicationEntity l SET l.status = :status WHERE l.studentId.studentId = :sId AND l.status = :currentStatus")
        void rejectLeaveByStudentId(@Param("sId") Long sId,
                        @Param("status") ApprovalStatus status,
                        @Param("currentStatus") ApprovalStatus currentStatus);

        /**
         * Retrieves all approved leave applications for a specific mentor.
         *
         * @param givenId The ID of the mentor.
         * @return A list of approved leave applications.
         */
        @Query("SELECT l FROM LeaveApplicationEntity l WHERE l.status = :status AND l.mentor.mentorId = :givenId")
        List<LeaveApplicationEntity> allApprovedLeavesByMentor(@Param("status") ApprovalStatus status,
                        @Param("givenId") String givenId);

        /**
         * Retrieves all rejected leave applications for a specific mentor.
         *
         * @param givenId The ID of the mentor.
         * @return A list of rejected leave applications.
         */
        @Query("SELECT l FROM LeaveApplicationEntity l WHERE l.status = :status AND l.mentor.mentorId = :givenId")
        List<LeaveApplicationEntity> allRejectedLeavesByMentor(@Param("status") ApprovalStatus status,
                        @Param("givenId") String givenId);

        /**
         * Retrieves all pending leave applications for a specific mentor.
         *
         * @param givenId The ID of the mentor.
         * @return A list of pending leave applications.
         */
        @Query("SELECT l FROM LeaveApplicationEntity l WHERE l.status = :status AND l.mentor.mentorId = :givenId")
        List<LeaveApplicationEntity> allPendingLeavesByMentor(@Param("status") ApprovalStatus status,
                        @Param("givenId") String givenId);
}
