package com.lab.moeda_estudantil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.moeda_estudantil.models.EmpresaParceira;
import com.lab.moeda_estudantil.repositories.EmpresaParceiraRepository;

import jakarta.transaction.Transactional;

@Service
public class EmpresaParceiraService {

    @Autowired
    private EmpresaParceiraRepository empresaParceiraRepository;

    public List<EmpresaParceira> findAll() {
        return empresaParceiraRepository.findAll();
    }

    public EmpresaParceira findById(Long id) {
        return empresaParceiraRepository.findById(id).orElse(null);
    }

    public EmpresaParceira findByNome(String nome) {
        return empresaParceiraRepository.findByNome(nome);
    }

    @Transactional
    public EmpresaParceira createEmpresaParceira(EmpresaParceira empresaParceira) {
        if (findByNome(empresaParceira.getNome()) != null) {
            throw new RuntimeException("Empresa Parceira já cadastrada");
        }
        return empresaParceiraRepository.save(empresaParceira);
    }

    @Transactional
    public EmpresaParceira updateEmpresaParceira(EmpresaParceira empresaParceira) {
        if (empresaParceira.getId() == null) {
            throw new RuntimeException("Id não informado");
        }
        return empresaParceiraRepository.save(empresaParceira);
    }

    @Transactional
    public void deleteEmpresaParceira(Long id) {
        if (findById(id) == null
                || empresaParceiraRepository.findById(id).get().getOfertas().size() > 0) {
            throw new RuntimeException("Empresa Parceira não encontrada ou possui ofertas cadastradas");
        }
        empresaParceiraRepository.deleteById(id);
    }

}
