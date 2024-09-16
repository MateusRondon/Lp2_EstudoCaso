package ifmt.cba.execucao;


import ifmt.cba.dto.ColaboradorDTO;
import ifmt.cba.negocio.ColaboradorNegocio;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.persistencia.ColaboradorDAO;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.PersistenciaException;
import ifmt.cba.util.Cargos;

public class AppInserirColaborador {

    public static void main(String[] args) {
        try {
            ColaboradorDAO colaboradorDAO = new ColaboradorDAO(FabricaEntityManager.getEntityManagerProducao());
            ColaboradorNegocio colaboradorNegocio = new ColaboradorNegocio(colaboradorDAO);


            ColaboradorDTO colaboradorDTO = new ColaboradorDTO();
            colaboradorDTO.setNome("Jonas");
            colaboradorDTO.setRG("425935073");
            colaboradorDTO.setCPF("085.977.200-42");
            colaboradorDTO.setTelefone("55 2585-1855");
            colaboradorDTO.setCargo(Cargos.Administrador);
            colaboradorNegocio.inserir(colaboradorDTO);


            colaboradorDTO = new ColaboradorDTO();
            colaboradorDTO.setNome("Joao");
            colaboradorDTO.setRG("425935072");
            colaboradorDTO.setCPF("085.977.200-46");
            colaboradorDTO.setTelefone("55 2585-1859");
            colaboradorDTO.setCargo(Cargos.Administrador);
            colaboradorNegocio.inserir(colaboradorDTO);
        } catch (PersistenciaException | NegocioException e) {
            e.printStackTrace();
        }
    }
}
