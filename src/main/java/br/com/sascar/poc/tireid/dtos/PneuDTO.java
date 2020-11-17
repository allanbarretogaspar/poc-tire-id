package br.com.sascar.poc.tireid.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PneuDTO {

    @NotNull(message = "{pneu.fabricante.vazio}")
    private Integer fabricanteId;

    @NotBlank(message = "{pneu.modelo.vazio}")
    private String modelo;

    @NotBlank(message = "{pneu.dimensoes.vazio}")
    private String dimensoes;

    @NotBlank(message = "{pneu.numero.serie.vazio}")
    private String numeroSerie;

    @NotNull(message = "{pneu.data.fabricacao.vazio}")
    private LocalDate dataFabricacao;

    @NotBlank(message = "{pneu.nota.fiscal.vazio}")
    private String notaFiscal;

    @NotNull(message = "{pneu.data.compra.vazio}")
    private LocalDate dataCompra;

    @NotBlank(message = "{pneu.rfid.vazio}")
    private String pneuRfid;

    @NotBlank(message = "{pneu.marca.fogo.vazio}")
    private String marcaFogo;

    private Integer veiculoId;

    private Integer armazemId;

    private String posicaoMontagem;

    public Integer getFabricanteId() {
        return fabricanteId;
    }

    public void setFabricanteId(Integer fabricanteId) {
        this.fabricanteId = fabricanteId;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getPneuRfid() {
        return pneuRfid;
    }

    public void setPneuRfid(String pneuRfid) {
        this.pneuRfid = pneuRfid;
    }

    public String getMarcaFogo() {
        return marcaFogo;
    }

    public void setMarcaFogo(String marcaFogo) {
        this.marcaFogo = marcaFogo;
    }

    public Integer getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Integer veiculoId) {
        this.veiculoId = veiculoId;
    }

    public Integer getArmazemId() {
        return armazemId;
    }

    public void setArmazemId(Integer armazemId) {
        this.armazemId = armazemId;
    }

    public String getPosicaoMontagem() {
        return posicaoMontagem;
    }

    public void setPosicaoMontagem(String posicaoMontagem) {
        this.posicaoMontagem = posicaoMontagem;
    }
}
