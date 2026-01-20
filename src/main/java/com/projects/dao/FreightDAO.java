package com.projects.dao;
import java.util.List;

import com.projects.entities.Freight;

public interface FreightDAO {
    void changePayment( );
    List<Freight> findNotPaid( );
    List<Freight> findPaid( );
    List<Freight> listAll( );
    void insert(Freight freight);
    void update(Freight freight);
    void deleteById(Integer id);
    void findById(Integer id);
}
