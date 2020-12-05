package com.example.demo.leads.application;

import com.example.demo.leads.domain.Leads;
import com.example.demo.leads.dto.LeadsDto;
import com.example.demo.leads.service.LeadsService;


public abstract class LeadsApplication {

    private LeadsService leadsService;

    public LeadsApplication(LeadsService leadsService) {
        this.leadsService = leadsService;
    }

    public void createLeads(LeadsDto leadsDto, Long operatorId, boolean convertToReservation){
        Leads leads= leadsService.createLeads(leadsDto,operatorId);
        if(convertToReservation){
            leadsService.convertToReservation(leads.getPid(),operatorId);
        }
    }
}
