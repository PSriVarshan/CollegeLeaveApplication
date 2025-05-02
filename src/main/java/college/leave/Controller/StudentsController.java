package college.leave.Controller;

import college.leave.Model.StudentsEntity;
import college.leave.Service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students/api")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @PostMapping("/add")
    public StudentsEntity addStudentDetails(@RequestBody StudentsEntity student) {
        return studentsService.addStudent(student);
    }

    @GetMapping("/display/{id}")
    public Optional<StudentsEntity> displayStudents(@PathVariable("id") Long StudentId) {
        return studentsService.getStudentById(StudentId);
    }

    @GetMapping("/displayAll")
    public List<StudentsEntity> displayAllStudents() {
        return studentsService.displayStudents();
    }

    @PutMapping("/update/{id}")
    public void updateStudents(@RequestBody Long StudentId, String stName, String email, Long contact) {
        studentsService.updateStudent(StudentId, stName, email, contact);
    }

    @DeleteMapping("/del/{id}")
    public String deleteStudent(@PathVariable Long StudentId) {
        studentsService.deleteStudent(StudentId);
        return "Student Data deleted Successfully !!";
    }
}
