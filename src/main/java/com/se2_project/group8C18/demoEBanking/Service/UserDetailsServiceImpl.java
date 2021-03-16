package com.se2_project.group8C18.demoEBanking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.se2_project.group8C18.demoEBanking.Model.Account;
import com.se2_project.group8C18.demoEBanking.Security.MyUserDetails;

public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	AccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account acc = accountService.getAccountByName(username);
		if(acc == null)
		{
			throw new UsernameNotFoundException("Counld not find the account");
		}
		return new MyUserDetails(acc);
	}

}
