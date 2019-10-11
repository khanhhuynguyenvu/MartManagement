package group.jpa.ogm.app.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Cashier {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;
    @Column(name = "FullName")
    private String fullName;
    @Column(name = "Address")
    private String address;
    @Column(name = "Birthdate")
    private Date birthdate;
    @OneToOne
    private Account account;
    @OneToMany
    private List<Invoice> invoices=new ArrayList<Invoice>();
}
