/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Objects.Franquia;
import Objects.Pessoa;

/**
 *
 * @author Vinicius Augusto
 */
public class FranquiaDAO {

    private Franquia[] franquias;
    private int proximoID;

    public FranquiaDAO(int tamanhoMaximo) {
        this.franquias = new Franquia[tamanhoMaximo];
        this.proximoID = 1;

    }

    public int criarFranquia(Franquia franquia) {
        int id = this.proximoID++;
        franquia.setId(id);
        this.franquias[id - 1] = franquia;
        return id;
    }

    public Franquia buscarFranquia(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return null; // ID inválido
        }
        return this.franquias[id - 1];
    }

    public void atualizarFranquia(Franquia franquia) {
        if (franquia.getId() < 1 || franquia.getId() > this.proximoID - 1) {
            return; // ID inválido
        }
        this.franquias[franquia.getId() - 1] = franquia;
    }

    public void excluirFranquia(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return; // ID inválido
        }
        this.franquias[id - 1] = null;
    }

    public Franquia[] mostrarFranquias() {

        /* boolean temFranquias = false;
        for (Franquia f : this.franquias) {
            if (f != null) {
                System.out.println(f);
                temFranquias = true;
            }
        }
        if (!temFranquias) {
            System.out.println("não existe franquia cadastrada");
        }*/
        return this.franquias;

    }
    public Franquia[] mostrarFranquiaPorResponsavel(Pessoa responsavel){
        Franquia [] fran = new Franquia[franquias.length];
        int i =0;
        for(Franquia f : franquias){
            if(((f != null) && (f.getResponsavel().equals(responsavel)))){
                fran[i] = f;
                i++;
            }
        }
        return fran;
    }

    /*  public Franquia buscarFranquiasPorMedico(Medico medico, UnidadeFranquia[] unidadesFranquias) {
        
        Franquia[] franquiasMedico = new Franquia[100];
        
        for (Franquia franquia : franquias) {
            
            for (UnidadeFranquia unidadeFranquia : unidadesFranquias) {
                
                if (unidadeFranquia.getFranquia().equals(franquia)) {
                    
                }
                
            }
            
        }
        
        return null;
        
    }*/
}
