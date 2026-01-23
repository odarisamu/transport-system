package com.projects.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projects.dao.DriverDAO;
import com.projects.database.Conection;
import com.projects.entities.Driver;


public class DriverDaoJDBC implements DriverDAO{

    @Override
    public List<Driver> listAll() {
        try(Connection connection = Conection.getConnection( );
               PreparedStatement statement = connection.prepareStatement("SELECT * FROM Driver")){
            ResultSet result = statement.executeQuery( );
            List<Driver> drivers = new ArrayList<>( );
            while(result.next( )){
                drivers.add(new Driver(result.getInt("id"), result.getString("cpf"), result.getString("name"),
                result.getDate("birthDate"), result.getString("licenseDriver"), result.getString("phone")));
            }
            result.close( );
            return drivers;
        } catch(SQLException e){
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
            return null;
        }
    }

    @Override
    public Driver findById(Integer id) {
        try(Connection connection = Conection.getConnection( );
              PreparedStatement statement = connection.prepareStatement("SELECT * FROM Driver WHERE id = ?")){
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery( );
            if(result.next( )){
                return new Driver(result.getInt("id"), result.getString("cpf"), result.getString("name"),
                result.getDate("birthDate"), result.getString("licenseDriver"), result.getString("phone"));
            }
            else{
                System.out.println("Sem motorista com esse id!!!");
                return null;
            }
        } catch(SQLException e){
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
            return null;
        }
    }

    @Override
    public void update(Driver driver) {
        try(Connection connection = Conection.getConnection();
               PreparedStatement statement = connection.prepareStatement("UPDATE Driver SET cpf = ?, name = ?, birthDate = ?, licenseDriver = ?, " +
               "phone = ? WHERE id = ?")){
            statement.setString(1, driver.getCpf());
            statement.setString(2, driver.getName());
            statement.setDate(3, driver.getBirthDate());
            statement.setString(4, driver.getLicenseDriver());
            statement.setString(5, driver.getPhone( ));
            statement.setInt(6, driver.getId());
            statement.executeUpdate();
            System.out.println("Motorista atualizado!!!");
        } catch(SQLException e){
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
        }
    }

    @Override
    public void insert(Driver driver) {
        try(Connection connection = Conection.getConnection( );
                PreparedStatement statement = connection.prepareStatement("INSERT INTO Driver(cpf, name, birthDate, licenseDriver, phone) VALUES " +
                    "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, driver.getCpf());
            statement.setString(2, driver.getName());
            statement.setDate(3, driver.getBirthDate());
            statement.setString(4, driver.getLicenseDriver());
            statement.setString(5, driver.getPhone());
            statement.executeUpdate( );
            ResultSet result = statement.getGeneratedKeys();
            if(result.next( ))
                driver.setId(result.getInt("id"));
            result.close( );
            System.out.println("Motorista adicionado!!!");
        } catch(SQLException e){
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
        }
    }

    @Override
    public void deleteById(Integer id) {
        try(Connection connection = Conection.getConnection();
              PreparedStatement statement = connection.prepareStatement("DELETE FROM Driver WHERE id = ?")){
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate( );
            if(rowsAffected == 1){
                System.out.println("Motorista removido!!!");
            }
        } catch(SQLException e) {
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
        }
    }
    
}
