package org.fundacion.repaso.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.fundacion.repaso.dto.AlumnoDTO;
import org.fundacion.repaso.dto.AsignaturaDTO;
import org.fundacion.repaso.dto.CrearAlumnoDTO;
import org.fundacion.repaso.persistance.model.Alumno;
import org.fundacion.repaso.persistance.model.Asignatura;
import org.fundacion.repaso.persistance.repository.AlumnoRepository;
import org.fundacion.repaso.persistance.repository.AsignaturaRepository;
import org.fundacion.repaso.persistance.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements AlumnoServiceI {

    @Autowired
    private AlumnoRepository alumnoRepo;

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private AsignaturaRepository asignaturaRepo;

    @Override
    public AlumnoDTO getAlumnoByEmail(String email) {
        return new AlumnoDTO(alumnoRepo.findByAlumnoEmail(email));
    }

    @Override
    public List<AlumnoDTO> getAlumnosBetweenBirthdates(Date from_date, Date to_date) {
        List<Alumno> alumnosList = alumnoRepo.findByBirthDateAfterAndBirthDateBefore(from_date, to_date);
        List<AlumnoDTO> alumnosDTOList = new ArrayList<>();

        for (Alumno alumno : alumnosList) {
            alumnosDTOList.add(new AlumnoDTO(alumno));
        }

        return alumnosDTOList;
    }

    @Override
    public void insertAlumno(CrearAlumnoDTO alumno) {
        String email = alumno.getAlumnoName() + "." + alumno.getAlumnoSurname().split(" ")[0] + "@a.vedrunasevillasj.es";
        
        Alumno newAlumno = new Alumno();
        newAlumno.setAlumnoId(alumno.getAlumnoId());
        newAlumno.setAlumnoName(alumno.getAlumnoName());
        newAlumno.setAlumnoSurname(alumno.getAlumnoSurname());
        newAlumno.setAlumnoEmail(email);
        newAlumno.setBirthDate(alumno.getBirthDate());
        
        alumnoRepo.save(newAlumno);
    }
    
    // Nuevo método para obtener asignaturas con notas filtradas
    public List<AsignaturaDTO> getAsignaturasByAlumno(Long alumnoId) {
        List<AsignaturaDTO> asignaturaDTOList = new ArrayList<>();
        List<Asignatura> asignaturas = asignaturaRepo.findAll();

        for (Asignatura asignatura : asignaturas) {
            AsignaturaDTO asignaturaDTO = new AsignaturaDTO(asignatura, alumnoId, notaRepository);
            asignaturaDTOList.add(asignaturaDTO);
        }
        return asignaturaDTOList;
    }
}
