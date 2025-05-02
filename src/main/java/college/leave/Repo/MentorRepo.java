package college.leave.Repo;

import college.leave.Model.MentorEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepo extends JpaRepository<MentorEntity, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE MentorEntity SET facultyName=:newName, email=:newEmail, phoneNumber=:newContact WHERE mentorId=:mId")
    public void updateMentorDetails(
            @Param("mid") Long mid,
            @Param("newName") String newName,
            @Param("newEmail") String newEmail,
            @Param("newContact") Long newContact);
}
