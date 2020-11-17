package br.com.sascar.poc.tireid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="pneu")
public class Pneu implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8833574532375774329L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pneu_id")
    private Integer pneuId;


    @ManyToOne()
    @JoinColumn(name = "fabricante_id", nullable = false, insertable = true, updatable = true)
    private Fabricante fabricante;

    private String modelo;

    private String dimensoes;

    @Column(name = "num_serie", length = 20)
    private String numeroSerie;

    @Column(name = "data_fabricacao", columnDefinition = "DATE")
    private LocalDate dataFabricacao;

    @Column(name = "nota_fiscal", length = 50)
    private String notaFiscal;

    @Column(name = "data_compra", columnDefinition = "DATE")
    private LocalDate dataCompra;

    @Column(name = "pneu_rfid", length = 30)
    private String pneuRfid;

    @Column(name = "marca_fogo", length = 10)
    private String marcaFogo;

    @ManyToOne()
    @JoinColumn(name = "veiculo_id", nullable = true, insertable = true, updatable = true)
    private Veiculo veiculo;

    @ManyToOne()
    @JoinColumn(name = "armazem_id", nullable = true, insertable = true, updatable = true)
    private Armazem armazem;

    @Column(name = "posicao_montagem", length = 20)
    private String posicaoMontagem;

    public Pneu() { }

    public Pneu(Integer pneuId, Fabricante fabricante, String modelo, String dimensoes, String numeroSerie,
                LocalDate dataFabricacao, String notaFiscal, LocalDate dataCompra, String pneuRfid,
                String marcaFogo, Veiculo veiculo, Armazem armazem, String posicaoMontagem) {
        this.pneuId = pneuId;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.dimensoes = dimensoes;
        this.numeroSerie = numeroSerie;
        this.dataFabricacao = dataFabricacao;
        this.notaFiscal = notaFiscal;
        this.dataCompra = dataCompra;
        this.pneuRfid = pneuRfid;
        this.marcaFogo = marcaFogo;
        this.veiculo = veiculo;
        this.armazem = armazem;
        this.posicaoMontagem = posicaoMontagem;
    }

    public Integer getPneuId() {
        return pneuId;
    }

    public void setPneuId(Integer pneuId) {
        this.pneuId = pneuId;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
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

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Armazem getArmazem() {
        return armazem;
    }

    public void setArmazem(Armazem armazem) {
        this.armazem = armazem;
    }

    public String getPosicaoMontagem() {
        return posicaoMontagem;
    }

    public void setPosicaoMontagem(String posicaoMontagem) {
        this.posicaoMontagem = posicaoMontagem;
    }
}
