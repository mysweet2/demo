package com.example.demo.leads.service;

import com.example.demo.leads.domain.Leads;
import com.example.demo.leads.dto.LeadsDto;

public interface LeadsService<L extends Leads,D extends LeadsDto> {
     L createLeads(D dto, Long operatorId);
     void convertToReservation(Long leadsId,Long operatorId);
}
