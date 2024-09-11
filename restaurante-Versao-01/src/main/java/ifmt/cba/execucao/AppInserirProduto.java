package ifmt.cba.execucao;

import ifmt.cba.dto.ProdutoDTO;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.negocio.ProdutoNegocio;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.ProdutoDAO;
import jakarta.persistence.PersistenceException;

public class AppInserirProduto {
    public static void main(String[] args) {
        try{
            ProdutoDAO produtoDAO = new ProdutoDAO(FabricaEntityManager.getEntityManagerProducao());
            ProdutoNegocio produtoNegocio = new ProdutoNegocio(produtoDAO);

            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setNome("carne");
            produtoDTO.setCustoUnidade(35);
            produtoDTO.setValorEnergetico(22);
            produtoDTO.setEstoque(10);
            produtoDTO.setEstoqueMinimo(3);
            produtoDTO.setGrupoAlimentar("Carboidrato");
            produtoNegocio.inserir(produtoDTO);
        }catch(PersistenceException | NegocioException e){
            e.printStackTrace();
        }
    }
}
