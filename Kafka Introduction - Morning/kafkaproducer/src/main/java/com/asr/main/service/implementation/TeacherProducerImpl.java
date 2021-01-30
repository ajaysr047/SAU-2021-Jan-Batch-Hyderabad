package com.asr.main.service.implementation;

import com.asr.main.dto.Teacher;
import com.asr.main.service.TeacherProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TeacherProducerImpl implements TeacherProducerService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void saveTeacher(Teacher teacher) {
        this.kafkaTemplate.send("teacher", teacher);
        System.out.println("Teacher published!");
    }
}
