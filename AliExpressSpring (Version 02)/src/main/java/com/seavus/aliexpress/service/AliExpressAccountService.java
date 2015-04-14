package com.seavus.aliexpress.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seavus.aliexpress.crud.daoimpl.AccountDaoImpl;
import com.seavus.aliexpress.model.Account;

@Service
@Transactional
public class AliExpressAccountService {
	private AccountDaoImpl accountDaoImpl;

	@Autowired
	public AliExpressAccountService(AccountDaoImpl accountDaoImpl) {
		this.accountDaoImpl = accountDaoImpl;
	}

	public void addAccount(Account account) {
		accountDaoImpl.addAccount(account);
	}
}
