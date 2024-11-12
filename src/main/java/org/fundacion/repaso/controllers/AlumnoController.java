package org.fundacion.repaso.controllers;

import java.sql.Date;
import java.util.List;

import org.fundacion.repaso.dto.AlumnoDTO;
import org.fundacion.repaso.dto.AsignaturaDTO;
import org.fundacion.repaso.dto.CrearAlumnoDTO;
import org.fundacion.repaso.services.AlumnoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/alumno")
@CrossOrigin
public class AlumnoController {

    @Autowired
    AlumnoServiceI alumnoMngmnt;

    @GetMapping("/selectWhereEmail/{email}")
    public AlumnoDTO selectWhereEmail(@PathVariable String email) {
        return alumnoMngmnt.getAlumnoByEmail(email);
    }

    @GetMapping("/selectWhereBirthdate/{from_date}/{to_date}")
    public List<AlumnoDTO> getMethodName(@PathVariable("from_date") Date from_date, @PathVariable("to_date") Date to_date) {
        return alumnoMngmnt.getAlumnosBetweenBirthdates(from_date, to_date);
    }

    @PostMapping("/insert")
    public void insertAlumno(@RequestBody CrearAlumnoDTO alumno) {
        alumnoMngmnt.insertAlumno(alumno);
    }

    // Nuevo endpoint para obtener asignaturas con notas filtradas
    @GetMapping("/{alumnoId}/asignaturas")
    public List<AsignaturaDTO> getAsignaturasWithNotas(@PathVariable Long alumnoId) {
        return alumnoMngmnt.getAsignaturasByAlumno(alumnoId);
    }
}
