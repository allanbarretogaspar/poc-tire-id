package br.com.sascar.poc.tireid.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VeiculoDTO {

    @NotBlank(message = "{veiculo.modelo.vazio}")
    private String modelo;

    @NotBlank(message = "{veiculo.placa.vazio}")
    private String placa;

    @NotNull(message = "{veiculo.numero.frota.vazio}")
    private Integer numeroFrota;

    @NotNull(message = "{veiculo.numero.pneus.vazio}")
    private Integer numeroPneus;

    @NotBlank(message = "{veiculo.rfid.vazio}")
    private String veiculoRfid;

    @NotNull(message = "{veiculo.numero.eixos.vazio}")
    private Integer numeroEixos;

    @NotNull(message = "{veiculo.pneus.geminados.vazio}")
    private Boolean pneusGeminados;

    @NotNull(message = "{veiculo.numero.steps.vazio}")
    private Integer numeroSteps;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getNumeroFrota() {
        return numeroFrota;
    }

    public void setNumeroFrota(Integer numeroFrota) {
        this.numeroFrota = numeroFrota;
    }

    public Integer getNumeroPneus() {
        return numeroPneus;
    }

    public void setNumeroPneus(Integer numeroPneus) {
        this.numeroPneus = numeroPneus;
    }

    public String getVeiculoRfid() {
        return veiculoRfid;
    }

    public void setVeiculoRfid(String veiculoRfid) {
        this.veiculoRfid = veiculoRfid;
    }

    public Integer getNumeroEixos() {
        return numeroEixos;
    }

    public void setNumeroEixos(Integer numeroEixos) {
        this.numeroEixos = numeroEixos;
    }

    public Boolean getPneusGeminados() {
        return pneusGeminados;
    }

    public void setPneusGeminados(Boolean pneusGeminados) {
        this.pneusGeminados = pneusGeminados;
    }

    public Integer getNumeroSteps() {
        return numeroSteps;
    }

    public void setNumeroSteps(Integer numeroSteps) {
        this.numeroSteps = numeroSteps;
    }
}
