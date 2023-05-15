/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

import Objects.Estados;
import Objects.Medico;
import Objects.Pessoa;
import java.util.Objects;

/**
 *
 * @author Vinicius Augusto
 */
public class Consulta {

    private int id;
    private LocalDate data; //dia
    private LocalTime horario;

    private Estados estado;

    private Medico medico;
    private Pessoa paciente;
    private double valor;

    //private unidade unidade
    private UnidadeFranquia unidade;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Consulta() {
        this.setDataCriacao(dataCriacao);
        this.setDataModificacao(LocalDateTime.now());
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

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public void setUnidade (UnidadeFranquia unidade){
        this.unidade = unidade;
    }
    public void setPaciente(Pessoa paciente) {
        this.paciente = paciente;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "Consulta{" + "id=" + id + ", data=" + data + ", horario=" + horario + ", estado=" + estado + ", medico=" + medico.toString() + ", paciente=" + paciente.toString() + "Unidade= " + unidade.toString() + ", valor=" + valor + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
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

    public Estados getEstado() {
        return estado;
    }

    public Medico getMedico() {
        return medico;
    }

    public Pessoa getPaciente() {
        return paciente;
    }
    public UnidadeFranquia getUnidade(){
        return this.unidade;
    }
    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.medico, other.medico)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        return Objects.equals(this.unidade, other.unidade);
    }

  
   

}
