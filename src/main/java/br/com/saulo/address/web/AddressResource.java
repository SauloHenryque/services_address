package br.com.saulo.address.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saulo.address.dto.persists.AddressPersist;
import br.com.saulo.address.dto.requests.AddressRequest;
import br.com.saulo.address.dto.responses.AddressResponse;
import br.com.saulo.address.entidades.AddressEntidade;
import br.com.saulo.address.servicos.AddressServico;
import br.com.saulo.address.ultil.GenericConvert;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "address")
@RequestMapping(value = "/api/address", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressResource {
	
	 	@Autowired
		private AddressServico addressServico;
		
	 	@PostMapping
	    public ResponseEntity<?> salvar(@RequestBody @Valid AddressPersist request) {

			AddressEntidade addressEntidade = GenericConvert.convertModelMapper(request, AddressEntidade.class);
			addressEntidade 				= addressServico.salvarAddress(addressEntidade);
			AddressResponse response 		= GenericConvert.convertModelMapper(addressEntidade, AddressResponse.class);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    }
		
		@GetMapping
	    public ResponseEntity<?> listar(@Valid AddressRequest addressRequest) {
			
			AddressEntidade addressEntidade = GenericConvert.convertModelMapper(addressRequest, AddressEntidade.class);	
			return ResponseEntity.status(HttpStatus.OK).body(addressServico.listarAddress(addressEntidade));
	    }
		
		@PutMapping("/{id}")
	    public ResponseEntity<?> atualizar(@PathVariable("id") long id, @RequestBody @Valid AddressPersist request ) {
			
			AddressEntidade addressEntidade 	= GenericConvert.convertModelMapper(request, AddressEntidade.class);
			addressEntidade.setId(id);
			
			addressEntidade 				= addressServico.atualizarAddress(addressEntidade);
			AddressResponse response 		= GenericConvert.convertModelMapper(addressEntidade, AddressResponse.class);

			return ResponseEntity.status(HttpStatus.OK).body(response);
	    }
		
		@DeleteMapping("/{id}")
	    public ResponseEntity<?> deletar(@PathVariable("id") long id) {
			
			addressServico.deletarAddress(id);
	        return ResponseEntity.ok(HttpStatus.OK);
	    }

}
