package com.example.demo.leads.service;

import org.springframework.stereotype.Component;

@Component
public class FollowNotifyService {
    /**
     * 跟进人变化，通知原跟进人
     * @param customerName
     * @param oldOperatorId
     * @param newOperatorId
     */
    public void changeOperatorId(String customerName,Long oldOperatorId,Long newOperatorId){

    }
}
