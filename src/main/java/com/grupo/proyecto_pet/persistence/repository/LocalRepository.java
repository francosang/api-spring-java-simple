package com.grupo.proyecto_pet.persistence.repository;

import com.grupo.proyecto_pet.persistence.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Franco on 5/21/2017.
 */
@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {

    @Query("SELECT e.id, e.nombre FROM local e")
    List<Object[]> findKeyValues();
}