package service;

import dao.ParticipantRepository;
import domain.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> readAll() {

        return participantRepository.findAllParticipants();
    }

    public Participant save(Participant participant) {
        return participantRepository.save(participant);
    }
    @SuppressWarnings("deprecation")
    public Participant findById(Integer id) {
        return participantRepository.findOne(id);
    }

    public Participant update(Participant participant) {
        return participantRepository.save(participant);
    }


    public void deleteById(Integer id) {
      participantRepository.delete(id);
    }

    public List<Participant> findByName(String name) {
        return participantRepository.findByName(name);
    }

    public List<Participant> findByEmail(String email) {
        return participantRepository.findByEmail(email);
    }

    public List<Participant> findByLevel(Integer level) {
        return participantRepository.findByLevel(level);
    }

    public List<Participant> findByPrimarySkill(Integer primarySkill) {
        return participantRepository.findByPrimarySkill(primarySkill);
    }
}
