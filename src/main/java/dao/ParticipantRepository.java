package dao;

import domain.Participant;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ParticipantRepository  {
    private List<Participant> participants = new ArrayList<>();

    @PostConstruct
    public void init() {
        Participant participant1 = new Participant();
        participant1.setId(1);
        participant1.setEmail("participant-1@gmail.com");
        participant1.setName("Participant - 1");
        participant1.setLevel(3);
        participant1.setPrimarySkill(15);

        Participant participant2 = new Participant();
        participant2.setId(2);
        participant2.setEmail("participant-2@gmail.com");
        participant2.setName("Participant - 2");
        participant2.setLevel(4);
        participant2.setPrimarySkill(10);

        Participant participant3 = new Participant();
        participant3.setId(3);
        participant3.setEmail("participant-3@gmail.com");
        participant3.setName("Participant - 3");
        participant3.setLevel(2);
        participant3.setPrimarySkill(12);


        participants.add(participant1);
        participants.add(participant2);
        participants.add(participant3);
    }

    public List<Participant> findAllParticipants() {
        return participants;
    }

    public Participant findOne(int id) {
        return participants.stream().filter(participant -> participant.getId() == id).findFirst().orElse(null);
    }

    public Participant save(Participant participant) {
        Participant participantToUpdate = null;

        if (participant.getId() != null) {
            participantToUpdate = findOne(participant.getId());
            int bookIndex = participants.indexOf(participantToUpdate);
            participantToUpdate.setName(participant.getName());
            participantToUpdate.setEmail(participant.getEmail());
            participantToUpdate.setLevel(participant.getLevel());
            participantToUpdate.setPrimarySkill(participant.getPrimarySkill());

            participants.set(bookIndex, participantToUpdate);
        } else {
            // save
            participant.setId(participants.size()+1);
            participants.add(participant);
        }
        return participantToUpdate;
    }

    public void delete(int id) {
        Iterator<Participant> iter = participants.iterator();
        while (iter.hasNext()) {
            if (iter.next().getId() == id) {
                iter.remove();
            }
        }
    }

    public List<Participant> findByName(String name) {
        return participants.stream().filter(participant -> participant.getName().equals(name)).collect(Collectors.toList());
    }


    public List<Participant> findByEmail(String email) {
        return participants.stream().filter(participant -> participant.getEmail().equals(email)).collect(Collectors.toList());
    }

    public List<Participant> findByLevel(Integer level) {
        return participants.stream().filter(participant -> participant.getLevel() == level).collect(Collectors.toList());
    }

    public List<Participant> findByPrimarySkill(Integer primarySkill) {
        return participants.stream().filter(participant -> participant.getPrimarySkill() == primarySkill).collect(Collectors.toList());
    }
}
