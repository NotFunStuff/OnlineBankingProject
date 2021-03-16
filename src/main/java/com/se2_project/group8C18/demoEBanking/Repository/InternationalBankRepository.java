package com.se2_project.group8C18.demoEBanking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se2_project.group8C18.demoEBanking.Model.InternationalBank;

@Repository
public interface InternationalBankRepository extends JpaRepository<InternationalBank, Integer>{

}
