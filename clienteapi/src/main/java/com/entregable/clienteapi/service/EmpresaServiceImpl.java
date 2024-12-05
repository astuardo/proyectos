package com.entregable.clienteapi.service;

import com.entregable.clienteapi.entity.Empresa;
import com.entregable.clienteapi.exception.entidad.EntidadNoEncontradoException;
import com.entregable.clienteapi.repository.EmpresaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmpresaServiceImpl implements EmpresaService{

    @Autowired
    EmpresaRepository empresaRepository;

    public Empresa getEmpresa(Long id){
        Empresa empresaAObtener = empresaRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradoException("Empresa no encontrada con el id: " + id));
        return empresaAObtener;
    }

    public List<Empresa> traeEmpresas(){
        return empresaRepository.findAll();
    }

    public Empresa updEmpresa(Empresa empresa){
        Empresa empresaUpd = empresaRepository.findById(empresa.getId())
                .orElseThrow(() -> new EntidadNoEncontradoException("Empresa no encontrada con el id: " + empresa.getId()));
        empresaUpd.setNombre(empresa.getNombre());
        empresaUpd.setRubro(empresa.getRubro());
        return empresaRepository.save(empresa);
    }

    public Empresa addEmpresa(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public String delEmpresa(Long id){
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradoException("Empresa no encontrada con el id: " + id));
        empresaRepository.deleteById(id);
        return "Empresa Borrado: " + empresa.getNombre();
    }
}
