package br.com.sascar.poc.tireid.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="fabricante")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fabricante_id")
    private Integer fabricanteId;

    @Column(name = "nome")
    private String nome;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="fabricante", orphanRemoval = true)
    private List<Pneu> pneus = new ArrayList<>();

    public Fabricante() {

    }

    public Fabricante(Integer fabricanteId, String nome, List<Pneu> pneus) {
        this.fabricanteId = fabricanteId;
        this.nome = nome;
        this.pneus = pneus;
    }

    public Integer getFabricanteId() {
        return fabricanteId;
    }

    public void setFabricanteId(Integer fabricanteId) {
        this.fabricanteId = fabricanteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonBackReference
    public List<Pneu> getPneus() {
        return pneus;
    }

    public void setPneus(List<Pneu> pneus) {
        this.pneus = pneus;
    }
}
