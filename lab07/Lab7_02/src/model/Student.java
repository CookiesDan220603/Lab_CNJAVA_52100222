package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class Student {
    @Id
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Double ieltsscore;

    public Student(Long id, String name, Integer age, String email, Double ieltsscore){
        this.id = id;
        this.name = name;
        this.age = age;
        this.email=email;
        this.ieltsscore=ieltsscore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", ieltsscore=" + ieltsscore +
                '}';
    }
}
