package com.example.demo.leads.domain;

import lombok.Data;

@Data
public class LeadsFollowPlan {
    private Long operatorId;
    private String status;
    private String followWay;
    private String followResult;
    private Long realOperatorId;
}
