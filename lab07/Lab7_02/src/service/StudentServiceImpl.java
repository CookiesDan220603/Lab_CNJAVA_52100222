package service;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl{
    @Autowired
    private StudentService studentService;
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
