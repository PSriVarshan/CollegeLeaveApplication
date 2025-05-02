package college.leave.Controller;

import college.leave.Model.DeptEntity;
import college.leave.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dept/api")
@RestController
public class DeptController {
    @Autowired
    private DepartmentService deptService;

    @PostMapping("/addDept")
    public DeptEntity addDept(@RequestBody DeptEntity dept) {
        return deptService.addDepartment(dept);
    }

    @GetMapping("/getAllDept")
    public List<DeptEntity> listDepartments() {
        return deptService.listAllDepartments();
    }

    @GetMapping("/getDept/{deptId}")
    public DeptEntity getDeptById(@PathVariable Integer deptId) {
        return deptService.findDeptById(deptId);
    }

    @PutMapping("/updateDept/{deptId}")
    public String updateDept(@RequestBody String deptName, @PathVariable Integer deptId) {
        deptService.updateDeptName(deptName, deptId);
        return "Updated Department Successfully";
    }

    @DeleteMapping("/delDept/{deptId}")
    public String deleteDept(@PathVariable Integer deptId) {
        deptService.deleteDepartmentById(deptId);
        return "Deleted Department Successfully";
    }
}
