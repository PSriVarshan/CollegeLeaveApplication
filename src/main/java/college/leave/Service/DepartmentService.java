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

    public DeptEntity addDepartment(DeptEntity dept) {
        return deptRepo.save(dept);
    }

    public List<DeptEntity> listAllDepartments() {
        return deptRepo.findAll();
    }

    public DeptEntity findDeptById(Integer deptId) {
        return deptRepo.findById(deptId).orElse(null);
    }

    public void deleteDepartmentById(Integer deptId) {
        deptRepo.deleteById(deptId);
    }

    public void updateDeptName(String deptName, Integer deptId) {
        deptRepo.updateDeptName(deptName, deptId);
    }
}
