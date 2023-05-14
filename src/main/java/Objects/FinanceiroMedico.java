/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Vinicius Augusto
 */
public class FinanceiroMedico {

    private int id;
    private double valor;
    private Medico medico;
    private EstadoFinanceiroMedico estado;
    private Franquia franquia;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public FinanceiroMedico() {
        this.setDataCriacao();
        this.setDataModificacao(LocalDateTime.now());
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public Medico getMedico() {
        return medico;
    }

    public EstadoFinanceiroMedico getEstado() {
        return estado;
    }

    public Franquia getFranquia() {
        return franquia;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    @Override
    public String toString() {
        return "FinanceiroMedico{" + "id=" + id + ", valor=" + valor + ", medico=" + medico.toString() + ", estado=" + estado + ", franquia=" + franquia.toString() + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setEstado(EstadoFinanceiroMedico estado) {
        this.estado = estado;
    }

    public void setFranquia(Franquia franquia) {
        this.franquia = franquia;
    }

    public void setDataCriacao() {
        this.dataCriacao = LocalDateTime.now();
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    
}
