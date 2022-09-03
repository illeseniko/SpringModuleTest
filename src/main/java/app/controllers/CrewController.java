package app.controllers;

import app.models.Crew;
import app.repositories.CrewRepo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CrewController {

    private final CrewRepo crewRepo;

    public CrewController(CrewRepo crewRepo) {
        this.crewRepo = crewRepo;
    }

    @GetMapping(value="/crew")
    public String allMember(Model model) {

        List<Crew> crewList = (List<Crew>) crewRepo.findAll();
        model.addAttribute("crewList", crewList);
        return "crew";

    }
}