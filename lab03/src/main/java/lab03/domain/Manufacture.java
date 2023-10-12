package lab03.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Manufacture")
public class Manufacture {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int ID;
    @Column (name = "Name" , nullable = false)
    @Size(min = 3 , max = 128)
    public String Name;
    @Column
    public String Location;
    @Column
    public int Employee;
    public Manufacture (String Name, String Location, int Employee){
        this.Name = Name;
        this.Location = Location;
        this.Employee = Employee;

    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setID(int ID) {
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

    public int getID() {
        return ID;
    }

    public String getLocation() {
        return Location;
    }

    @Override
    public String toString() {
        return "Manufactur{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Location='" + Location + '\'' +
                ", Employee=" + Employee +
                '}' +"\n";
    }
}
