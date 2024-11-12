package org.fundacion.repaso.services;

import java.util.ArrayList;
import java.util.List;

import org.fundacion.repaso.dto.AsignaturaDTO;
import org.fundacion.repaso.persistance.model.Asignatura;
import org.fundacion.repaso.persistance.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaServiceImpl implements AsignaturaServiceI{

    @Autowired
    private AsignaturaRepository asignaturaRepo;


    @Override
    public List<AsignaturaDTO> getAsignaturas() {
        List<Asignatura> asignaturaList = asignaturaRepo.findAll();
        List<AsignaturaDTO> asignaturaDTOList = new ArrayList<AsignaturaDTO>();
        for (Asignatura asignatura : asignaturaList) {
            asignaturaDTOList.add(new AsignaturaDTO(asignatura));
        }
        return asignaturaDTOList;
    }
    
}
