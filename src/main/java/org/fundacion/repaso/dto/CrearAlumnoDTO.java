package org.fundacion.repaso.dto;

import java.sql.Date;

import org.fundacion.repaso.persistance.model.Alumno;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CrearAlumnoDTO {

    private Long alumnoId;
    private String alumnoName;
    private String alumnoSurname;
    private String alumnoEmail;
    private Date birthDate;

    public CrearAlumnoDTO(Alumno al) {
        this.alumnoId = al.getAlumnoId();
        this.alumnoName = al.getAlumnoName();
        this.alumnoSurname = al.getAlumnoSurname();
        this.alumnoEmail = al.getAlumnoEmail();
        this.birthDate = al.getBirthDate();
    }
}
