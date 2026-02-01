package com.tropic.service;

import com.tropic.model.Student;
import com.tropic.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StudentService")
@Scope("singleton")
public class StudentService {

    @Autowired
    @Qualifier("StudentRepo")
    private StudentRepo repo;

    public void addStudent(Student student) {
        repo.saveStudent(student);
    }

    public StudentRepo getRepo() {
        return repo;
    }

    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }
}
