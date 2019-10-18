package group.jpa.ogm.app.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Good implements Serializable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "Name")
    private String name;
    @Column(name = "EnterDate")
    private Date enterDate;
    @Column(name = "Quanity")
    private Integer quantity;
    @Column(name = "Price")
    private Double price;


}
