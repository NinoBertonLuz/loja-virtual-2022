package com.dev.backend.entity;
import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name= "produto")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank
    private String descricaoCurta;
   
    @NotBlank
    private String descricaoDetalhada;
    
    private Double valorCusto;
    
    private Double valorVenda;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_marca") 
    private Marca marca;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;


    
}
