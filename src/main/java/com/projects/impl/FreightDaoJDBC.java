package com.projects.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projects.dao.FreightDAO;
import com.projects.database.Conection;
import com.projects.entities.Freight;


public class FreightDaoJDBC implements FreightDAO{
    
    @Override
    public void changePayment(Integer id) {
        try(Connection connection = Conection.getConnection();
                PreparedStatement statement = connection.prepareStatement("UPDATE Freight SET payment = ? WHERE = ?")){
            statement.setBoolean(1, true);
            statement.setInt(2, id);
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0)
                System.out.println("Pagamento atualizado!");
        } catch (SQLException e) {
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
        }
    }

    @Override
    public List<Freight> findNotPaid() {
        try (Connection connection = Conection.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Vehicle WHERE payment = ?")){
            statement.setBoolean(1, false);
            ResultSet result = statement.executeQuery( );
            List<Freight> notPaids = new ArrayList<>();
            while(result.next( )){
                notPaids.add(new Freight(result.getInt("id"), result.getInt("idDriver"), result.getInt("idVehicle"),
                result.getDouble("value"), result.getString("placeOrigin"), result.getString("placeDestiny"),
                result.getBoolean("payment"), result.getDouble("weight"), result.getString("freightType")));
            }
            return notPaids;
        } catch (SQLException e) {
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
            return null;
        }
    }

    @Override
    public List<Freight> findPaid() {
        try (Connection connection = Conection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Vehicle WHERE payment = ?")){
            statement.setBoolean(1, true);
            ResultSet result = statement.executeQuery( );
            List<Freight> paids = new ArrayList<>();
            while(result.next( )){
                paids.add(new Freight(result.getInt("id"), result.getInt("idDriver"), result.getInt("idVehicle"),
                result.getDouble("value"), result.getString("placeOrigin"), result.getString("placeDestiny"),
                result.getBoolean("payment"), result.getDouble("weight"), result.getString("freightType")));
            }
            return paids;
        } catch (SQLException e) {
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
            return null;
        }
    }

    @Override
    public List<Freight> listAll() {
        try (Connection connection = Conection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Vehicle")){
            ResultSet result = statement.executeQuery( );
            List<Freight> vehicles = new ArrayList<>();
            while(result.next( )){
                vehicles.add(new Freight(result.getInt("id"), result.getInt("idDriver"), result.getInt("idVehicle"),
                result.getDouble("value"), result.getString("placeOrigin"), result.getString("placeDestiny"),
                result.getBoolean("payment"), result.getDouble("weight"), result.getString("freightType")));
            }
            return vehicles;
        } catch (SQLException e) {
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
            return null;
        }
    }

    @Override
    public void insert(Freight freight) {
        try(Connection connection = Conection.getConnection();
               PreparedStatement statement = connection.prepareStatement("INSERT INTO Freight(idDriver, idVehicle, value, " + 
               "placeOrigin, placeDestiny, payment, weight, freightType) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)){
            statement.setInt(1, freight.getIdDriver());
            statement.setInt(2, freight.getIdVehicle());
            statement.setDouble(3, freight.getValue());
            statement.setString(4, freight.getPlaceOrigin());
            statement.setString(5, freight.getPlaceDestiny());
            statement.setBoolean(6, freight.getPayment());
            statement.setDouble(7, freight.getWeight( ));
            statement.setString(8, freight.getType());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if(result.next()){
                freight.setId(result.getInt("id"));
            }
            System.out.println("Frete adicionado!!!");
        } catch(SQLException e){
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
        }
    }

    @Override
    public void update(Freight freight) {
        try(Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE Freight SET idDriver = ?, idVehicle = ?, value = ?, " + 
            "placeOrigin = ?, placeDestiny = ?, payment = ?, weight = ?, freightType = ? WHERE id = ?")){
            statement.setInt(1, freight.getIdDriver());
            statement.setInt(2, freight.getIdVehicle());
            statement.setDouble(3, freight.getValue());
            statement.setString(4, freight.getPlaceOrigin());
            statement.setString(5, freight.getPlaceDestiny());
            statement.setBoolean(6, freight.getPayment());
            statement.setDouble(7, freight.getWeight( ));
            statement.setString(8, freight.getType());
            statement.setInt(9, freight.getId());
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0)
                System.out.println("Frete atualizado!!!");
        } catch(SQLException e){
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
        }
    }

    @Override
    public void deleteById(Integer id) {
        try(Connection connection = Conection.getConnection();
               PreparedStatement statement = connection.prepareStatement("DELETE FROM Freight WHERE id = ?")){
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0)
                System.out.println("Frete removido!!!");
        } catch(SQLException e){
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");    
        }
    }

    @Override
    public Freight findById(Integer id) {
        try(Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Freight WHERE id = ?")){
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                return new Freight(result.getInt("id"), result.getInt("idDriver"), result.getInt("idVehicle"),
                result.getDouble("value"), result.getString("placeOrigin"), result.getString("placeDestiny"),
                result.getBoolean("payment"), result.getDouble("weight"), result.getString("freightType"));
            }
            return null;
        } catch(SQLException e){
            e.printStackTrace( );
            System.err.println("Erro na interacao com o banco de dados.");
            return null;    
        }
    }
}
