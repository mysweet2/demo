package com.example.demo.leads.domain;

import lombok.Data;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Leads的LifeCycle
 * 1、new->start->follow->convertToReservation->finish
 * 2、new->start->dol
 */
@Data
@Entity
@DiscriminatorColumn(name="customer_type", discriminatorType= DiscriminatorType.STRING)
public class Leads {
    private Long pid;
    private LeadsFollowPlan lastFollowPlan;
    private String status;
    private Long operatorId;
    private List<LeadsFollowPlan> leadsFollowPlans;
    private List<LeadsReservation> leadsReservations;

    public void start(Long operatorId){
        this.status="ING";
        this.operatorId=operatorId;
        LeadsFollowPlan plan=new LeadsFollowPlan();
        plan.setStatus("EBL");
        plan.setOperatorId(operatorId);
        this.lastFollowPlan=plan;

    }

    public void follow(Long operatorId){
        LeadsFollowPlan plan=new LeadsFollowPlan();
        plan.setStatus("EBL");
        plan.setFollowWay("Wechat");
        plan.setOperatorId(operatorId);
    }

    public void convertToReservations(Long operatorId,List<Long> reservationIds){
        leadsReservations=new ArrayList<>();
        leadsReservations.forEach(x->{
            LeadsReservation leadsReservation=new LeadsReservation();
            leadsReservations.add(leadsReservation);
        });
        finish(operatorId);
    }

    public void finish(Long operatorId){
        lastFollowPlan.setStatus("DON");
        lastFollowPlan.setRealOperatorId(operatorId);
        this.status="CONVERTED";
    }

    public void invalid(Long operatorId){
        this.status="INV";
    }

}
