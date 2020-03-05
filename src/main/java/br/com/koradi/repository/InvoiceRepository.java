package br.com.koradi.repository;

import br.com.koradi.model.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by Cláudio Margulhano.
 */
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
    List<Invoice> findAllByExpirationDate(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate expirationDate);
}
