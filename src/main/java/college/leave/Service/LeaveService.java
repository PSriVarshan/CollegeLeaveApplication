package college.leave.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import college.leave.Model.LeaveApplicationEntity;
import college.leave.Model.StudentsEntity;
import college.leave.Repo.LeaveRepo;
import college.leave.Repo.StudentsRepo;

@Service
public class LeaveService {
    @Autowired
    private LeaveRepo leave;

    @Autowired
    private StudentsRepo student;

    public LeaveApplicationEntity applyLeave(LeaveApplicationEntity newLeave) {
        return leave.save(newLeave);
    }

    public List<LeaveApplicationEntity> myAllLeaves(Long studentId) throws Exception {
        StudentsEntity obj = student.findById(studentId).orElse(null);
        if (obj == null)
            throw new Exception("Unable to search student with Id" + studentId);
        return leave.findByStudentId(obj);
    }
}
