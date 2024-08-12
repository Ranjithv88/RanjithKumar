package com.SpringBoot.Redis.Service;

import com.SpringBoot.Redis.Model.Student;
import com.SpringBoot.Redis.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    @Cacheable(value = "student")
    public List<Student> studentGet () {
        return repository.findAll();
    }

//    @CacheEvict(value = "student")
    public String studentPost(Student student) {
        repository.save(student);
        return " Student Saved .......! ";
    }

}
