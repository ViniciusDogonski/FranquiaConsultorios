/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Objects.Consulta;
import Objects.InfoConsulta;

/**
 *
 * @author Vinicius Augusto
 */
public class InfoConsultaDAO {

    private InfoConsulta[] InfosConsultas;
    private int proximoID;

    public InfoConsultaDAO(int tamanho) {
        this.InfosConsultas = new InfoConsulta[tamanho];
        this.proximoID = 1;
    }

    public int criarInfoConsulta(InfoConsulta Infoconsulta) {
        int id = this.proximoID++;
        Infoconsulta.setId(id);
        this.InfosConsultas[id - 1] = Infoconsulta;
        return id;
    }

    public void excluirInfoConsulta(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return; // ID invÃ¡lido
        }
        this.InfosConsultas[id - 1] = null;
    }

    public InfoConsulta buscarMedico(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return null; // ID invÃ¡lido
        }
        return this.InfosConsultas[id - 1];
    }

    public InfoConsulta buscarInfoConsulta(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return null; // ID invÃ¡lido
        }
        return this.InfosConsultas[id - 1];
    }

    public void atualizarInfoConsulta(InfoConsulta Infoconsulta) {
        if (Infoconsulta.getId() < 1 || Infoconsulta.getId() > this.proximoID - 1) {
            return; // ID invÃ¡lido
        }
        this.InfosConsultas[Infoconsulta.getId() - 1] = Infoconsulta;
    }

    public InfoConsulta[] mostrarInfoConsulta() {

        /*  boolean temMedicos = false;
        for (InfoConsulta m : InfosConsultas) {
            if (m != null) {
                System.out.println(m);
                temMedicos = true;
            }
        }
        if (!temMedicos) {
            System.out.println("nÃ£o existe informacoes cadastradas");
        }*/
        return this.InfosConsultas;

    }

    public InfoConsulta[] consultarInfoConsultasConsulta(Consulta consulta) {

        InfoConsulta[] InfoConsultaDaConsulta = new InfoConsulta[InfosConsultas.length];
        int index = 0;
        for (InfoConsulta infoConsulta : InfosConsultas) {
            if (infoConsulta != null && infoConsulta.getConsulta().equals(consulta)) {
                InfoConsultaDaConsulta[index] = infoConsulta;
                index++;
            }
        }

        return InfoConsultaDaConsulta;
    }

}
