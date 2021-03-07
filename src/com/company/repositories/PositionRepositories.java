package com.company.repositories;

import com.company.data.interfaces.IDBManager;
import com.company.entities.Position;
import com.company.repositories.interfaces.IPositionRepositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PositionRepositories implements IPositionRepositories {
    private final IDBManager dbManager;

    public PositionRepositories(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    //Logic of all methods with using postgresql query
    @Override

    //to show all table We take it from from DB, create arraylist to save the positions and return this arraylist

    public ArrayList<Position> showAllPosition() {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM position");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Position> positions = new ArrayList<>();

            while (resultSet.next()) {
                Position position = new Position(resultSet.getString("position"),
                        resultSet.getInt("salary"));
                positions.add(position);
            }

            return positions;

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addNewPosition(Position position) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO position(position, salary) VALUES (?, ?)");
            preparedStatement.setString(1, position.getPosition());
            preparedStatement.setInt(2, position.getSalary());

            preparedStatement.execute();
            return true;
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removePosition(String position) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM position WHERE position =?");
            preparedStatement.setString(1, position);
            preparedStatement.execute();
            return true;
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
