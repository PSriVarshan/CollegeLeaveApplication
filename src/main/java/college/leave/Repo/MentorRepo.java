package college.leave.Repo;

import college.leave.Model.MentorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepo extends JpaRepository<MentorEntity, String> {

}
