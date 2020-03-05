package br.com.koradi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

/**
 * Created by Cláudio Margulhano.
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private LocalDate birthDate;

    private GenderType gender;

    private String phoneNumber;

    private String mobileNumber;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Invoice> invoices;
}
