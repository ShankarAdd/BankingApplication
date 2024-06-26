package com.BankingApplication.service;

import java.util.List;

import com.BankingApplication.dto.AccountDto;

public interface AccountService {

	AccountDto createAccount(AccountDto account);
	
	AccountDto getAccountById(long id);
	
	AccountDto deposite(long id,double amount);
	
	AccountDto withdraw(long id,double amount);
	
	List<AccountDto> getAllAccounts();
	
	void deleteAccount(long id);
}
