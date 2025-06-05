package com.hive.repository;

import com.hive.domain.CarbonCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarbonCreditRepository extends JpaRepository<CarbonCredit, Long>  { }
