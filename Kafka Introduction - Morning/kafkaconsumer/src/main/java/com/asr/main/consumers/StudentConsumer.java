package com.asr.main.consumers;


import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.asr.main.dto.Student;

@Component
@KafkaListener(topics = "student", groupId = "myapp")
public class StudentConsumer {
    @KafkaHandler
    public void consumeStudent(Student student){
        System.out.println("Student consumed -> " + student.toString());
    }
}
