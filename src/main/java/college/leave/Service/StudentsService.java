package college.leave.Service;

import college.leave.Model.StudentsEntity;
import college.leave.Repo.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {
    @Autowired
    private StudentsRepo studentsRepo;

    public StudentsEntity addStudent(StudentsEntity student) {
        return studentsRepo.save(student);
    }

    public List<StudentsEntity> displayStudents(StudentsEntity student) {
        return studentsRepo.findAll();
    }

    public Optional<StudentsEntity> getStudentById(Long id) {
        return studentsRepo.findById(id);
    }

    public void updateStudent(Long id, String name, String email, Long contact) {
        studentsRepo.updateStudentDetailsInLeave(name, email, contact, id);
    }

    public void deleteStudent(Long id) {
        studentsRepo.deleteById(id);
    }
}
