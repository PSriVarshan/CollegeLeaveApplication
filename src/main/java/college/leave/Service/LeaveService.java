package college.leave.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import college.leave.Repo.LeaveRepo;

@Service
public class LeaveService {
    @Autowired
    private LeaveRepo studentLeave;

}
