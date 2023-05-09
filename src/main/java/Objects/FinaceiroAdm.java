package Objects;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FinaceiroAdm {
    private int id;
    private  TipoMovimento movimentacao;
    private BigDecimal valor;
    private UnidadeFranquia unidade;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public FinaceiroAdm(){
        this.setDataCriacao(dataCriacao);
        this.setDataModificacao(LocalDateTime.now());
        this.movimentacao= TipoMovimento.SAIDA;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public TipoMovimento getTipoMovimento(){
        return this.movimentacao;
    }
    public void setTipoMovimento(TipoMovimento movimentacao) {
        this.movimentacao = movimentacao;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public UnidadeFranquia getUnidade() {
        return this.unidade;
    }

    public void setUnidade(UnidadeFranquia unidade) {
        this.unidade = unidade;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
    @Override
    public String toString() {
        
        return "Franquia{" + "id=" + id + ", Tipo Movimentacao=" + movimentacao + ", valor=" + valor + ", unidade=" + unidade +  ",descricao = "+ descricao +", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
}
