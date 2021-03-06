package com.company.repositories.interfaces;

import com.company.entities.Position;

import java.util.ArrayList;

public interface IPositionRepositories {
    public ArrayList<Position> showAllPosition();
    public boolean addNewPosition(Position position);
    public boolean removePosition(String position);
}
