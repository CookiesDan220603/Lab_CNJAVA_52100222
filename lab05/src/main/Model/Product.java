package Model;

import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "username", unique = true, nullable = false)
    @GeneratedValue(strategy =GenerationType.AUTO)
    public int id;
    public  String name;
    public int price;

    public Product (String name,int price){
        this.name = name;
        this.price = price;
    }
    public Product(){

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
