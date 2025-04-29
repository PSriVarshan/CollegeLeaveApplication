package college.leave.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import college.leave.Model.DeptEntity;
import college.leave.Repo.DepartmentRepo;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo deptRepo;

    DeptEntity addDepartment(DeptEntity dept) {
        return deptRepo.save(dept);
    }

    List<DeptEntity> listAllDepartments() {
        return deptRepo.findAll();
    }

    DeptEntity findDeptById(Integer deptId) {
        return deptRepo.findById(deptId).orElse(null);
    }

    void deleteDepartmentById(Integer deptId) {
        deptRepo.deleteById(deptId);
    }

    void updateDeptName(String deptName, Integer deptId) {
        deptRepo.updateDeptName(deptName, deptId);
    }
}
