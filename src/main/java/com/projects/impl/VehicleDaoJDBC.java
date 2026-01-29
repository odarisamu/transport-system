package com.projects.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projects.dao.VehicleDAO;
import com.projects.database.Conection;
import com.projects.entities.Vehicle;

public class VehicleDaoJDBC implements VehicleDAO{
    
    @Override
    public void insert(Vehicle vehicle) {
        try(Connection connection = Conection.getConnection( );
              PreparedStatement statement = connection.prepareStatement("INSERT INTO vehicle(truckSign, maxWeight, numberAxles) " + 
              " VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, vehicle.getTruckSign());
            statement.setDouble(2, vehicle.getMaxWeight());
            statement.setInt(3, vehicle.getNumberAxles());
            statement.executeUpdate( );
            ResultSet result = statement.getGeneratedKeys();
            if(result.next( ))
                vehicle.setId(result.getInt(1));
            result.close( );
            System.out.println("Veiculo adicionado!!!");
        } catch(SQLException e){
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
        }
    }

    @Override
    public Vehicle findById(Integer id) {
        try(Connection connection = Conection.getConnection( );
               PreparedStatement statement = connection.prepareStatement("SELECT * FROM vehicle WHERE id = ?")){
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery( );
            if(result.next( )){
                return new Vehicle(result.getInt("id"), result.getString("truckSign"), result.getDouble("maxWeight"), 
                result.getInt("numberAxles"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
            return null;
        }
    }

    @Override
    public void update(Vehicle vehicle) {
        try(Connection connection = Conection.getConnection();
               PreparedStatement statement = connection.prepareStatement("UPDATE vehicle SET truckSign = ?, maxWeight = ?, numberAxles = ? " + 
               "WHERE id = ?")){
            statement.setString(1, vehicle.getTruckSign());
            statement.setDouble(2, vehicle.getMaxWeight());
            statement.setInt(3, vehicle.getNumberAxles());
            statement.setInt(4, vehicle.getId());
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0)
                System.out.println("Veiculo atualizado!!!");
        } catch (SQLException e) {
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
        }
    }

    @Override
    public void deleteById(Integer id) {
        try(Connection connection = Conection.getConnection();
              PreparedStatement statement = connection.prepareStatement("DELETE FROM vehicle WHERE id = ?")){
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0)
                System.out.println("Veiculo removido!!!");
        } catch (SQLException e) {
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
        }
    }

    @Override
    public List<Vehicle> listAll() {
        try(Connection connection = Conection.getConnection( );
               PreparedStatement statement = connection.prepareStatement("SELECT * FROM vehicle")){
            ResultSet result = statement.executeQuery();
            List<Vehicle> vehicles = new ArrayList<>();
            while(result.next( )){
                vehicles.add(new Vehicle(result.getInt("id"), result.getString("truckSign"), 
                result.getDouble("maxWeight"), result.getInt("numberAxles")));
            }
            return vehicles;
        } catch (SQLException e) {
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
            return null;
        }
    }
}
