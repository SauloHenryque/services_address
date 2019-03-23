package br.com.saulo.address.servicos;

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
	 * Método responsável pela edição da store.
	 *  
	 * @param storeEntidade <br/>
	 *                   Objeto que representa a requisição
	 *                   {@link addressEntidade}
	 * 
	 * @return {@link AddressEntidade}
	 */
	public AddressEntidade atualizarAddress(AddressEntidade addressEntidade) {
		
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
    	
    	AddressEntidade storeEntidade = addressRepositorio.findById(id);
    	addressRepositorio.delete(storeEntidade);
    }




}
