package ifmt.cba.negocio;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import ifmt.cba.dto.TipoPreparoDTO;
import ifmt.cba.entity.TipoPreparo;
import ifmt.cba.persistencia.PersistenciaException;
import ifmt.cba.persistencia.TipoPreparoDAO;

public class TipoPreparoNegocio {

    private ModelMapper modelMapper;
    private TipoPreparoDAO tipoPreparoDAO;

    public TipoPreparoNegocio(TipoPreparoDAO tipoPreparoDAO) {
        this.modelMapper = new ModelMapper();
        this.tipoPreparoDAO = tipoPreparoDAO;
    }

    public void inserir(TipoPreparoDTO tipoPreparoDTO)throws NegocioException{
    
        TipoPreparo tipoPreparo = this.toEntity(tipoPreparoDTO);
         String mensagemErros = tipoPreparo.validar();

         if(!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);
        }

        try{
            if(!tipoPreparoDAO.buscarPorDescricao(tipoPreparo.getDescricao()).isEmpty()){
                throw new NegocioException("Ja existe essa descricao ");
            }
            tipoPreparoDAO.beginTransaction();
            tipoPreparoDAO.incluir(tipoPreparo);
            tipoPreparoDAO.commitTransaction();
        }catch(PersistenciaException ex){
            tipoPreparoDAO.rollbackTransaction();
            throw new NegocioException("Erro ao incluir tipo de preparo -"+ex.getMessage());
        }
    }

    public void excluir (int codigo)throws NegocioException{
        try{
            TipoPreparo tipoPreparo = tipoPreparoDAO.buscarPorCodigo(codigo);
            if(tipoPreparo == null){
                throw new NegocioException("Nao existe esse tipo preparo");
            } 
            tipoPreparoDAO.beginTransaction();
            tipoPreparoDAO.excluir(tipoPreparo);
            tipoPreparoDAO.commitTransaction();
            }catch(PersistenciaException ex){
                tipoPreparoDAO.rollbackTransaction();
            } 
    }

    public List<TipoPreparoDTO> pesquisaPorDescricao(String descricao)throws NegocioException{
        try{
            return this.toDTOAll(tipoPreparoDAO.buscarPorDescricao(descricao));
        }catch(PersistenciaException ex){
            throw new NegocioException("Erro ao pesquisar produto pelo nome"+ex.getMessage());
        }
    }

    public TipoPreparoDTO pesquisaCodigo(int codigo)throws NegocioException{
        try{
            return this.toDTO(tipoPreparoDAO.buscarPorCodigo(codigo));
        }catch(PersistenciaException ex){
            throw new NegocioException("Erro ao pesquisar tipo preparo pelo codigo"+ex.getMessage());
        }
    }
    
    public List<TipoPreparoDTO> toDTOAll(List <TipoPreparo> listaProduto){
       List<TipoPreparoDTO> listaDTO = new ArrayList <TipoPreparoDTO>();
        
       
       for(TipoPreparo tipoPreparo :listaProduto){
            listaDTO.add(this.toDTO(tipoPreparo));
        }
        return listaDTO;
    }
    public TipoPreparoDTO toDTO(TipoPreparo tipoPreparo){
        return this.modelMapper.map(tipoPreparo,TipoPreparoDTO.class);
    }
    public TipoPreparo toEntity(TipoPreparoDTO tipoPreparoDTO){
        return this.modelMapper.map(tipoPreparoDTO,TipoPreparo.class);
    }

    /* private ModelMapper modelMapper; 
    private ProdutoDAO produtoDAO;

    public ProdutoNegocio (ProdutoDAO produtoDAO){
        this.produtoDAO = produtoDAO;
        this.modelMapper = new ModelMapper();
    }
    public void inserir(ProdutoDTO produtoDTO)throws NegocioException{
        
        Produto produto = this.toEntity(produtoDTO);
        String mensagemErros = produto.validar();
        
        if(!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);
        }

        try{
            if(!produtoDAO.buscarPorParteNome(produto.getNome()).isEmpty()){
                throw new NegocioException("Ja existe ESSE produto ");
            }
            produtoDAO.beginTransaction();
            produtoDAO.incluir(produto);
            produtoDAO.commitTransaction();
        }catch(PersistenciaException ex){
            produtoDAO.rollbackTransaction();
            throw new NegocioException("Erro ao incluir produto -"+ex.getMessage());
        }
    }

    public void alterar (ProdutoDTO produtoDTO) throws NegocioException{
        
        Produto  produto = this.toEntity(produtoDTO);
        String mensagemErros = produto.validar();
        if(!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);
        }
        try {
            if(produtoDAO.buscarPorCodigo(produto.getCodigo())==null){
                throw new NegocioException("Nao existe esse produto");
            }
            produtoDAO.beginTransaction();
            produtoDAO.alterar(produto);
            produtoDAO.commitTransaction();
        }catch(PersistenciaException ex){
            produtoDAO.rollbackTransaction();
            throw new NegocioException("Erro ao alterar o produto-->"+ex.getMessage());
        }
    }

    public void excluir (int codigo)throws NegocioException{
        try{
            Produto produto = produtoDAO.buscarPorCodigo(codigo);
            if(produto == null){
                throw new NegocioException("Nao existe esse produto");
            } 
            produtoDAO.beginTransaction();
            produtoDAO.excluir(produto);
            produtoDAO.commitTransaction();
            }catch(PersistenciaException ex){
                produtoDAO.rollbackTransaction();
            } 
    }
    
        public List<ProdutoDTO> pesquisaParteNome(String parteNome)throws NegocioException{
            try{
                return this.toDTOAll(produtoDAO.buscarPorParteNome(parteNome));
            }catch(PersistenciaException ex){
                throw new NegocioException("Erro ao pesquisar produto pelo nome"+ex.getMessage());
            }
        }
        
        public List<ProdutoDTO> pesquisaProdutoAbaixoEstoqueMinimo()throws NegocioException{
            try{
                return this.toDTOAll(produtoDAO.busacarProdutoAbaixoEstoqueMinimo());
            }catch(PersistenciaException ex){
                throw new NegocioException("Erro ao pesquisar produto abaixo do estoque minimo"+ex.getMessage());
            }
        }

        public ProdutoDTO pesquisaCodigo(int codigo)throws NegocioException{
            try{
                return this.toDTO(produtoDAO.buscarPorCodigo(codigo));
            }catch(PersistenciaException ex){
                throw new NegocioException("Erro ao pesquisar produto pelo codigo"+ex.getMessage());
            }
        }
        
        public List<ProdutoDTO> toDTOAll(List <Produto> listaProduto){
           List<ProdutoDTO> listaDTO = new ArrayList <ProdutoDTO>();
            
           
           for(Produto produto :listaProduto){
                listaDTO.add(this.toDTO(produto));
            }
            return listaDTO;
        }
        public ProdutoDTO toDTO(Produto produto){
            return this.modelMapper.map(produto,ProdutoDTO.class);
        }
        public Produto toEntity(ProdutoDTO produtoDTO){
            return this.modelMapper.map(produtoDTO,Produto.class);
        }*/
}
