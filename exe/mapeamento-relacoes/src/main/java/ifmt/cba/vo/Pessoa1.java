package ifmt.cba.vo;
import java.io.Serializable;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;
import jakarta.persistence.id;
import jakarta.persistence.inheritance;
import jakarta.persistence.inheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa1")
@inheritance(strategy = inheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name "tipo",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue ("pessoa")
public abstract class Pessoa1 implements Serializable {
    @id
    @GeneratedValue(strategy = GeneratedType.SEQUENCE)
    private int codigo;
    @Column (length  40, nullable = false )
    private String nome;
    public Pessoa1 (){

    }
    public Pessoa1 (int codigo , String nome){
        this.codigo = codigo;
        this.nome = nome;
    }
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
    public abstract float getRendimento();
}
