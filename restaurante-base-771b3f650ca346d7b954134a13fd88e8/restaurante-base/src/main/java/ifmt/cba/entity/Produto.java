import ifmt.cba.entity;

import javax.annotation.processing.Generated;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="produto")
public class Prodoto {
    @Id
    @GeneratedValue(strategy = GeneratedType.IDENTITY)
    private int codigo;
    @Column (name = "nome") 
    private String nome;
    
    @Column (name = "custo_unidade") 
    private float custoUnidade;
    
    @Column (name = "valor_energetico") 
    private int valorEnergetico;
    
    @Column (name = "estoque") 
    private int estoque;
    
    @Column (name = "estoque_minimo") 
    private int estoque_minimo;
    @ManyToOne (Fetch = FetchType.EAGER)    
    @JoinColumn (nam = "id_grupo")

    private GrupoAlimentar grupoAlimentar;

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

    public float getCustoUnidade() {
        return custoUnidade;
    }
    public void setCustoUnidade(float custoUnidade) {
        this.custoUnidade = custoUnidade;
    }
    public int getValorEnergetico() {
        return valorEnergetico;
    }
    public void setValorEnergetico(int valorEnergetico) {
        this.valorEnergetico = valorEnergetico;
    }
    public GrupoAlimentar getGrupoAlimentar() {
        return grupoAlimentar;
    }
    public void setGrupoAlimentar(GrupoAlimentar grupoAlimentar) {
        this.grupoAlimentar = grupoAlimentar;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public int getEstoque_minimo() {
        return estoque_minimo;
    }
    public void setEstoque_minimo(int estoque_minimo) {
        this.estoque_minimo = estoque_minimo;
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle .JSON_STYLE);
    }
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }

    
}

