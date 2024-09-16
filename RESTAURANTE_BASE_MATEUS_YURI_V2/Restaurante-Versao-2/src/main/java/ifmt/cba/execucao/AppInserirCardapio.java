package ifmt.cba.execucao;

import java.util.ArrayList;
import java.util.List;


import ifmt.cba.dto.CardapioDTO;
import ifmt.cba.dto.PreparoProdutoDTO;

import ifmt.cba.negocio.PreparoProdutoNegocio;
import ifmt.cba.negocio.CardapioNegocio;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.persistencia.PreparoProdutoDAO;
import ifmt.cba.persistencia.CardapioDAO;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.PersistenciaException;

public class AppInserirCardapio {

    public static void main(String[] args) {
        try {

            List<PreparoProdutoDTO> listaPreparoProduto = new ArrayList<>();
           

           CardapioDAO cardapioDAO = new CardapioDAO(FabricaEntityManager.getEntityManagerProducao());
            CardapioNegocio cardapioNegocio = new CardapioNegocio(cardapioDAO);
    
            PreparoProdutoDAO preparoProdutoDAO = new PreparoProdutoDAO(FabricaEntityManager.getEntityManagerProducao());
            PreparoProdutoNegocio preparoProdutoNegocio = new PreparoProdutoNegocio(preparoProdutoDAO);

            PreparoProdutoDTO preparoProdutoDTO = preparoProdutoNegocio.pesquisaParteNome("Carne assada").get(0);
            listaPreparoProduto.add(preparoProdutoDTO);
            preparoProdutoDTO = preparoProdutoNegocio.pesquisaParteNome("Carne cozida").get(0);
            listaPreparoProduto.add(preparoProdutoDTO);

            CardapioDTO cardapioDTO = new CardapioDTO();
            cardapioDTO.setNome("Carnes");
            cardapioDTO.setDescricao("churrasco com carne assada e cozida");
            cardapioDTO.setListaPreparoProduto(listaPreparoProduto);
            cardapioNegocio.inserir(cardapioDTO);



        } catch (PersistenciaException | NegocioException e) {
            e.printStackTrace();
        }
    } 
    
}
