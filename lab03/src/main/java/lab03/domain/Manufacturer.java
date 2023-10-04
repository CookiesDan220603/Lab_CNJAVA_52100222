package lab03.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Manufacture")
public class Manufacturer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String ID;
    @Column (name = "Name" , nullable = false)
    @Size(min = 3 , max = 128)
    public String Name;
    @Column
    public String Location;
    @Column
    public int Employee;
    public Manufacturer (String ID, String Name, String Location, int Employee){
        this.ID = ID;
        this.Name = Name;
        this.Location = Location;
        this.Employee = Employee;

    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setEmployee(int employee) {
        Employee = employee;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getName() {
        return Name;
    }

    public int getEmployee() {
        return Employee;
    }

    public String getID() {
        return ID;
    }

    public String getLocation() {
        return Location;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Location='" + Location + '\'' +
                ", Employee=" + Employee +
                '}';
    }
}
