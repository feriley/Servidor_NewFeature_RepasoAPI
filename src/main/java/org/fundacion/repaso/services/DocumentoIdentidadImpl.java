package org.fundacion.repaso.services;

import java.util.ArrayList;
import java.util.List;

import org.fundacion.repaso.dto.DocumentoIdentidadDTO;
import org.fundacion.repaso.persistance.model.DocumentoIdentidad;
import org.fundacion.repaso.persistance.repository.DocumentoIdentidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentoIdentidadImpl implements DocumentoIdentidadServiceI {

    @Autowired
    DocumentoIdentidadRepository docRepo;

    @Override
    public List<DocumentoIdentidadDTO> getAllDocuments() {
        List<DocumentoIdentidad> docList = docRepo.findAll();
        List<DocumentoIdentidadDTO> docDTOList = new ArrayList<DocumentoIdentidadDTO>();

        for (DocumentoIdentidad documentoIdentidad : docList) {
            docDTOList.add(new DocumentoIdentidadDTO(documentoIdentidad));            
        }

        return docDTOList;
    }
    
}
