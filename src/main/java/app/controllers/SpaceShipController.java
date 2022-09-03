package app.controllers;

import app.models.SpaceShip;
import app.models.SpaceShipClass;
import app.repositories.SpaceShipRepo;
import app.services.SpaceShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SpaceShipController {

    private final SpaceShipRepo spaceShipRepo;

    private final SpaceShipService spaceShipService;

    public SpaceShipController(SpaceShipRepo spaceShipRepo,SpaceShipService spaceShipService) {
        this.spaceShipRepo=spaceShipRepo;
        this.spaceShipService = spaceShipService;
    }

    @GetMapping(value = {"/spaceship"})
    public String saveNewSpaceShip(Model model) {
        model.addAttribute("newShip", new SpaceShip());
        model.addAttribute("shipClasses", SpaceShipClass.values());

        return "spaceship_new";
    }

    @GetMapping(value ={"/allspaceships"})
    public String spaceshipDatas( Model model) {
        List<SpaceShip> allSpaceShips = (List<SpaceShip>) spaceShipRepo.findAll();
        model.addAttribute("allSpaceShips", allSpaceShips);
        return "allspaceships";
    }

  /*  @GetMapping(value = {"/activespaceships"})
    public String activeShips(Model model) {
        List<SpaceShip> ships =  spaceShipRepo.findSpaceShipByActiveTrue();
        model.addAttribute("shipActive", ships);
        return "activespaceship";




    }

   */
    }

