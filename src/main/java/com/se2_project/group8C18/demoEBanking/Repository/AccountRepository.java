package com.se2_project.group8C18.demoEBanking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.se2_project.group8C18.demoEBanking.Model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	
	
}
