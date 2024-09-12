package ifmt.cba.execucao;


import ifmt.cba.negocio.GrupoAlimentarNegocio;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.negocio.ProdutoNegocio;

import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.GrupoAlimentarDAO;
import ifmt.cba.persistencia.PersistenciaException;
import ifmt.cba.persistencia.ProdutoDAO;

public class AppInserirProduto {
    public static void main(String[] args) throws PersistenciaException {
        try{
            GrupoAlimentarDAO grupoAlimentarDAO = new GrupoAlimentarDAO(FabricaEntityManager.getEntityManagerProducao());
            GrupoAlimentarNegocio grupoAlimentarNegocio = new GrupoAlimentarNegocio(grupoAlimentarDAO);

            ProdutoDAO produtoDAO = new ProdutoDAO(FabricaEntityManager.getEntityManagerProducao());
            ProdutoNegocio produtoNegocio = new ProdutoNegocio(produtoDAO);


            GrupoAlimentarDTO grupoAlimentarDTO = grupoAlimentarNegocio.pesquisaParteNome("Proteinas").get(0);

            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setNome("Carne");
            produtoDTO.setCustoUnidade(35);
            produtoDTO.setValorEnergetico(22);
            produtoDTO.setEstoque(10);
            produtoDTO.setEstoqueMinimo(3);
            produtoNegocio.inserir(produtoDTO);
            produtoDTO.setGrupoAlimentar(grupoAlimentarDTO);
            produtoNegocio.inserir(produtoDTO);

        }catch(PersistenciaException | NegocioException e){
            e.printStackTrace();
        }
    }
}
