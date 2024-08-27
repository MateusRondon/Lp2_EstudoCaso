package ifmt.cba.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OrdemProducaoDTO {

    private int codigo;
    private String dataProducao;
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
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
    
}
