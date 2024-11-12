package org.fundacion.repaso.persistance.repository;

import org.fundacion.repaso.persistance.model.DocumentoIdentidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoIdentidadRepository extends JpaRepository<DocumentoIdentidad, Long>{
    
}
