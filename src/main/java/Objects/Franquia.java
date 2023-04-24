package Objects;

import java.time.LocalDateTime;

public class Franquia {
    private int id;
    private String nome;
    private String cnpj;
    private String cidade;
    private String endereco;
    private Pessoa responsavel;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Franquia() {
        this.setDataCriacao();
        this.setDataModificacao( LocalDateTime.now());
    }

    public int getID() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setCidade(String cidade) {
        this.cidade= cidade;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public void setDataCriacao() {
        this.dataCriacao = LocalDateTime.now();
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Franquia{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cnpj=" + cnpj +  ",responsavel = "+ responsavel +", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    public int getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }
    public String getCidade() {
        return cidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }
 
}

