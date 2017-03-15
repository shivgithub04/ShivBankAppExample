package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitalAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidAmountException;

public interface AccountService {

	Account createAccount(int accountNumber, int amount) throws InsufficientInitalAmountException;

	int depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException, InvalidAmountException;

	int withdrawAmount(int accountNumber, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException;

}