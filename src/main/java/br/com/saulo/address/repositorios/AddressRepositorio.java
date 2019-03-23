package br.com.saulo.address.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.saulo.address.entidades.AddressEntidade;

@Repository
public interface AddressRepositorio extends JpaRepository<AddressEntidade, Long> {

	AddressEntidade findById(long id);

}
