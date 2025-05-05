package college.leave.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import college.leave.Model.LeaveApplicationEntity;
import college.leave.Service.LeaveService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/leave")
@RestController
public class LeaveApplicationController {

    private LeaveService leaveService;

    public LeaveService getLeaveService() {
        return leaveService;
    }

    public void setLeaveService(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping("/apply")
    public LeaveApplicationEntity applyLeave(@RequestBody LeaveApplicationEntity entity) {
        return leaveService.applyLeave(entity);
    }

    @GetMapping("/student")
    public List<LeaveApplicationEntity> getMethodName(@RequestParam Long param) throws Exception {
        return leaveService.myAllLeaves(param);
    }

}
