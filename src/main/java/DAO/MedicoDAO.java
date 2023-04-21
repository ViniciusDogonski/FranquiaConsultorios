/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Objects.Medico;

/**
 *
 * @author Vinicius Augusto
 */
public class MedicoDAO {

    private Medico[] medicos;
    private int proximoID;

    public MedicoDAO(int tamanhoMaximo) {
        this.medicos = new Medico[tamanhoMaximo];
        this.proximoID = 1;
    }

     public int criarMedico(Medico medico) {
        int id = this.proximoID++;
        medico.setId(id);
        this.medicos[id - 1] = medico;
        return id;
    }

   
    
    //
     
       public void mostrarMedicos() {

        boolean temMedicos = false;
        for (Medico m : medicos) {
            if (m != null) {
                System.out.println(m);
                temMedicos = true;
            }
        }
        if (!temMedicos) {
            System.out.println("não existe medicos cadastrado");
        }

    }
     
}
