package com.asr.main.consumers;

import com.asr.main.dto.Rank;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "rank", groupId = "myapp")
public class RankConsumer {
    @KafkaHandler
    public void consumeRank(Rank rank){
        System.out.println("Rank consumed -> " + rank.toString());
    }
}

