package com.example.demo.leads.factory;

import com.example.demo.leads.domain.Leads;
import com.example.demo.leads.domain.PersonCustomer;
import com.example.demo.leads.domain.PersonLeads;
import com.example.demo.leads.dto.CompanyLeadDto;
import com.example.demo.leads.dto.PersonLeadsDto;
import org.springframework.stereotype.Component;

@Component
public class LeadsFactory {


    public PersonLeads createPersonLeads(PersonLeadsDto personLeadsDto){
        PersonLeads leads=new PersonLeads();
        PersonCustomer customer=new PersonCustomer();
        customer.setCustomerName(personLeadsDto.getCustomerName());
        leads.setCustomer(customer);
        return leads;
    }

    public Leads createCompanyLeads(CompanyLeadDto companyLeadDto){
        return null;
    }

    public void updatePersonLeads(PersonLeadsDto personLeadsDto,Leads existedLeads){

    }

}
