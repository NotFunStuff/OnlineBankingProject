package com.se2_project.group8C18.demoEBanking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se2_project.group8C18.demoEBanking.Model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {

}
