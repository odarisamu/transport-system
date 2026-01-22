package com.projects.dao;
import java.util.List;

import com.projects.entities.Freight;

public interface FreightDAO {
    void changePayment(Integer id);
    List<Freight> findNotPaid( );
    List<Freight> findPaid( );
    List<Freight> listAll( );
    void insert(Freight freight);
    void update(Freight freight);
    void deleteById(Integer id);
    Freight findById(Integer id);
}
