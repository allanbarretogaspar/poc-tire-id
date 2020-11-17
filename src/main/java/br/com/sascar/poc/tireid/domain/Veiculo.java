package br.com.sascar.poc.tireid.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veiculo_id")
    private Integer veiculoId;

    private String modelo;

    private String placa;

    @Column(name = "num_frota")
    private Integer numeroFrota;

    @Column(name = "num_pneus")
    private Integer numeroPneus;

    @Column(name = "veiculo_rfid")
    private String veiculoRfid;

    @Column(name = "num_eixos")
    private Integer numeroEixos;

    @Column(name = "pneus_geminados")
    private Boolean pneusGeminados;

    @Column(name = "num_steps")
    private Integer numeroSteps;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="veiculo", orphanRemoval = true)
    private List<Pneu> pneus = new ArrayList<>();

    public Veiculo() { }

    public Veiculo(Integer veiculoId, String modelo, String placa, Integer numeroFrota, Integer numeroPneus,
                   String veiculoRfid, Integer numeroEixos, Boolean pneusGeminados, Integer numeroSteps, List<Pneu> pneus) {
        this.veiculoId = veiculoId;
        this.modelo = modelo;
        this.placa = placa;
        this.numeroFrota = numeroFrota;
        this.numeroPneus = numeroPneus;
        this.veiculoRfid = veiculoRfid;
        this.numeroEixos = numeroEixos;
        this.pneusGeminados = pneusGeminados;
        this.numeroSteps = numeroSteps;
        this.pneus = pneus;
    }

    public Integer getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Integer veiculoId) {
        this.veiculoId = veiculoId;
    }

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

    @JsonBackReference
    public List<Pneu> getPneus() {
        return pneus;
    }

    public void setPneus(List<Pneu> pneus) {
        this.pneus = pneus;
    }
}
