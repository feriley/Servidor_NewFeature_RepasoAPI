package org.fundacion.repaso.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.fundacion.repaso.persistance.model.Alumno;
import org.fundacion.repaso.persistance.model.Nota;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlumnoDTO {

    private Long alumnoId;
    private String alumnoName;
    private String alumnoSurname;
    private String alumnoEmail;
    private Date birthDate;
    private String dni;
    private List<NotaDTO> notas;

    public AlumnoDTO(Alumno al) {
        this.alumnoId = al.getAlumnoId();
        this.alumnoName = al.getAlumnoName();
        this.alumnoSurname = al.getAlumnoSurname();
        this.alumnoEmail = al.getAlumnoEmail();
        this.birthDate = al.getBirthDate();
        this.dni = al.getDni().getDocumentNumber() + al.getDni().getDocumentLetter();
        this.notas = toNotasDTO(al.getNotas());
    }

    public List<NotaDTO> toNotasDTO(List<Nota> notas) {
        List<NotaDTO> notasCalificadas = new ArrayList<NotaDTO>();
        for (Nota s : notas) {
            notasCalificadas.add(new NotaDTO(s));
        }
        return notasCalificadas;
    }
}
