package com.student.student.Controller;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repo extends MongoRepository<Student,String> {
    
}
