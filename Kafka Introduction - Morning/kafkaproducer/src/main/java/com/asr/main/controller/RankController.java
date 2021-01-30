package com.asr.main.controller;

import com.asr.main.dto.Rank;
import com.asr.main.service.RankProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/rank")
public class RankController {
    private static int rank;

    @Autowired
    RankProducerService rankProducerService;

    @PostMapping("/produce")
    public ResponseEntity<Object> produceRank(@RequestBody Rank rank){

        rank.setRank(++RankController.rank);
        rank.setSubmissionDate(LocalDate.now());

        rankProducerService.saveRank(rank);

        return ResponseEntity.ok(rank);
    }
}
