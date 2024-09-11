package ifmt.cba.execucao;


import ifmt.cba.dto.GrupoAlimentarDTO;
import ifmt.cba.dto.ProdutoDTO;
import ifmt.cba.negocio.GrupoAlimentarNegocio;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.negocio.ProdutoNegocio;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.GrupoAlimentarDAO;
import ifmt.cba.persistencia.PersistenciaException;
import ifmt.cba.persistencia.ProdutoDAO;
//import ifmt.persistence.PersistenceException;

public class AppInserirProduto {
    public static void main(String[] args) throws PersistenciaException {
        try{
            GrupoAlimentarDAO grupoAlimentarDAO = new GrupoAlimentarDAO(FabricaEntityManager.getEntityManagerProducao());
            GrupoAlimentarNegocio grupoAlimentarNegocio = new GrupoAlimentarNegocio(grupoAlimentarDAO);

            ProdutoDAO produtoDAO = new ProdutoDAO(FabricaEntityManager.getEntityManagerProducao());
            ProdutoNegocio produtoNegocio = new ProdutoNegocio(produtoDAO);


            GrupoAlimentarDTO grupoAlimentarDTO = grupoAlimentarNegocio.pesquisaParteNome("Proteinas").get(0);

            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setNome("carne");
             produtoNegocio.inserir(produtoDTO);
            
           // produtoDTO  = new ProdutoDTO();
            produtoDTO.setCustoUnidade(35);
           //produtoNegocio.inserir(produtoDTO);

          // produtoDTO  = new ProdutoDTO();
            produtoDTO.setValorEnergetico(22);
         //  produtoNegocio.inserir(produtoDTO);

          // produtoDTO  = new ProdutoDTO();
            produtoDTO.setEstoque(10);
         //  produtoNegocio.inserir(produtoDTO);

          // produtoDTO  = new ProdutoDTO();
            produtoDTO.setEstoqueMinimo(3);
          // produtoNegocio.inserir(produtoDTO);

           //produtoDTO  = new ProdutoDTO();
            //produtoDTO.setGrupoAlimentar(grupoAlimentarDTO);
            produtoNegocio.inserir(produtoDTO);
        }catch(PersistenciaException | NegocioException e){
            e.printStackTrace();
        }
    }
}
