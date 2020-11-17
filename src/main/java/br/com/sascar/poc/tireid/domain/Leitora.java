package br.com.sascar.poc.tireid.domain;

import javax.persistence.*;

@Entity
@Table(name="leitora")
public class Leitora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leitora_id")
    private Integer leitoraId;

    private String nome;

    private String endereco;

    private String categoria;

    public Leitora() { }

    public Leitora(Integer leitoraId, String nome, String endereco, String categoria) {
        this.leitoraId = leitoraId;
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
    }

    public Integer getLeitoraId() {
        return leitoraId;
    }

    public void setLeitoraId(Integer leitoraId) {
        this.leitoraId = leitoraId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
