package ifmt.cba.execucao;


import ifmt.cba.dto.PreparoProdutoDTO;
import ifmt.cba.dto.ProdutoDTO;
import ifmt.cba.dto.TipoPreparoDTO;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.negocio.PreparoProdutoNegocio;
import ifmt.cba.negocio.ProdutoNegocio;
import ifmt.cba.negocio.TipoPreparoNegocio;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.PersistenciaException;
import ifmt.cba.persistencia.PreparoProdutoDAO;
import ifmt.cba.persistencia.ProdutoDAO;
import ifmt.cba.persistencia.TipoPreparoDAO;

public class AppInserirPreparoProduto {

    public static void main(String[] args) {
        
        try {
            
            PreparoProdutoDAO preparoProdutoDAO = new PreparoProdutoDAO(FabricaEntityManager.getEntityManagerProducao());
            ProdutoDAO produtoDAO = new ProdutoDAO(FabricaEntityManager.getEntityManagerProducao());
            TipoPreparoDAO tipoPreparoDAO=  new TipoPreparoDAO(FabricaEntityManager.getEntityManagerProducao());


            PreparoProdutoNegocio preparoProdutoNegocio = new PreparoProdutoNegocio(preparoProdutoDAO);
            ProdutoNegocio produtoNegocio = new ProdutoNegocio(produtoDAO);
            TipoPreparoNegocio tipoPreparoNegocio = new TipoPreparoNegocio(tipoPreparoDAO);

    
            ProdutoDTO produtoDTO = produtoNegocio.pesquisaParteNome("Carne").get(0);
            TipoPreparoDTO tipoPreparoDTO = tipoPreparoNegocio.pesquisaPorDescricao("Cru").get(0);
            PreparoProdutoDTO preparoProdutoDTO = new PreparoProdutoDTO();
           // preparoProdutoDTO.setCodigo(1);
            preparoProdutoDTO.setNome("Carne assada");
            preparoProdutoDTO.setTempoPreparo(40);
            preparoProdutoDTO.setValorPreparo(6);
            preparoProdutoDTO.setProduto(produtoDTO);
            preparoProdutoDTO.setTipoPreparo(tipoPreparoDTO);
            preparoProdutoNegocio.inserir(preparoProdutoDTO);


             produtoDTO = produtoNegocio.pesquisaParteNome("Carne").get(0);
             tipoPreparoDTO = tipoPreparoNegocio.pesquisaPorDescricao("Cozido").get(0);
            preparoProdutoDTO.setNome("Carne cozida");
            preparoProdutoDTO.setTempoPreparo(40);
            preparoProdutoDTO.setValorPreparo(6);
            preparoProdutoDTO.setProduto(produtoDTO);
            preparoProdutoDTO.setTipoPreparo(tipoPreparoDTO);
            preparoProdutoNegocio.inserir(preparoProdutoDTO);
        } catch (PersistenciaException | NegocioException e) {
            e.printStackTrace();
        }
    }
}
