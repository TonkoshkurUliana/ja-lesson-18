package controller;

import domain.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ParticipantService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping("/")
    public String init(HttpServletRequest req) {
        req.setAttribute("participants", participantService.readAll());
        req.setAttribute("mode", "PARCTICIPANT_VIEW");
        return "index";
    }

    @GetMapping("/new")
    public String newParticipant (HttpServletRequest req) {
        req.setAttribute("mode", "PARCTICIPANT_CREATE");
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Participant participant, HttpServletRequest req) {
        participantService.save(participant);
        req.setAttribute("participants", participantService.readAll());
        req.setAttribute("mode", "PARCTICIPANT_VIEW");
        return "index";
    }

    @GetMapping("/update")
    public String update(@RequestParam int id, HttpServletRequest req) {
        req.setAttribute("participant", participantService.findById(id));
        req.setAttribute("mode", "PARCTICIPANT_EDIT");
        return "index";
    }

    @GetMapping("/delete")
    public String deleteParticipant(@RequestParam int id, HttpServletRequest req) {
        participantService.deleteById(id);
        req.setAttribute("participants", participantService.readAll());
        req.setAttribute("mode", "PARCTICIPANT_VIEW");
        return "index";
    }
}

