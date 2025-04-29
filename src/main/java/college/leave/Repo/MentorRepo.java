package college.leave.Repo;

import college.leave.Model.MentorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepo extends JpaRepository<MentorEntity, String> {

}
