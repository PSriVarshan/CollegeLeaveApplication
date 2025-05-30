package college.leave.Service;

import college.leave.Model.MentorEntity;
import college.leave.Repo.MentorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorService {
    @Autowired
    private MentorRepo mentorRepo;

    public MentorEntity addMentor(MentorEntity mentor) {
        return mentorRepo.save(mentor);
    }

    public MentorEntity getMentorDetails(Long mentorId) {
        return mentorRepo.findById(mentorId).orElse(null);
    }

    public void updateMentor(MentorEntity mentor) {
        mentorRepo.updateMentorDetails(mentor.getMentorId(), mentor.getFacultyName(), mentor.getEmail(),
                mentor.getPhoneNumber());
    }

    public void deleteMentor(Long mentorId) {
        mentorRepo.deleteById(mentorId);
    }
}
