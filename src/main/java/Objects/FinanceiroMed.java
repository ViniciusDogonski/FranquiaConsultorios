package Objects;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FinanceiroMed {
    private int id;
    private BigDecimal valor;
    private Medico medico;
    private EstadoFinanceiro estado;
    private Franquia franquia;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public FinanceiroMed(){
        this.setDataCriacao();
        this.setDataModificacao( LocalDateTime.now());
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public BigDecimal getValor(){
        return this.valor;
    }
    public void setValor(BigDecimal valor){
        this.valor = valor;
    }
    public Medico getMedico(){
        return this.medico;
    }
    public void setMedico(Medico medico){
        this.medico = medico;
    }
    public EstadoFinanceiro getEstado(){
        return this.estado;
    }
    public void setEstado(EstadoFinanceiro estado){
        this.estado = estado;
    }
    public Franquia getFranquia(){
       return this.franquia; 
    }
    public void setFraquia(Franquia franquia){
        this.franquia = franquia;
    }
    public LocalDateTime getDataCriacao(){
        return this.dataCriacao;
    }
    public void setDataCriacao(){
        this.dataCriacao = LocalDateTime.now();
    }
    public LocalDateTime getDataModificacao(){
        return this.dataModificacao;
    }
    public void setDataModificacao(LocalDateTime dataModificacao){
        this.dataModificacao = dataModificacao;
    }
}
