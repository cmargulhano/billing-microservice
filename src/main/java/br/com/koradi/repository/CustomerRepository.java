package br.com.koradi.repository;

import br.com.koradi.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Cláudio Margulhano.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByFullName(String fullName);

}
