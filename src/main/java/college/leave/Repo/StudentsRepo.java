package college.leave.Repo;

import college.leave.Model.StudentsEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentsRepo extends JpaRepository<StudentsEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE students SET studentName=:newName, email=:newEmail, phoneNo=:newContact WHERE studentId=:sid")
    void updateStudentDetailsInLeave(
            @Param("newName") String newName,
            @Param("newEmail") String newEmail,
            @Param("newContact") Long newContact,
            @Param("sid") Long sid
    );

}
