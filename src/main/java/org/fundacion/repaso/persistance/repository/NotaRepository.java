package org.fundacion.repaso.persistance.repository;

import org.fundacion.repaso.persistance.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByAlumnoCalificado_AlumnoId(Long alumnoId);  // Cambié el nombre del campo a 'alumnoCalificado'
    
    List<Nota> findByAlumnoCalificado_AlumnoIdAndAsignatura_AsignaturaId(Long alumnoId, Long asignaturaId);
}
