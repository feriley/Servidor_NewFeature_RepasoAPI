package org.fundacion.repaso.persistance.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documentos_identidad")
@Data
@NoArgsConstructor
public class DocumentoIdentidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="documento_id", nullable = false)
    private Long documentoId;

    @Column(name="document_number")
    private String documentNumber;

    @Column(name="document_letter")
    private String documentLetter;

    @OneToOne
    @JoinColumn(name="alumno_alumno_id", referencedColumnName = "alumno_id")
    private Alumno persona;
}
