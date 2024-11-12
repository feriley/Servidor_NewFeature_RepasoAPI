package org.fundacion.repaso.persistance.repository;

import java.sql.Date;
import java.util.List;

import org.fundacion.repaso.persistance.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    Alumno findByAlumnoEmail(String email);
    List<Alumno> findByBirthDateAfterAndBirthDateBefore(Date from_date, Date to_date);

}
