/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.time.LocalDateTime;

/**
 *
 * @author Vinicius Augusto
 */
public class Medico {

    private int id;
    private String crm;
    private Pessoa pessoa;
    private String especialidade;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Medico() {
        this.setDataCriacao();
        this.setDataModificacao(LocalDateTime.now());
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setDataCriacao() {
        this.dataCriacao = LocalDateTime.now();
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "Medico{" + "id=" + id + ", crm=" + crm + ", pessoa=" + pessoa.toString() + ", especialidade=" + especialidade + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    public int getId() {
        return id;
    }

    public String getCrm() {
        return crm;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

}
