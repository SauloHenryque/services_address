package br.com.saulo.address.servicos;

import static br.com.saulo.address.exception.ExceptionOrder.checkThrow;
import static br.com.saulo.address.exception.ExceptionsMessagesEnum.REGISTRO_NAO_ENCONTRADO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.saulo.address.entidades.AddressEntidade;
import br.com.saulo.address.repositorios.AddressRepositorio;
import lombok.Data;

@Data
@Service
public class AddressServico {
	
    
    @Autowired
    private AddressRepositorio addressRepositorio;
	
	/**
	 * Método responsável pela listagem das store.
	 * 
	 * @param storeEntidade <br/>
	 *                   Objeto que representa a requisição do serviço
	 *                   {@link AddressEntidade}
	 * 
	 * @return {@link List(addressEntidade)}
	 */

    public List<AddressEntidade> listarAddress(AddressEntidade addressEntidade) {

    	return addressRepositorio.findAll(Example.of(addressEntidade));

    }

	/**
	 * Método responsável pela criação da store.
	 *  
	 * @param storeEntidade <br/>
	 *                   Objeto que representa a requisição
	 *                   {@link addressEntidade}
	 * 
	 * @return {@link AddressEntidade}
	 */
	public AddressEntidade salvarAddress(AddressEntidade addressEntidade) {
		
        return addressRepositorio.save(addressEntidade);

	}
	
	
	/**
	 * Método responsável pela edição da address.
	 *  
	 * @param storeEntidade <br/>
	 *                   Objeto que representa a requisição
	 *                   {@link addressEntidade}
	 * 
	 * @return {@link AddressEntidade}
	 */
	public AddressEntidade atualizarAddress(AddressEntidade addressEntidade) {
		
		checkThrow(!addressRepositorio.existsById(addressEntidade.getId()), REGISTRO_NAO_ENCONTRADO);
		return addressRepositorio.save(addressEntidade);
	} 
	
	
	/**
	 * Método responsável por deletar uma store
	 *  
	 * @param id <br/>
	 * id da store a ser deletada
	 * 
	 */
    public void deletarAddress(long id) {
    	
		checkThrow(!addressRepositorio.existsById(id), REGISTRO_NAO_ENCONTRADO);
    	AddressEntidade storeEntidade = addressRepositorio.findById(id);
    	addressRepositorio.delete(storeEntidade);
    }




}
