package ifmt.cba.negocio;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.ArrayList;

import ifmt.cba.dto.CardapioDTO;
import ifmt.cba.entity.Cardapio;
import ifmt.cba.persistencia.CardapioDAO;
import ifmt.cba.persistencia.PersistenciaException;

public class CardapioNegocio {

    private ModelMapper modelMapper;
	private CardapioDAO cardapioDAO;

	public CardapioNegocio(CardapioDAO cardapioDAO) {
		this.cardapioDAO = cardapioDAO;
		this.modelMapper = new ModelMapper();
	}

	public void inserir(CardapioDTO cardapioDTO) throws NegocioException {

		Cardapio cardapio = this.toEntity(cardapioDTO);
		String mensagemErros = cardapio.validar();

		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}

		try {
			if (!cardapioDAO.buscarPorParteNome(cardapioDTO.getNome()).isEmpty()) {
				throw new NegocioException("Ja existe esse cardapio");
			}
			cardapioDAO.beginTransaction();
			cardapioDAO.incluir(cardapio);
			cardapioDAO.commitTransaction();
		} catch (PersistenciaException ex) {
			cardapioDAO.rollbackTransaction();
			throw new NegocioException("Erro ao incluir o cardapio - " + ex.getMessage());
		}
	}

	/*public void alterar(ClienteDTO clienteDTO) throws NegocioException {

		Cliente cliente = this.toEntity(clienteDTO);
		String mensagemErros = cliente.validar();
		if (!mensagemErros.isEmpty()) {
			throw new NegocioException(mensagemErros);
		}
		try {
			if (clienteDAO.buscarPorCodigo(cliente.getCodigo()) == null) {
				throw new NegocioException("Nao existe esse cliente");
			}
			clienteDAO.beginTransaction();
			clienteDAO.alterar(cliente);
			clienteDAO.commitTransaction();
		} catch (PersistenciaException ex) {
			clienteDAO.rollbackTransaction();
			throw new NegocioException("Erro ao alterar o cliente - " + ex.getMessage());
		}
	}*/

	public void excluir(int codigo) throws NegocioException {

		try {
			Cardapio cardapio = cardapioDAO.buscarPorCodigo(codigo);
			if (cardapio == null) {
				throw new NegocioException("Nao existe esse cardapio");
			}

			cardapioDAO.beginTransaction();
			cardapioDAO.excluir(cardapio);
			cardapioDAO.commitTransaction();
		} catch (PersistenciaException ex) {
			cardapioDAO.rollbackTransaction();
			throw new NegocioException("Erro ao excluir o cardapio - " + ex.getMessage());
		}
	}

	public List<CardapioDTO> pesquisaParteNome(String parteNome) throws NegocioException {
		try {
			return this.toDTOAll(cardapioDAO.buscarPorParteNome(parteNome));
		} catch (PersistenciaException ex) {
			throw new NegocioException("Erro ao pesquisar cardapio pelo nome - " + ex.getMessage());
		}
	}

	public CardapioDTO pesquisaCodigo(int codigo) throws NegocioException {
		try {
			return this.toDTO(cardapioDAO.buscarPorCodigo(codigo));
		} catch (PersistenciaException ex) {
			throw new NegocioException("Erro ao pesquisar cardapio pelo codigo - " + ex.getMessage());
		}
	}

	public List<CardapioDTO> toDTOAll(List<Cardapio> listaCardapio) {
		List<CardapioDTO> listaDTO = new ArrayList<CardapioDTO>();

		for (Cardapio cardapio : listaCardapio) {
			listaDTO.add(this.toDTO(cardapio));
		}
		return listaDTO;
	}

	public CardapioDTO toDTO(Cardapio cardapio) {
		return this.modelMapper.map(cardapio, CardapioDTO.class);
	}

	public Cardapio toEntity(CardapioDTO cardapioDTO) {
		return this.modelMapper.map(cardapioDTO, Cardapio.class);
	} 
}
