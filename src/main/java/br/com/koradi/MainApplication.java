package br.com.koradi;

import br.com.koradi.model.Customer;
import br.com.koradi.model.Invoice;
import br.com.koradi.repository.CustomerRepository;
import br.com.koradi.repository.InvoiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

import static br.com.koradi.model.GenderType.MALE;
import static java.time.LocalDate.of;
import static java.time.Month.MARCH;
import static java.time.Month.MAY;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    CommandLineRunner init(InvoiceRepository invoiceRepository, CustomerRepository customerRepository) {
        return args -> {
            Invoice invoice = new Invoice()
                    .setCompetencyDate(of(2020, MARCH, 5))
                    .setExpirationDate(of(2020, MARCH, 15))
                    .setPaymentDate(of(2020, MARCH, 15))
                    .setValue(BigDecimal.valueOf(999));
            invoiceRepository.save(invoice);

            Customer customer = new Customer()
                    .setFullName("Cláudio Margulhano")
                    .setBirthDate(of(1979, MAY, 15))
                    .setGender(MALE)
                    .setPhoneNumber("(12)99667-3166")
                    .setMobileNumber("(12)99667-3166")
                    .setInvoices(new HashSet<>(Arrays.asList(invoice)));
            customerRepository.save(customer);
            invoice.setCustomer(customer);
            invoiceRepository.save(invoice);

        };
    }
}
