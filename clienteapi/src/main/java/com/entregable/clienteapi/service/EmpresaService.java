package com.entregable.clienteapi.service;

import com.entregable.clienteapi.entity.Empresa;

import java.util.List;

public interface EmpresaService {

    //Get
    Empresa getEmpresa(Long id);
    List<Empresa> traeEmpresas();
    //Put
    Empresa updEmpresa(Empresa empresa);
    //Post
    Empresa addEmpresa(Empresa empresa);
    //Delete
    String delEmpresa(Long id);
}
