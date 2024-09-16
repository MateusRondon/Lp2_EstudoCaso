package ifmt.cba.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cardapio_preparo_produto")
public class CardapioPreparoProduto {


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cardapio")
    private int codigoCardapio;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_preparo_produto")
    private int codigoPreparoProduto;

    public int getCodigoCardapio() {
        return codigoCardapio;
    }

    public void setCodigoCardapio(int codigoCardapio) {
        this.codigoCardapio = codigoCardapio;
    }

    public int getCodigoPreparoProduto() {
        return codigoPreparoProduto;
    }

    public void setCodigoPreparoProduto(int codigoPreparoProduto) {
        this.codigoPreparoProduto = codigoPreparoProduto;
    }

    
}
