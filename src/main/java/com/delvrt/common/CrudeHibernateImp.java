package com.delvrt.common;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Service("CrudeHibernate")
public class CrudeHibernateImp implements CrudeHibernate {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired 
	JdbcTemplate jdbc;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public boolean executeSQLQuery(String sqlQuery) {
		jdbc.execute(sqlQuery);
		return true;
	}

	@Override
	public boolean saveAndUpdateHibernate(Object obj) {
			Session session = this.sessionFactory.getCurrentSession();
			 session.saveOrUpdate(obj);
			 return true;
	}

	@Override
	public List<?> getDataFromQuery(String sqlQuery) {
		Session session = this.sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sqlQuery);
		List dataList = query.list();
		return dataList;
	}

	@Override
	public boolean executeUpdate(String sqlQuery) {
		jdbc.execute(sqlQuery);
		return true;
	}

	@Override
	public List<?> getDataInMap(String strQuery) {
		List<Map<String, Object>> list = jdbc.queryForList(strQuery);
		return list;
	}

	@Override
	public boolean updateHibernate(Object obj) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(obj);
		return true;
	}

	
	 

}
