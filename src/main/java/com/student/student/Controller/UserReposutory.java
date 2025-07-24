package com.student.student.Controller;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserReposutory extends MongoRepository<Student ,Object> {
    Student findByStudentName(String username);
}
