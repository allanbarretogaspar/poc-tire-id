package br.com.sascar.poc.tireid.dtos;

import javax.validation.constraints.NotBlank;

public class LeitoraDTO {

    @NotBlank(message = "{leitora.nome.vazio}")
    private String nome;

    @NotBlank(message = "{leitora.endereco.vazio}")
    private String endereco;

    @NotBlank(message = "{leitora.categoria.vazio}")
    private String categoria;

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
