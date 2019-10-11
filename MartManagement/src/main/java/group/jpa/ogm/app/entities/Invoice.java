package group.jpa.ogm.app.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "InvoiceDate")
    private Date invoiceDate;
    @OneToOne
    @JoinColumn(name = "Cashier")
    private Cashier cashier;
    @OneToOne
    private InvoiceDetails invoiceDetails;
}
