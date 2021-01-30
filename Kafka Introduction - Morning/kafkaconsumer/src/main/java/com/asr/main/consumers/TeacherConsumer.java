package com.asr.main.consumers;

import com.asr.main.dto.Teacher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TeacherConsumer {

    @KafkaListener(topics = "teacher", groupId = "myapp")
    public void consumeTeacher(Teacher teacher){
        System.out.println("Teacher consumed -> " + teacher.toString());
    }
}
