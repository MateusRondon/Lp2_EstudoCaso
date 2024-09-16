package ifmt.cba.execucao;

import ifmt.cba.dto.EntregadorDTO;
import ifmt.cba.negocio.EntregadorNegocio;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.persistencia.EntregadorDAO;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.PersistenciaException;

public class AppInserirEntregador {

    public static void main(String[] args) {
        
         try {
            EntregadorDAO EntregadorDAO = new EntregadorDAO(
                    FabricaEntityManager.getEntityManagerProducao());
            EntregadorNegocio EntregadorNegocio = new EntregadorNegocio(EntregadorDAO);
            
    
            
            EntregadorDTO EntregadorDTO = new EntregadorDTO();
            EntregadorDTO.setNome("Entregador 01");
            EntregadorDTO.setCPF("235.344.656-55");
            EntregadorDTO.setRG("234167-8");
            EntregadorDTO.setTelefone("65 99999-4040");
            EntregadorNegocio.inserir(EntregadorDTO);

            EntregadorDTO = new EntregadorDTO();
            EntregadorDTO.setNome("Entregador 02");
            EntregadorDTO.setCPF("123.432.678-99");
            EntregadorDTO.setRG("123456-9");
            EntregadorDTO.setTelefone("65 98888-5050");
            EntregadorNegocio.inserir(EntregadorDTO);

            EntregadorDTO = new EntregadorDTO();
            EntregadorDTO.setNome("Entregador 03");
            EntregadorDTO.setCPF("123.432.678-99");
            EntregadorDTO.setRG("123456-9");
            EntregadorDTO.setTelefone("65 98888-5050");
            EntregadorNegocio.inserir(EntregadorDTO);

        } catch (PersistenciaException | NegocioException e) {
            e.printStackTrace();
        }
    }
}
