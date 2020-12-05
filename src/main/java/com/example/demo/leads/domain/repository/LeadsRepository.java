package com.example.demo.leads.domain.repository;

import com.example.demo.leads.domain.Leads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadsRepository extends JpaRepository<Leads,Long> {
}
