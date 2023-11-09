import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.StudentService;
import service.StudentServiceImpl;

import java.util.List;

@SpringBootApplication
public class Lab72Application implements CommandLineRunner {
    private StudentServiceImpl studentServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(Lab72Application.class, args);
    }

    @Override
    public void run(String... args) {
        Student student1 = Student.builder()
                .name("van thao")
                .age(20)
                .email("vanthao@gmail.com")
                .ieltsscore(7.5)
                .build();
        studentServiceImpl.save(student1);

        Student student2 = Student.builder()
                .name("thao tran")
                .age(22)
                .email("thaotran@gmail.com")
                .ieltsscore(8.0)
                .build();
        studentServiceImpl.save(student2);

        Student student3 = Student.builder()
                .name("tran van thao")
                .age(21)
                .email("tranvanthao@gmail.com")
                .ieltsscore(6.5)
                .build();
        studentServiceImpl.save(student3);

        // Read all students
        Iterable<Student> students = studentServiceImpl.findAll();
        students.forEach(System.out::println);

        // update
        Student studentToUpdate = studentServiceImpl.findById(student1.getId()).orElse(null);
        if (studentToUpdate != null) {
            studentToUpdate.setName("king of lord");
            studentServiceImpl.update(studentToUpdate);
        }
        System.out.println("After update--------------------------------------------------------------------");
        students = studentServiceImpl.findAll();
        students.forEach(System.out::println);

        // delete
        studentServiceImpl.deleteById(student2.getId());
        System.out.println("After delete-------------------------------------------------------------------");
        students = studentServiceImpl.findAll();
        students.forEach(System.out::println);
    }

}
