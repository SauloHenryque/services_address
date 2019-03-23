package br.com.saulo.address.dto.responses;


import java.io.Serializable;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Response address")
public class AddressResponse implements Serializable{

	private static final long serialVersionUID = 4192610937139207457L;
	
	/**
     * Código de Identificação.
     */
    @ApiModelProperty(value = "Identificação da address", position = 1)
    private Long id;

    /**
     * Nome da rua.
     */
    @ApiModelProperty(value = "Nome da rua", position = 2)
    private String rua;
    
    /**
     * número
     */
    @ApiModelProperty(value = "Número", position = 3)
    private String numero;
    
    /**
     * CEP
     */
    @ApiModelProperty(value = "CEP", position = 4)
    private String cep;
    
    /**
     * Cidade
     */
    @ApiModelProperty(value = "Cidade", position = 5)
    private String cidade;
    
    /**
     * Estado
     */
    @ApiModelProperty(value = "Estado", position = 5)
    private String estado;
    
    /**
     * País
     */
    @ApiModelProperty(value = "País", position = 6)
    private String pais;
    
    /**
     * Identificação da store
     */
    @ApiModelProperty(value = "Identificação da Store", position = 7)
    private Long id_store;
    
    /**
     * Identificação da order
     */
    @ApiModelProperty(value = "Identificação da Order", position = 8)
    private Long id_order;
}
