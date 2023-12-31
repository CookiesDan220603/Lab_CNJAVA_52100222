package tdtu.edu.ex02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.ex02.models.Student;
import tdtu.edu.ex02.services.StudentService;
import java.util.Optional;

@Service
public class StudentServiceImp {
    @Autowired
    public StudentService studentService;


    public Iterable<Student> findAll() {
        return studentService.findAll();
    }

    public void save(Student student) {
        studentService.save(student);
    }

    public void deleteById(Long id) {
        studentService.deleteById(id);
    }
    public void update(Student student) {
        studentService.save(student);
    }

    public Optional<Student> findById(Long id) {
        return studentService.findById(id);
    }
}