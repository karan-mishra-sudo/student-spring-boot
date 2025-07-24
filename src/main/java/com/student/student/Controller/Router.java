package com.student.student.Controller;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/student")
@Slf4j
public class Router {

  @Autowired
  private Repo repo;

  @Autowired
  private Control ctrl;

  @GetMapping
  public ResponseEntity<?> getAll() {
    List<Student> all = ctrl.getAll();
    if (all != null && !all.isEmpty()) {
      log.info("getting the all student ..");
      return new ResponseEntity<>(all, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(all, HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<Student> createEntry(@RequestBody Student st) {
    try {
      ctrl.saveEntry(st);
      log.info("save the student..");
      return new ResponseEntity<Student>(st, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<Student>(st, HttpStatus.BAD_REQUEST);
    }

  }

  @PostMapping("id/{myId}")
  public ResponseEntity<Student> getStudentById(@PathVariable String myId) {
    Optional<Student> stuEntry = ctrl.findBYId(myId);
    if (stuEntry.isPresent()) {
      log.info("getting the student by his id ...");
      return new ResponseEntity<Student>(stuEntry.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping
  public Student updateById(@PathVariable ObjectId id, @RequestBody Student newEntry) {
    Student old = repo.findById(id.toString()).orElse(null);
    if (old != null) {
      old.setTitle(
          newEntry.getTitle() != null && newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
      old.setContent(newEntry.getContent() != null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());
    }
    log.info("updateing the user ...");
    ctrl.saveEntry(old);
    return old;
  }

  @DeleteMapping("id/{myId}")
  public Boolean deleteStudent(@PathVariable Object myId) {
    log.error("deleteing the user...");
    repo.deleteById(myId.toString());
    return true;
  }

}
