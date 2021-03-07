package com.company.repositories.interfaces;

import com.company.entities.Position;

import java.util.ArrayList;

public interface IPositionRepositories {
    //methods list which id used for option in MyApplication class
    public ArrayList<Position> showAllPosition();
    public boolean addNewPosition(Position position);
    public boolean removePosition(String position);
}
