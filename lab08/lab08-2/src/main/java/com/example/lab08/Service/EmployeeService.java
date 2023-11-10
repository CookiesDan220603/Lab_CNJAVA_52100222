package com.example.lab08.Service;

import com.example.lab08.Model.Employees;
import com.example.lab08.Repository.EmployeeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
@Service
public class EmployeeService implements EmployeeRepository{
    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Employees> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Employees> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Employees> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Employees getOne(Integer integer) {
        return null;
    }

    @Override
    public Employees getById(Integer integer) {
        return null;
    }

    @Override
    public Employees getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Employees> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Employees> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Employees> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Employees> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Employees> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Employees> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Employees, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Employees> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Employees> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Employees> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Employees> findAll() {
        return null;
    }

    @Override
    public List<Employees> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Employees entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employees> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Employees> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Employees> findAll(Pageable pageable) {
        return null;
    }
}