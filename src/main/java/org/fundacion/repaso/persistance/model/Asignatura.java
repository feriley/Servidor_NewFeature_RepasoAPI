package org.fundacion.repaso.persistance.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "asignaturas")
@Data
@NoArgsConstructor
public class Asignatura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="asignatura_id", nullable = false)
    private Long asignaturaId;

    @Column(name="asignatura_name", length = 45, nullable = false)
    private String asignaturaName;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy="asignaturasMatriculadas")
    private List<Alumno> alumnosMatriculados;
}
