package com.student.student.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDetailsServices {
    @Autowired
    private Repo rp;

    public void saveEntry(Student student){
        rp.save(student);
    }
}

