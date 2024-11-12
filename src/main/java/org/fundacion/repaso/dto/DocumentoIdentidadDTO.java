package org.fundacion.repaso.dto;

import org.fundacion.repaso.persistance.model.DocumentoIdentidad;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocumentoIdentidadDTO {

    private Long documentoId;
    private String documentNumber;
    private String documentLetter;
    private AlumnoDTO persona;

    public DocumentoIdentidadDTO(DocumentoIdentidad dni) {
        this.documentoId = dni.getDocumentoId();
        this.documentNumber = dni.getDocumentNumber();
        this.documentLetter = dni.getDocumentLetter();
        this.persona = new AlumnoDTO(dni.getPersona());
    }
}
