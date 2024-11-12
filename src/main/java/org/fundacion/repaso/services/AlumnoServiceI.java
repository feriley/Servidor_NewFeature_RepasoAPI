package org.fundacion.repaso.services;

import java.sql.Date;
import java.util.List;
import org.fundacion.repaso.dto.AlumnoDTO;
import org.fundacion.repaso.dto.AsignaturaDTO;
import org.fundacion.repaso.dto.CrearAlumnoDTO;

public interface AlumnoServiceI {

    AlumnoDTO getAlumnoByEmail(String email);

    List<AlumnoDTO> getAlumnosBetweenBirthdates(Date from_date, Date to_date);

    void insertAlumno(CrearAlumnoDTO alumno);

    List<AsignaturaDTO> getAsignaturasByAlumno(Long alumnoId);
}
