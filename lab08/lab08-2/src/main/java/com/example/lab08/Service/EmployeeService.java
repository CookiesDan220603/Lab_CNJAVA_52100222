package com.example.lab08.Service;

import com.example.lab08.Model.Employees;
import com.example.lab08.Repository.EmployeeRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Component
@Service
public class EmployeeService implements EmployeeRepository {
    @Override
    public <S extends Employees> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Employees> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Employees> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<Employees> findAll() {
        return null;
    }

    @Override
    public Iterable<Employees> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Employees entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employees> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
