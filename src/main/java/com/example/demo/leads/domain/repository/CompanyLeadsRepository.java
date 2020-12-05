package com.example.demo.leads.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyLeadsRepository extends JpaRepository<CompanyLeadsRepository,Long> {
}
