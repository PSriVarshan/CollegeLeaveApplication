package college.leave.Repo;

import college.leave.Model.LeaveApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepo extends JpaRepository<LeaveApplicationEntity, Long> {

}
