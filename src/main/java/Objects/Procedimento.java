/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

/**
 *
 * @author Vinicius Augusto
 */
public class Procedimento {

    private int id;
    private LocalDate data; //dia
    private LocalTime horario;
    private Consulta consulta;
    private Estados estado;
    private double valor;
    private String laudo;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Procedimento() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
    public void setConsulta(Consulta consulta){
        this.consulta = consulta;
    }
    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "Procedimento{" + "id=" + id + ", data=" + data + ", horario=" + horario + ", estado=" + estado + ", valor=" + valor + ", laudo=" + laudo + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHorario() {
        return horario;
    }
    public Consulta getConsulta(){
        return this.consulta;
    }
    public Estados getEstado() {
        return estado;
    }

    public double getValor() {
        return valor;
    }

    public String getLaudo() {
        return laudo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

}
