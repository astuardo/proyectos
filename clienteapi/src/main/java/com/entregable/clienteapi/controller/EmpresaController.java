package com.entregable.clienteapi.controller;

import com.entregable.clienteapi.entity.Empresa;
import com.entregable.clienteapi.repository.EmpresaRepository;
import com.entregable.clienteapi.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping("/getEmpresa/{id}")
    public Empresa getEmpresa(@PathVariable(value = "id") Long id) {
        return empresaService.getEmpresa(id);
    }

    @GetMapping("/traeEmpresas")
    public List<Empresa> getEmpresa() {
        return empresaService.traeEmpresas();
    }

    @PostMapping("/addEmpresa")
    public Empresa addEmpresa(@Validated @RequestBody Empresa empresa){
        return empresaService.addEmpresa(empresa);
    }

    @PutMapping("/updEmpresa")
    public Empresa updEmpresa(@Validated @RequestBody Empresa empresa){
        return empresaService.updEmpresa(empresa);
    }

    @DeleteMapping("/delEmpresa/{id}")
    public String delEmpresa(@PathVariable("id") Long id){
        return empresaService.delEmpresa(id);
    }
}
