package ifmt.cba.negocio;


import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import ifmt.cba.dto.PreparoProdutoDTO;
import ifmt.cba.entity.PreparoProduto;
import ifmt.cba.persistencia.PersistenciaException;
import ifmt.cba.persistencia.PreparoProdutoDAO;

public class PreparoProdutoNegocio {


    private ModelMapper modelMapper; 
    private PreparoProdutoDAO preparoProdutoDAO;

    public PreparoProdutoNegocio (PreparoProdutoDAO preparoProdutoDAO){
        this.preparoProdutoDAO = preparoProdutoDAO;
        this.modelMapper = new ModelMapper();
    }
    public void inserir(PreparoProdutoDTO preparoProdutoDTO)throws NegocioException{
        
        PreparoProduto preparoProduto = this.toEntity(preparoProdutoDTO);
        String mensagemErros = preparoProduto.validar();
        
        if(!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);
        }

        try{
            if(!preparoProdutoDAO.buscarPorProduto(preparoProduto.getProduto().getCodigo()).isEmpty() && !preparoProdutoDAO.buscarPorTipoPreparo(preparoProduto.getTipoPreparo().getCodigo()).isEmpty()){
                throw new NegocioException("Ja existe ESSE PreparoProduto ");
            }
            preparoProdutoDAO.beginTransaction();
            preparoProdutoDAO.incluir(preparoProduto);
            preparoProdutoDAO.commitTransaction();
        }catch(PersistenciaException ex){
            preparoProdutoDAO.rollbackTransaction();
            throw new NegocioException("Erro ao incluir PreparoProduto -"+ex.getMessage());
        }
    }



    public void excluir (int codigo)throws NegocioException{
        try{
            PreparoProduto preparoProduto = preparoProdutoDAO.buscarPorCodigo(codigo);
            if(preparoProduto == null){
                throw new NegocioException("Nao existe esse PreparoProduto");
            } 
            preparoProdutoDAO.beginTransaction();
            preparoProdutoDAO.excluir(preparoProduto);
            preparoProdutoDAO.commitTransaction();
            }catch(PersistenciaException ex){
                preparoProdutoDAO.rollbackTransaction();
            } 
    }
    
        public List<PreparoProdutoDTO> pesquisaParteNome(String parteNome)throws NegocioException{
            try{
                return this.toDTOAll(preparoProdutoDAO.buscarPorParteNome(parteNome));
            }catch(PersistenciaException ex){
                throw new NegocioException("Erro ao pesquisar PreparoProduto pelo nome"+ex.getMessage());
            }
        }
        

        public PreparoProdutoDTO pesquisaCodigo(int codigo)throws NegocioException{
            try{
                return this.toDTO(preparoProdutoDAO.buscarPorCodigo(codigo));
            }catch(PersistenciaException ex){
                throw new NegocioException("Erro ao pesquisar PreparoProduto pelo codigo"+ex.getMessage());
            }
        }
        
        public List<PreparoProdutoDTO> toDTOAll(List <PreparoProduto> listaPreparoProduto){
           List<PreparoProdutoDTO> listaDTO = new ArrayList <PreparoProdutoDTO>();
            
           
           for(PreparoProduto preparoProduto :listaPreparoProduto){
                listaDTO.add(this.toDTO(preparoProduto));
            }
            return listaDTO;
        }

        public PreparoProdutoDTO toDTO(PreparoProduto preparoProduto){
            return this.modelMapper.map(preparoProduto,PreparoProdutoDTO.class);
        }
        
        public PreparoProduto toEntity(PreparoProdutoDTO preparoProdutoDTO){
            return this.modelMapper.map(preparoProdutoDTO,PreparoProduto.class);
        }
}
