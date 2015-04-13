package factoryDao;

import dao.BookDao;
import daoImpl.BookDaoHibernateImpl;
import daoImpl.BookDaoInMemoryImpl;
import daoImpl.BookDaoJDBCImpl;

public class FactoryDao {
	public static BookDao chooseDaoImpl(int type) {
		if(type==1) return new BookDaoHibernateImpl();
		else if(type==2) return new BookDaoJDBCImpl();
		else if(type==3)return new BookDaoInMemoryImpl();
		return new BookDaoHibernateImpl(); //default
 	}
}
