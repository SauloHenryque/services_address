package br.com.saulo.address.dto.responses;

import java.io.Serializable;

import br.com.saulo.address.ultil.PageAddress;
import io.swagger.annotations.ApiModel;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@ApiModel(description = "Response address", discriminator = "Response address")
public class PageAddressResponse extends PageAddress<AddressResponse> implements Serializable {

    private static final long serialVersionUID = -4679776107027097057L;

    public PageAddressResponse(PageAddress<AddressResponse> p) {
        super(p.getNumber(), p.size, p.totalPages, p.numberOfElements, p.totalElements, p.firstPage, p.hasPreviousPage, p.hasNextPage, p.hasContent, p.first, p.last, p.nextPage, p.previousPage, p.content);
    }
}