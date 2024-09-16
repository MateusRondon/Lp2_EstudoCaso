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
          /*ClienteDAO clienteDAO = new ClienteDAO(
                    FabricaEntityManager.getEntityManagerProducao());
            ClienteNegocio clienteNegocio = new ClienteNegocio(clienteDAO);
            BairroDAO bairroDAO = new BairroDAO(FabricaEntityManager.getEntityManagerProducao());
            BairroNegocio bairroNegocio = new BairroNegocio(bairroDAO);

    
            BairroDTO bairroDTO = bairroNegocio.pesquisaParteNome("Centro").get(0);
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setNome("Cliente 01");
            clienteDTO.setCPF("234.345.656-55");
            clienteDTO.setRG("234567-9");
            clienteDTO.setTelefone("65 99999-7070");
            clienteDTO.setLogradouro("Rua das flores");
            clienteDTO.setNumero("123");
            clienteDTO.setPontoReferencia("Proximo a nada");
            clienteDTO.setBairro(bairroDTO);
            clienteNegocio.inserir(clienteDTO);

            bairroDTO = bairroNegocio.pesquisaParteNome("Coxipo").get(0);
            clienteDTO = new ClienteDTO();
            clienteDTO.setNome("Cliente 02");
            clienteDTO.setCPF("123.432.678-99");
            clienteDTO.setRG("123456-8");
            clienteDTO.setTelefone("65 98888-3030");
            clienteDTO.setLogradouro("Rua das pedras");
            clienteDTO.setNumero("456");
            clienteDTO.setPontoReferencia("Final da rua");
            clienteDTO.setBairro(bairroDTO);
            clienteNegocio.inserir(clienteDTO); */

            ProdutoDAO produtoDAO = new ProdutoDAO(FabricaEntityManager.getEntityManagerProducao());
            GrupoAlimentarDAO grupoAlimentarDAO = new GrupoAlimentarDAO(FabricaEntityManager.getEntityManagerProducao());
            GrupoAlimentarNegocio grupoAlimentarNegocio = new GrupoAlimentarNegocio(grupoAlimentarDAO);


            ProdutoNegocio produtoNegocio = new ProdutoNegocio(produtoDAO);


            GrupoAlimentarDTO grupoAlimentarDTO = grupoAlimentarNegocio.pesquisaParteNome("Carboidrato").get(0);
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setNome("carne");
            produtoDTO.setCustoUnidade(35);
            produtoDTO.setValorEnergetico(22);
            produtoDTO.setEstoque(10);
            produtoDTO.setEstoqueMinimo(3); //por algum motivo nao passa o valor pro banco
            produtoDTO.setGrupoAlimentar(grupoAlimentarDTO);
            produtoNegocio.inserir(produtoDTO);
        }catch(PersistenciaException | NegocioException e){
            e.printStackTrace();
        }
    }
}
