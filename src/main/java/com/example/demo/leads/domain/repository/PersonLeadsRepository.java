package com.example.demo.leads.domain.repository;

import com.example.demo.leads.domain.PersonLeads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonLeadsRepository extends JpaRepository<PersonLeads,Long> {
}
