package college.leave.Repo;

import college.leave.Model.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepo extends JpaRepository<StudentsEntity, Long> {

}
