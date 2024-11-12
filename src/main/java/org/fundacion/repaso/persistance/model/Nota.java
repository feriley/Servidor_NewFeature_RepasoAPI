package org.fundacion.repaso.persistance.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notas")
@Data
@NoArgsConstructor
public class Nota implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nota_id", nullable = false)
    private Long notaId;

    @Column(name="nombre_trabajo", nullable = false)
    private String nombreTrabajo;

    @Column(name="calificacion", nullable = false)
    private float calificacion;

    // Relación con Alumno (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumno_id", referencedColumnName = "alumno_id")  // Cambié el nombre de columna de alumno_alumno_id a alumno_id
    private Alumno alumnoCalificado;  // Usamos 'alumnoCalificado' para hacer referencia al alumno

    // Relación con Asignatura (N:1)
    @ManyToOne
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;
}
