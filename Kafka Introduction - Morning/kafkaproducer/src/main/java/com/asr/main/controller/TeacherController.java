package com.asr.main.controller;

import com.asr.main.dto.Teacher;
import com.asr.main.service.TeacherProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherProducerService teacherProducerService;

    @PostMapping(value = "/produce")
    public ResponseEntity<Object> produceTeacher(@RequestBody Teacher teacher){
        teacherProducerService.saveTeacher(teacher);
        return ResponseEntity.ok(teacher);
    }
}
