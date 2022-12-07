package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.dev.backend.entity.Categoria;
import com.dev.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodos(){
        return categoriaRepository.findAll();        
    } 

    public Categoria inserir(Categoria categoria){
        categoria.setDataCriacao(new Date());
        Categoria categoriaNova = categoriaRepository.saveAndFlush(categoria);
        return categoriaNova;
    }

    public Categoria alterar( Categoria categoria){
        categoria.setDataAtualizacao(new Date());
        return categoriaRepository.saveAndFlush(categoria);

    }

    public void excluir(Long id){
        Categoria categoria = categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria);
    }
    }


    
}
