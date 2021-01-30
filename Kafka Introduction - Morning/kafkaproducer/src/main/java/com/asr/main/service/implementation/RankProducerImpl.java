package com.asr.main.service.implementation;

import com.asr.main.dto.Rank;
import com.asr.main.service.RankProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RankProducerImpl implements RankProducerService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void saveRank(Rank rank) {
        this.kafkaTemplate.send("rank", rank);
        System.out.println("Rank produced!");
    }
}
