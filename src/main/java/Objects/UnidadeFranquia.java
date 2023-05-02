package Objects;

import java.time.LocalDateTime;

public class UnidadeFranquia {
    private Franquia franquia;
    private int id;
    private String cidade;
    private String endereco;
    private Pessoa responsavel;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao; 
    
     public UnidadeFranquia(){
        this.setDataCriacao();
        this.setDataModificacao(LocalDateTime.now());
    }
    public int getId(){
        return this.id;
    }
    public void setId(int idFranquia){
        this.id = idFranquia;

    }
    public Franquia getFranquia() {
        return franquia;
    }

    public void setFranquia(Franquia franquia) {
        this.franquia = franquia;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Pessoa getResponsavel() {
        return responsavel;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;

    }
    @Override
    public String toString() {
        return "UnidadeFranquia{" + "franquia=" + franquia + ", id=" + id + ", cidade=" + cidade + ", endereco=" + endereco + ", responsavel=" + responsavel + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
}
