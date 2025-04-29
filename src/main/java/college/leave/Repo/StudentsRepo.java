package college.leave.Repo;

import college.leave.Model.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepo extends JpaRepository<StudentsEntity, Long> {

}
