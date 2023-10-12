package lab03.domain;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Phone")
public class Phone {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int ID;
    @Column (name = "Name" , nullable = false)
    @Size(min = 3 , max = 128)
    public String Name;
    @Column (name = "Price", nullable = false)
    public int Price;
    @Column (name = "Color", nullable = false)
    public String Color;
    @Column
    public String Country;
    @Column
    public int Quantity;

    public Phone (String Name, int Price, String Color, String Country, int Quantity ){
        this.ID = ID;
        this.Name = Name;
        this.Price = Price;
        this.Color = Color;
        this.Country = Country;
        this.Quantity = Quantity;
    }

    public int getID() {
        return ID;
    }

    public int getPrice() {
        return Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getColor() {
        return Color;
    }

    public String getCountry() {
        return Country;
    }

    public String getName() {
        return Name;
    }

    public void setColor(String color) {
        this.Color = Color;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", Color='" + Color + '\'' +
                ", Country='" + Country + '\'' +
                ", Quantity=" + Quantity +
                '}'+"\n";
    }
}
