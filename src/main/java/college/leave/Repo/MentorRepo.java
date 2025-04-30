package college.leave.Repo;

import college.leave.Model.MentorEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepo extends JpaRepository<MentorEntity, String> {
    @Transactional
    @Modifying
    @Query("UPDATE Mentors SET facultyName=:newName, email=:newEmail, phoneNumber=:newContact WHERE mentorId=:mId")
    void updateMentorDetails(
            @Param("mid") String mid,
            @Param("newName") String newName,
            @Param("newEmail") String newEmail,
            @Param("newContact") Long newContact
    );
}
