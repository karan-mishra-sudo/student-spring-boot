package com.student.student.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class Control {

    @Autowired
    private Repo repo;

    @Transactional
    public void saveEntry(Student st, String id) {
       // Student student = ctrl.findBYId(id);
        repo.save(st);
    }

    @Transactional
    public void saveEntry(Student st) {
        repo.save(st);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Optional<Student> findBYId(String id) {
        return repo.findById(id);
    }
}
