package com.asr.main.service.implementation;

import com.asr.main.dto.Student;
import com.asr.main.service.StudentProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentProducerImpl implements StudentProducerService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void saveStudent(Student student) {
        this.kafkaTemplate.send("student", student);
        System.out.println("Student produced!");
    }
}
