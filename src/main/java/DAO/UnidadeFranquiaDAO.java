package DAO;
import Objects.UnidadeFranquia;

public class UnidadeFranquiaDAO {
    private UnidadeFranquia[] unidades;
    private int proximoID;

    public UnidadeFranquiaDAO(int tamanhoMaximo) {
        this.unidades = new UnidadeFranquia[tamanhoMaximo];
        this.proximoID = 1;

    }

    public int criarFranquia(UnidadeFranquia unidade) {
        int id = this.proximoID++;
        unidade.setId(id);
        this.unidades[id - 1] = unidade;
        return id;
    }

    public UnidadeFranquia buscarFranquia(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return null; // ID inválido
        }
        return this.unidades[id - 1];
    }

    
    public void atualizarFranquia(UnidadeFranquia unidade) {
        if (unidade.getId() < 1 || unidade.getId() > this.proximoID - 1) {
            return; // ID inválido
        }
        this.unidades[unidade.getId() - 1] = unidade;
    }

    public void excluirFranquia(int id) {
        if (id < 1 || id > this.proximoID - 1) {
            return; // ID inválido
        }
        this.unidades[id - 1] = null;
    }

    public void mostrarFranquias() {

        boolean temUnidades = false;
        for (UnidadeFranquia f : this.unidades) {
            if (f != null) {
                System.out.println(f);
                temUnidades = true;
            }
        }
        if (!temUnidades) {
            System.out.println("não existe unidade cadastrada");
        }

    }
}
