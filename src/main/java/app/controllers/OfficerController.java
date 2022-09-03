package app.controllers;

import app.repositories.UserRepo;

public class OfficerController {

    private final UserRepo userRepo;

    public OfficerController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
}
