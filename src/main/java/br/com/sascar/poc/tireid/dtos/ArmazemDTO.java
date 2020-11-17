package br.com.sascar.poc.tireid.dtos;

import javax.validation.constraints.NotBlank;

public class ArmazemDTO {

    @NotBlank(message = "{armazem.nome.vazio}")
    private String nome;

    @NotBlank(message = "{armazem.observacoes.vazio}")
    private String observacoes;

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
}
