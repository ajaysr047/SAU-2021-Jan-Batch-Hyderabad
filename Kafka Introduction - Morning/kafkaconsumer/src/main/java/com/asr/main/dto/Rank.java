package com.asr.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rank {
    private int rank;
    private String studentId;
    private String name;
    private LocalDate submissionDate;

    @Override
    public String toString() {
        return "Rank{" +
                "rank=" + rank +
                ", studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", submissionDate=" + submissionDate +
                '}';
    }
}
