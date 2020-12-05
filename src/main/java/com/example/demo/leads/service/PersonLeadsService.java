package com.example.demo.leads.service;

import com.example.demo.leads.domain.*;
import com.example.demo.leads.domain.repository.PersonLeadsRepository;
import com.example.demo.leads.dto.PersonLeadsDto;
import com.example.demo.leads.factory.LeadsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(scopeName = "prototype")
public class PersonLeadsService implements LeadsService<PersonLeads,PersonLeadsDto>{

    @Autowired
    private LeadsFactory leadsFactory;
    @Autowired
    private FollowNotifyService followNotifyService;

    @Autowired
    private PersonLeadsRepository leadsRepository;

    private PersonLeads getExistedLeads(){
        return new PersonLeads();
    }

    @Override
    public PersonLeads createLeads(PersonLeadsDto personLeadsDto,Long operatorId){
        //1、创建或者更新leads
       PersonLeads leads=getExistedLeads();
       if(leads==null){
           leads=leadsFactory.createPersonLeads(personLeadsDto);
           leads.start(operatorId);
           leadsRepository.save(leads);
       }else{
           Long oldOperatorId=leads.getOperatorId();
           String customerName=leads.getCustomer().getCustomerName();
           leadsFactory.updatePersonLeads(personLeadsDto,leads);
           leadsRepository.save(leads);
           followNotifyService.changeOperatorId(customerName,oldOperatorId,operatorId);
       }

       return leads;
    }


    public void convertToReservation(Long leadsId,Long operatorId){
        PersonLeads leads=leadsRepository.getOne(leadsId);
        //1、调用order创建看房单
        List<Long> reservationIds=null;
        leads.convertToReservations(operatorId,reservationIds);
        leadsRepository.save(leads);
    }


}
