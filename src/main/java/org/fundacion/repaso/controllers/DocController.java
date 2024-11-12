package org.fundacion.repaso.controllers;

import java.util.List;

import org.fundacion.repaso.dto.DocumentoIdentidadDTO;
import org.fundacion.repaso.services.DocumentoIdentidadServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/doc")
@CrossOrigin
public class DocController {

    @Autowired
    DocumentoIdentidadServiceI docMngmnt;
    
    @GetMapping("/")
    public List<DocumentoIdentidadDTO> getAll() {
        return docMngmnt.getAllDocuments();
    }
    
}
