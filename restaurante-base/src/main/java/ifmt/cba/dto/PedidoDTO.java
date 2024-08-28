package ifmt.cba.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PedidoDTO {

    private int codigo;
    private String dataPedido;
    private String horaPedido;
    private String horaProducao;
    private String horaPronto;
    private String horaEntrega;
    private String horaFinalizacao;
    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDataPedido() {
        return dataPedido;
    }
    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }
    public String getHoraPedido() {
        return horaPedido;
    }
    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }
    public String getHoraProducao() {
        return horaProducao;
    }
    public void setHoraProducao(String horaProducao) {
        this.horaProducao = horaProducao;
    }
    public String getHoraPronto() {
        return horaPronto;
    }
    public void setHoraPronto(String horaPronto) {
        this.horaPronto = horaPronto;
    }
    public String getHoraEntrega() {
        return horaEntrega;
    }
    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }
    public String getHoraFinalizacao() {
        return horaFinalizacao;
    }
    public void setHoraFinalizacao(String horaFinalizacao) {
        this.horaFinalizacao = horaFinalizacao;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
    
}
