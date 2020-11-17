package br.com.sascar.poc.tireid.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="armazem")
public class Armazem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "armazem_id")
    private Integer armazemId;

    private String nome;

    @Column(columnDefinition="TEXT")
    private String observacoes;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="armazem", orphanRemoval = true)
    private List<Pneu> pneus = new ArrayList<>();

    public Armazem() { }

    public Armazem(Integer armazemId, String nome, String observacoes, List<Pneu> pneus) {
        this.armazemId = armazemId;
        this.nome = nome;
        this.observacoes = observacoes;
        this.pneus = pneus;
    }

    public Integer getArmazemId() {
        return armazemId;
    }

    public void setArmazemId(Integer armazemId) {
        this.armazemId = armazemId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @JsonBackReference
    public List<Pneu> getPneus() {
        return pneus;
    }

    public void setPneus(List<Pneu> pneus) {
        this.pneus = pneus;
    }
}
