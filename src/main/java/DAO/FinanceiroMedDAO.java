package DAO;


import Objects.FinanceiroMed;
import Objects.Medico;


public class FinanceiroMedDAO{
    private FinanceiroMed[] financas;
    private int proximoID;


    public FinanceiroMedDAO(int tamanho) {
        this.financas = new FinanceiroMed[tamanho];
        this.proximoID = 1;
    }

    public int cadastrarFinanca(FinanceiroMed financa) {
        int id = this.proximoID++;
        financa.setId(id);
        this.financas[id - 1] = financa;
        return id;
    }

    public void excluirFinanca(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return; // ID inválido
        }
        this.financas[id - 1] = null;
    }

    public FinanceiroMed buscarFinancas(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return null; // ID inválido
        }
        return this.financas[id - 1];
    }

    public void editarFinanca(FinanceiroMed financaAtualizada) {
        if (financaAtualizada.getId() < 1 || financaAtualizada.getId() > this.proximoID - 1) {
            return; // ID inválido
        }
        this.financas[financaAtualizada.getId() - 1] = financaAtualizada;
    }

    public void mostrarFinancas() {

        boolean temMedicos = false;
        for (FinanceiroMed m : financas) {
            if (m != null) {
                System.out.println(m);
                temMedicos = true;
      
            }
        }
        if (!temMedicos) {
            System.out.println("não existem finanças cadastradas");
        }
       
    }
   
}