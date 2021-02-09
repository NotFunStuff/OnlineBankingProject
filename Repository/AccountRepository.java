package com.se2_project.group8C18.demoEBanking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.se2_project.group8C18.demoEBanking.Model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	@Query("SELECT name FROM account where name = :accountName")
	public Account getAccountByAccountName(@Param("accountName") String accountName);

}
