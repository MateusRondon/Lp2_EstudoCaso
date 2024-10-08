package ifmt.cba.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "preparo_produto")
public class PreparoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name ="nome" ,length = 40)
    private String nome;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_preparo", nullable = false)
    private TipoPreparo tipoPreparo;

    @Column(name ="tempo_preparo" )
    private int tempoPreparo;

    @Column(name ="valor_preparo" )
    private float valorPreparo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoPreparo getTipoPreparo() {
        return tipoPreparo;
    }

    public void setTipoPreparo(TipoPreparo tipoPreparo) {
        this.tipoPreparo = tipoPreparo;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public float getValorPreparo() {
        return valorPreparo;
    }

    public void setValorPreparo(float valorPreparo) {
        this.valorPreparo = valorPreparo;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }

    @Override 
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        
        if(obj == null)
            return false;
        
        if(getClass() !=obj.getClass())
            return false;
        
        PreparoProduto other = (PreparoProduto) obj;
        if(codigo !=other.codigo)
            return false;
        
        return true;
    }

    public String validar(){
        String retorno = "";
        if(this.nome.length()<3){
            retorno += "Nome invalido";
            }
            
            if(tempoPreparo < 1){
                retorno += " Tempo de preparo invalido";
            }
            
            if(this.produto == null){
                retorno += "Produto Invalido";
            }else{
                retorno += this.produto.validar();
            }

            if (this.tipoPreparo == null) {
                retorno += "Tipo Preparo Invalido";
            }else{
                retorno += this.tipoPreparo.validar();
            }

            if (valorPreparo <1) {
                retorno+= "Valor preparo invalido";
            }
        return retorno;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle .JSON_STYLE);
    }

}
