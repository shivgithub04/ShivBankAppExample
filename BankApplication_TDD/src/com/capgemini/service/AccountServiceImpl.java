package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitalAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidAmountException;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	
	AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository)
	{
		this.accountRepository=accountRepository;
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.AccountService#createAccount(int, int)
	 */
	@Override
	public Account createAccount(int accountNumber,int amount)throws InsufficientInitalAmountException
	{
		if(amount<500)
		{
			throw new InsufficientInitalAmountException();
		}
		
		Account account =new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		
		if(accountRepository.save(account))
		{
			return account;
		}
			
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.AccountService#depositAmount(int, int)
	 */
	@Override
	public int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException, InvalidAmountException
	{
		Account searchAccount;
		if(accountNumber>0){
			 searchAccount = accountRepository.searchAccount(accountNumber);
			if(searchAccount!=null){
				if(amount>0){
					searchAccount.setAmount(searchAccount.getAmount()+amount);
				} else{
					throw new InvalidAmountException();
				}
			}
		} else{
			throw new InvalidAccountNumberException();
		}
		
		return searchAccount.getAmount();
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.AccountService#withdrawAmount(int, int)
	 */
	@Override
	public int withdrawAmount(int accountNumber,int amount)throws InvalidAccountNumberException,InsufficientBalanceException
	{
		return 0;
	}
	

}
