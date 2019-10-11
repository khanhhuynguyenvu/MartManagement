package group.jpa.ogm.app.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "FullName")
    private String fullName;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Address")
    private String address;
    @OneToMany
    private List<Good> goods = new ArrayList<Good>();

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    public Customer() {
    }

    public Customer(String fullName, String phone, String address) {
        fullName = fullName;
        this.phone = phone;
        this.address = address;
    }
}
