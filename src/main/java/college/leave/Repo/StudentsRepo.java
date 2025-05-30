package college.leave.Repo;

import college.leave.Model.StudentsEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepo extends JpaRepository<StudentsEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE StudentsEntity SET studentName=:newName, email=:newEmail, phoneNo=:newContact WHERE studentId=:sid")
    public void updateStudentDetailsInLeave(
            @Param("newName") String newName,
            @Param("newEmail") String newEmail,
            @Param("newContact") Long newContact,
            @Param("sid") Long sid);

}
