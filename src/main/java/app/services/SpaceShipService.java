package app.services;

import app.models.Crew;
import app.models.SpaceShip;
import app.repositories.SpaceShipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpaceShipService {

    private SpaceShipRepo spaceShipRepo;

    @Autowired
    public SpaceShipService(SpaceShipRepo spaceShipRepo) {
        this.spaceShipRepo = spaceShipRepo;
    }

    public List<SpaceShip> allSpaceShips() {
        return (List<SpaceShip>) spaceShipRepo.findAll();
    }

    public List<SpaceShip> activeShips(){
        List<SpaceShip> result = new ArrayList<>();
        for (SpaceShip ship : allSpaceShips()){
            if (ship.isActive()){
                result.add(ship);
            }
        }
        return result;
    }



}
