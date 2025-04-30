package college.leave.Repo;

import college.leave.Model.MentorLeaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorLeaveRepo extends JpaRepository<MentorLeaveEntity,Long> {

}
