package com.asr.main.controller;

import com.asr.main.dto.Student;
import com.asr.main.service.StudentProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentProducerService studentProducerService;

    @PostMapping("/produce")
    public ResponseEntity<Object> produceStudent(@RequestBody Student student){
        studentProducerService.saveStudent(student);
        return ResponseEntity.ok(student);
    }
}
