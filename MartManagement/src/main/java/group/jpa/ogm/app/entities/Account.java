package group.jpa.ogm.app.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Account {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;
    @Column(name = "Username")
    private String username;
    @Column(name = "Type")
    private Integer type;
    @Column(name = "Password")
    private String password;
    @Column(name = "StartingDate")
    private Date startingDate;
    @Column(name = "Status")
    private String status;
    @OneToOne
    private Cashier cashier;
}
