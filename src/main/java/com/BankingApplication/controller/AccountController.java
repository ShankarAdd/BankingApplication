package com.BankingApplication.controller;


import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankingApplication.dto.AccountDto;
import com.BankingApplication.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	//add account rest api
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	//getting account detail
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable long id){
		AccountDto accountDto = accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
	}
	
	//Deposit the amount
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposite(@PathVariable long id, @RequestBody Map<String,Double> request){
		AccountDto accountDto= accountService.deposite(id, request.get("amount"));
		return ResponseEntity.ok(accountDto);
		
	}
	
	//Withdraw
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable long id, @RequestBody Map<String, Double> request){
		Double amount = request.get("amount");
		
		AccountDto accountDto= accountService.withdraw(id, amount);
		
		return ResponseEntity.ok(accountDto);
	}
	
	//To get all accounts
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accountDtos = accountService.getAllAccounts();
		return ResponseEntity.ok(accountDtos);
	}
	
	//Deleting the particular account
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable long id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Your account deleted successfully");
	}

}
 