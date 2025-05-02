package college.leave.Controller;

import college.leave.Model.DeptEntity;
import college.leave.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/dept/api")
@RestController
public class DeptController {
    @Autowired
    private DepartmentService deptService;

    @PostMapping("/addDept")
    public DeptEntity addDept(@RequestBody DeptEntity dept){
        return deptService.addDepartment(dept);
    }
}
