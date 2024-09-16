package ifmt.cba.negocio;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import ifmt.cba.dto.ColaboradorDTO;
import ifmt.cba.entity.Colaborador;
import ifmt.cba.persistencia.ColaboradorDAO;
import ifmt.cba.persistencia.PersistenciaException;

public class ColaboradorNegocio {

    private ModelMapper modelMapper;
	private ColaboradorDAO colaboradorDAO;

	public ColaboradorNegocio(ColaboradorDAO colaboradorDAO) {
		this.colaboradorDAO = colaboradorDAO;
		this.modelMapper = new ModelMapper();
	}

	public void inserir(ColaboradorDTO colaboradorDTO) throws NegocioException {

		Colaborador colaborador = this.toEntity(colaboradorDTO);
		String mensagemErros = colaborador.validar();

		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}

		try {
			if (!colaboradorDAO.buscarPorCargo(colaborador.getCargo()).isEmpty()) {
				throw new NegocioException("Ja existe um colaborador com esse cargo");
			}
			colaboradorDAO.beginTransaction();
			colaboradorDAO.incluir(colaborador);
			colaboradorDAO.commitTransaction();
		} catch (PersistenciaException ex) {
			colaboradorDAO.rollbackTransaction();
			throw new NegocioException("Erro ao incluir o colaborador - " + ex.getMessage());
		}
	}


	public void excluir(int codigo) throws NegocioException {

		try {
			Colaborador colaborador = colaboradorDAO.buscarPorCodigo(codigo);
			if (colaborador == null) {
				throw new NegocioException("Nao existe esse colaborador");
			}

			colaboradorDAO.beginTransaction();
			colaboradorDAO.excluir(colaborador);
			colaboradorDAO.commitTransaction();
		} catch (PersistenciaException ex) {
			colaboradorDAO.rollbackTransaction();
			throw new NegocioException("Erro ao excluir o colaborador - " + ex.getMessage());
		}
	}

	public List<ColaboradorDTO> pesquisaParteNome(String parteNome) throws NegocioException {
		try {
			return this.toDTOAll(colaboradorDAO.buscarPorParteNome(parteNome));
		} catch (PersistenciaException ex) {
			throw new NegocioException("Erro ao pesquisar colaborador pelo nome - " + ex.getMessage());
		}
	}

	public ColaboradorDTO pesquisaCodigo(int codigo) throws NegocioException {
		try {
			return this.toDTO(colaboradorDAO.buscarPorCodigo(codigo));
		} catch (PersistenciaException ex) {
			throw new NegocioException("Erro ao pesquisar colaborador pelo codigo - " + ex.getMessage());
		}
	}

	public List<ColaboradorDTO> toDTOAll(List<Colaborador> listaColaborador) {
		List<ColaboradorDTO> listaDTO = new ArrayList<ColaboradorDTO>();

		for (Colaborador colaborador : listaColaborador) {
			listaDTO.add(this.toDTO(colaborador));
		}
		return listaDTO;
	}

	public ColaboradorDTO toDTO(Colaborador colaborador) {
		return this.modelMapper.map(colaborador, ColaboradorDTO.class);
	}

	public Colaborador toEntity(ColaboradorDTO colaboradorDTO) {
		return this.modelMapper.map(colaboradorDTO, Colaborador.class);
	}

}
