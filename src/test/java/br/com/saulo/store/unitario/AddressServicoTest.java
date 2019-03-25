package br.com.saulo.store.unitario;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;

import br.com.saulo.address.dto.requests.AddressRequest;
import br.com.saulo.address.entidades.AddressEntidade;
import br.com.saulo.address.exception.NotFoundException;
import br.com.saulo.address.repositorios.AddressRepositorio;
import br.com.saulo.address.servicos.AddressServico;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
public class AddressServicoTest {
 
	 @InjectMocks
     private AddressServico addressServicoMock;
	
     @Mock
     private AddressRepositorio addressRepositorio;
     
     @Mock
     private AddressEntidade addressEntidade;
     
     private AddressRequest addressRequest;

     @Before
     public void setup() {

          MockitoAnnotations.initMocks(this);
          addressRequest = new AddressRequest();
     }
     
     @Test
     public void salvarAdrress(){
    	 
    	 AddressEntidade	addressEntidadeNovo		 = new AddressEntidade();
    	 
    	 addressEntidadeNovo.setRua("Rua teste");
    	 addressEntidadeNovo.setNumero("68");
    	 addressEntidadeNovo.setCep("58063450");
    	 addressEntidadeNovo.setCidade("João Pessoa");
    	 addressEntidadeNovo.setEstado("PB");
    	 addressEntidadeNovo.setPais("Brasil");
    	 addressEntidadeNovo.setId_store(1L);
    	 
         Mockito.when(addressRepositorio.save(Mockito.any(AddressEntidade.class))).thenReturn(addressEntidadeNovo);

         AddressEntidade addressEntidadeCadastrado = addressServicoMock.salvarAddress(addressEntidadeNovo);

         testCase(addressEntidadeNovo, addressEntidadeCadastrado);
     }
     
    @Test
    public void atualizarStore(){
    	 
    	AddressEntidade	addressEntidadeNovo		 = new AddressEntidade();
    	 
    	addressEntidadeNovo.setId(1L);
   	 	addressEntidadeNovo.setRua("Rua teste");
   	 	addressEntidadeNovo.setNumero("68");
   	 	addressEntidadeNovo.setCep("58063450");
   	 	addressEntidadeNovo.setCidade("João Pessoa");
   	 	addressEntidadeNovo.setEstado("PB");
   	 	addressEntidadeNovo.setPais("Brasil");
   	 	addressEntidadeNovo.setId_store(1L);

   	 	Mockito.when(addressRepositorio.existsById(1L)).thenReturn(true);
        Mockito.when(addressRepositorio.save(Mockito.any(AddressEntidade.class))).thenReturn(addressEntidadeNovo);

        AddressEntidade addressEntidadeCadastrado = addressServicoMock.salvarAddress(addressEntidadeNovo);

        testCase(addressEntidadeNovo, addressEntidadeCadastrado);
        TestCase.assertEquals(addressEntidadeNovo.getId(), addressEntidadeCadastrado.getId());
    }
    
    @Test(expected = NotFoundException.class)
    public void atualizarAddressNaoEncontrado(){
   	 
    	AddressEntidade	addressEntidadeNovo		 = new AddressEntidade();
   	 
    	addressEntidadeNovo.setId(1L);
   	 	addressEntidadeNovo.setRua("Rua teste");
   	 	addressEntidadeNovo.setNumero("68");
   	 	addressEntidadeNovo.setCep("58063450");
   	 	addressEntidadeNovo.setCidade("João Pessoa");
   	 	addressEntidadeNovo.setEstado("PB");
   	 	addressEntidadeNovo.setPais("Brasil");
   	 	addressEntidadeNovo.setId_store(1L);

   	 	Mockito.when(addressRepositorio.existsById(1L)).thenReturn(false);
        Mockito.when(addressRepositorio.save(Mockito.any(AddressEntidade.class))).thenReturn(addressEntidadeNovo);

        addressServicoMock.salvarAddress(addressEntidadeNovo);

    }
    
    @Test()
    public void deletarAddress(){
   	 
   	 	Mockito.when(addressRepositorio.existsById(1L)).thenReturn(true);
   	 	Mockito.when(addressRepositorio.findById(1L)).thenReturn(addressEntidade);

        addressServicoMock.deletarAddress(1L);
    }
    
    @Test(expected = NotFoundException.class)
    public void deletarAddressInexistente(){
   	 
   	 	Mockito.when(addressRepositorio.existsById(1L)).thenReturn(false);
   	 	Mockito.when(addressRepositorio.findById(1L)).thenReturn(addressEntidade);

   	 	addressServicoMock.deletarAddress(1L);
    }


	private static void testCase(AddressEntidade addressEntidade, AddressEntidade addressEntidadeCadastrado) {
         
         TestCase.assertNotNull(addressEntidade);
         TestCase.assertEquals(addressEntidade.getRua(), addressEntidadeCadastrado.getRua());
         TestCase.assertEquals(addressEntidade.getNumero(), addressEntidadeCadastrado.getNumero());
         TestCase.assertEquals(addressEntidade.getCep(), addressEntidadeCadastrado.getCep());
         TestCase.assertEquals(addressEntidade.getCidade(), addressEntidadeCadastrado.getCidade());
         TestCase.assertEquals(addressEntidade.getEstado(), addressEntidadeCadastrado.getEstado());
         TestCase.assertEquals(addressEntidade.getPais(), addressEntidadeCadastrado.getPais());
         TestCase.assertEquals(addressEntidade.getId_store(), addressEntidadeCadastrado.getId_store());
         TestCase.assertEquals(addressEntidade.getId_order(), addressEntidadeCadastrado.getId_order());
         
    }
     
    @Test
    public void testListar() {

    	AddressEntidade	addressEntidadeNovo		 = new AddressEntidade();
	 
    	addressEntidadeNovo.setRua("Rua teste");
    	
        List<AddressEntidade> listaAddressEntidade  = Lists.newArrayList(addressEntidade);
    	 	
        Mockito.when(addressRepositorio.findAll(Example.of(addressEntidadeNovo))).thenReturn(listaAddressEntidade);
    	 
        List<AddressEntidade> listAdrressEntidade = addressServicoMock.listarAddress(addressEntidade);
       
    	assertNotNull(listAdrressEntidade);
        

    }

}
