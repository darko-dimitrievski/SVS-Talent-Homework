package com.seavus.aliexpress.crud.daoimpl;

import org.springframework.stereotype.Repository;

import com.seavus.aliexpress.crud.dao.AccountDao;
import com.seavus.aliexpress.hibernateTemplate.HIbernateTemplate;
import com.seavus.aliexpress.hibernateTemplate.HibernateWriter;
import com.seavus.aliexpress.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {


	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		new HIbernateTemplate().executeQuery(new HibernateWriter() {
			
			@Override
			public Object insertQuery() {
				// TODO Auto-generated method stub
				return account;
			}
		});

	}

}
