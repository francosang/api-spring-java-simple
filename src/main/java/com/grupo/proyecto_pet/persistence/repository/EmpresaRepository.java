package com.grupo.proyecto_pet.persistence.repository;


import com.grupo.proyecto_pet.persistence.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Franco on 5/21/2017.
 */
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query("SELECT e.id, e.nombre FROM empresa e")
    List<Object[]> findKeyValues();

}