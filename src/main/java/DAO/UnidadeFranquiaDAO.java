/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Objects.Franquia;
import Objects.Pessoa;
import Objects.UnidadeFranquia;

/**
 *
 * @author Vinicius Augusto
 */
public class UnidadeFranquiaDAO {

    private UnidadeFranquia[] unidades;
    private int proximoID;

    public UnidadeFranquiaDAO(int tamanhoMaximo) {
        this.unidades = new UnidadeFranquia[tamanhoMaximo];
        this.proximoID = 1;

    }

    public int criarUnidade(UnidadeFranquia unidade) {
        int id = this.proximoID++;
        unidade.setId(id);
        this.unidades[id - 1] = unidade;
        return id;
    }

    public UnidadeFranquia buscarUnidade(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return null; // ID inválido
        }
        return this.unidades[id - 1];
    }

    public void atualizarUnidade(UnidadeFranquia unidade) {
        if (unidade.getId() < 1 || unidade.getId() > this.proximoID - 1) {
            return; // ID inválido
        }
        this.unidades[unidade.getId() - 1] = unidade;
    }

    public void excluirUnidade(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return; // ID inválido
        }
        this.unidades[id - 1] = null;
    }

    public UnidadeFranquia[] mostrarUnidades() {

        /*  boolean temUnidades = false;
        for (UnidadeFranquia f : this.unidades) {
            if (f != null) {
                System.out.println(f);
                temUnidades = true;
            }
        }
        if (!temUnidades) {
            System.out.println("não existe unidade cadastrada");
        }*/
        return this.unidades;

    }
    public UnidadeFranquia[] mostrarUnidadeResponsavel(Pessoa responsavel){
        UnidadeFranquia[] uniResp = new UnidadeFranquia[unidades.length];
        int i =0;
        for(UnidadeFranquia u : unidades){
            if(((u!= null) && (u.getResponsavel().equals(responsavel)))){
                uniResp[i] = u;
                i++;
            }
        }
        return uniResp;
    }
      public UnidadeFranquia[] mostrarUnidadePorFranquia(Franquia Franquia){
        UnidadeFranquia[] uniResp = new UnidadeFranquia[unidades.length];
        int i =0;
        for(UnidadeFranquia u : unidades){
            if(((u!= null) && (u.getFranquia().equals(Franquia)))){
                uniResp[i] = u;
                i++;
            }
        }
        return uniResp;
    }
}
