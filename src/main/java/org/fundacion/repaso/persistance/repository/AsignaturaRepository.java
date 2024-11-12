package org.fundacion.repaso.persistance.repository;

import org.fundacion.repaso.persistance.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {

    
}
