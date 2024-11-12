package org.fundacion.repaso.persistance.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alumnos")
@Data
@NoArgsConstructor
public class Alumno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="alumno_id", nullable = false)
    private Long alumnoId;

    @Column(name="alumno_name", length = 45, nullable = false)
    private String alumnoName;

    @Column(name="alumno_surname", length = 90, nullable = false)
    private String alumnoSurname;

    @Column(name="alumno_email", length = 45, unique = true)
    private String alumnoEmail;

    @Column(name="birth_date")
    private Date birthDate;

    @OneToOne(mappedBy = "persona", fetch= FetchType.LAZY, cascade=CascadeType.ALL, optional = false)
    private DocumentoIdentidad dni;

    @OneToMany(fetch= FetchType.LAZY, mappedBy="alumnoCalificado")
    private List<Nota> notas;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="alumno_matriculado_asignatura", joinColumns={@JoinColumn(name="alumnos_alumno_id")}, inverseJoinColumns={@JoinColumn(name="asignaturas_asignatura_id")})
    List<Asignatura> asignaturasMatriculadas;
    
}
