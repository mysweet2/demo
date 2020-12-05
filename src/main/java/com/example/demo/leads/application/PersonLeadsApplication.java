package com.example.demo.leads.application;

import com.example.demo.leads.service.PersonLeadsService;
import org.springframework.stereotype.Component;

@Component
public class PersonLeadsApplication extends LeadsApplication{
    public PersonLeadsApplication(PersonLeadsService leadsService) {
        super(leadsService);
    }
}
