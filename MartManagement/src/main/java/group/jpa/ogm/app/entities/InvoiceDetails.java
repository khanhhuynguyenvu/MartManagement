package group.jpa.ogm.app.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class InvoiceDetails {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;
    @OneToOne
    private Invoice invoice;
    @OneToMany
    private List<Good> goods;
}
