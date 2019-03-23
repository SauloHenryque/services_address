package br.com.saulo.address.dto.persists;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "store_persist_description")
public class AddressPersist implements Serializable {
	
	private static final long serialVersionUID = -7329881749188627883L;
	 
    @ApiModelProperty(value = "Nome da rua", position = 2)
    @NotNull(message = "Rua não pode ser nulo")
	@Size(min = 1, max = 250, message= "Rua deve ter entre 1 a 250 caracter")
	private String rua;
	 
    @ApiModelProperty(value = "Número", position = 3)
	@Size(min = 1, max = 50, message= "Número deve ter entre 1 a 50 caracter")
	private String numero;
	 
    @ApiModelProperty(value = "CEP", position = 4)
    @NotNull(message = "CEP não pode ser nulo")
    @Size(min = 8, max = 8, message= "CEP deve ter 8 caracter")
	private String cep;
	 
    @ApiModelProperty(value = "Cidade", position = 5)
    @NotNull(message = "Cidade não pode ser nulo")
	@Size(min = 1, max = 50, message= "Cidade deve ter entre 1 a 255 caracter")
	private String cidade;
	 
    @ApiModelProperty(value = "Estado", position = 5)
    @NotNull(message = "Estadp não pode ser nulo")
	@Size(min = 2, max = 2, message= "Estado deve ter 2 caracter")
	private String estado;
	    
	@ApiModelProperty(value = "País", position = 6)
    @NotNull(message = "Nome não pode ser nulo")
	@Size(min = 1, max = 50, message= "País deve ter entre 1 a 50 caracter")
	private String pais;
	 
    @ApiModelProperty(value = "Identificação da Store", position = 7)
	private Long id_store;
	 
    @ApiModelProperty(value = "Identificação da Order", position = 8)
	private Long id_order;

}
