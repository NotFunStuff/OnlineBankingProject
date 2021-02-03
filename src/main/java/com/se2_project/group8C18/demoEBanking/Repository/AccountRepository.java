package com.se2_project.group8C18.demoEBanking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se2_project.group8C18.demoEBanking.Model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
