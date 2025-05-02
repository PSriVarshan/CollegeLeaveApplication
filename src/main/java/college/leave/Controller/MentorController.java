package college.leave.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import college.leave.Model.MentorEntity;
import college.leave.Service.MentorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("/mentors/api")
@RestController
public class MentorController {

    @Autowired
    private MentorService mentorService;

    public MentorService getMentorService() {
        return mentorService;
    }

    public void setMentorService(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @PostMapping("/add")
    public MentorEntity addMentorEntity(@RequestBody MentorEntity entity) {

        return mentorService.addMentor(entity);
    }

    @GetMapping("/{id}")
    public MentorEntity getMentorDetails(@PathVariable Long id) {
        return mentorService.getMentorDetails(id);
    }

    @PutMapping("/updateDetails/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody MentorEntity entity) {
        mentorService.updateMentor(entity);
        return "Success";
    }

}
