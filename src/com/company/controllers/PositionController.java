package com.company.controllers;

import com.company.entities.Position;
import com.company.repositories.interfaces.IPositionRepositories;

//Class which is connect to repository and myApplication, and return query result

public class PositionController {
    private  final IPositionRepositories positionRepositories;

    public PositionController(IPositionRepositories positionRepositories) {
        this.positionRepositories = positionRepositories;
    }

    public String showAllPosition(){
        return positionRepositories.showAllPosition().toString();
    };

    public String addNewPosition(Position position){
        boolean checkAdded = positionRepositories.addNewPosition(position);

        if (checkAdded) return "****Position was added to DB****";
        return "****Position was NOT added to DB****";
    };

    public String removePosition(String position){
        boolean checkRemoved = positionRepositories.removePosition(position);

        if (checkRemoved) return "****Position was removed from DB****";
        return "****Position was NOT removed from DB****";
    };
}
