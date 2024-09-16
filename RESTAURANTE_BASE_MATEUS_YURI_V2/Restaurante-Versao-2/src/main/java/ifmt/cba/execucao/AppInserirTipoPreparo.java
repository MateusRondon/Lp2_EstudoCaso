package ifmt.cba.execucao;

import ifmt.cba.dto.TipoPreparoDTO;
import ifmt.cba.negocio.TipoPreparoNegocio;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.persistencia.TipoPreparoDAO;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.PersistenciaException;

public class AppInserirTipoPreparo {

    public static void main(String[] args) {
        
        try {
            TipoPreparoDAO TipoPreparoDAO = new TipoPreparoDAO(FabricaEntityManager.getEntityManagerProducao());
            TipoPreparoNegocio TipoPreparoNegocio = new TipoPreparoNegocio(TipoPreparoDAO);
    
            TipoPreparoDTO TipoPreparoDTO = new TipoPreparoDTO();
            TipoPreparoDTO.setDescricao("Cozido");
            TipoPreparoNegocio.inserir(TipoPreparoDTO);

            TipoPreparoDTO = new TipoPreparoDTO();
            TipoPreparoDTO.setDescricao("Assado");
            TipoPreparoNegocio.inserir(TipoPreparoDTO);

            TipoPreparoDTO = new TipoPreparoDTO();
            TipoPreparoDTO.setDescricao("cru");
            TipoPreparoNegocio.inserir(TipoPreparoDTO);


        } catch (PersistenciaException | NegocioException e) {
            e.printStackTrace();
        }
    }
}
