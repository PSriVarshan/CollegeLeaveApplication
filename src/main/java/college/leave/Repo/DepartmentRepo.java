package college.leave.Repo;

import college.leave.Model.DeptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<DeptEntity, Integer> {

}
