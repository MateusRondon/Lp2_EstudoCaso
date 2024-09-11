package ifmt.cba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordem_de_producao")
public class OrdemProducao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "data_de_producao")
    private String dataProducao;

    @Column(name = "hora_de_producao")
    private String horaProducao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDataProducao() {
        return dataProducao;
    }

    public void setDataProducao(String dataProducao) {
        this.dataProducao = dataProducao;
    }

    public String getHoraProducao() {
        return horaProducao;
    }

    public void setHoraProducao(String horaProducao) {
        this.horaProducao = horaProducao;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrdemProducao other = (OrdemProducao) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

}
