package com.projects.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.projects.dao.VehicleDAO;
import com.projects.database.Conection;
import com.projects.entities.Vehicle;

public class VehicleDaoJDBC implements VehicleDAO{
    
    @Override
    public void insert(Vehicle vehicle) {
        try(Connection connection = Conection.getConnection( );
              PreparedStatement statement = connection.prepareStatement("INSERT INTO Vehicle(truckSign, maxWeight, numberAxles) " + 
              " VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, vehicle.getTruckSign());
            statement.setDouble(2, vehicle.getMaxWeight());
            statement.setInt(3, vehicle.getNumberAxles());
            statement.executeUpdate( );
            ResultSet result = statement.getGeneratedKeys();
            if(result.next( ))
                vehicle.setId(result.getInt("id"));
            result.close( );
            System.out.println("Veiculo adicionado!!!");
        } catch(SQLException e){
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
        }
    }

    @Override
    public Vehicle findById(Integer id) {
        try(Connection connection = Conection.getConnection();
               PreparedStatement statement = connection.prepareStatement("SELECT * FROM Vehicle WHERE id = ?")){
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery( );
            if(result.next( ))
                return new Vehicle(null, null, id) //colocar mais um construtor com id aqui para retornar corretamente
            
        } catch (SQLException e) {
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
        }
    }

    @Override
    public void update(Vehicle vehicle) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Vehicle> listAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
