package ifmt.cba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;


    @Column(name ="data_pedido" )
    private String dataPedido;

    @Column(name = "hora_pedido")
    private String horaPedido;

    @Column(name = "hora_producao")
    private String horaProducao;

    @Column(name = "hora_pronto")
    private String horaPronto;

    @Column(name = "hora_de_entrega")
    private String horaEntrega;

    @Column(name = "hora_finalizacao")
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }
    

    
}
