package org.fundacion.repaso.dto;

import java.util.ArrayList;
import java.util.List;

import org.fundacion.repaso.persistance.model.Alumno;
import org.fundacion.repaso.persistance.model.Asignatura;
import org.fundacion.repaso.persistance.model.Nota;
import org.fundacion.repaso.persistance.repository.NotaRepository;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AsignaturaDTO {
    private Long id;
    private String asignaturaName;
    private List<AlumnoDTO> alumnosMat;
    private List<NotaDTO> notas;

    // Constructor para AsignaturaServiceImpl que solo necesita Asignatura
    public AsignaturaDTO(Asignatura asignatura) {
        this.id = asignatura.getAsignaturaId();
        this.asignaturaName = asignatura.getAsignaturaName();
        this.alumnosMat = toAlumnoDTO(asignatura.getAlumnosMatriculados());
        this.notas = new ArrayList<>(); // Inicializa notas vacías por compatibilidad
    }

    // Constructor que usa NotaRepository y alumnoId para filtrar notas en AsignaturaDTO
    public AsignaturaDTO(Asignatura asignatura, Long alumnoId, NotaRepository notaRepository) {
        this.id = asignatura.getAsignaturaId();
        this.asignaturaName = asignatura.getAsignaturaName();
        this.alumnosMat = toAlumnoDTO(asignatura.getAlumnosMatriculados());
        this.notas = toNotasDTO(notaRepository.findByAlumnoCalificado_AlumnoIdAndAsignatura_AsignaturaId(alumnoId, asignatura.getAsignaturaId()));
    }

    // Métodos de ayuda
    private List<AlumnoDTO> toAlumnoDTO(List<Alumno> alumnos) {
        List<AlumnoDTO> alumnosDTO = new ArrayList<>();
        for (Alumno a : alumnos) {
            alumnosDTO.add(new AlumnoDTO(a));
        }
        return alumnosDTO;
    }

    private List<NotaDTO> toNotasDTO(List<Nota> notas) {
        List<NotaDTO> notasDTO = new ArrayList<>();
        for (Nota n : notas) {
            notasDTO.add(new NotaDTO(n));
        }
        return notasDTO;
    }
}
