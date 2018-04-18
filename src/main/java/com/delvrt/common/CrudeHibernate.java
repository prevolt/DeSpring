package com.delvrt.common;

import java.util.List;



public interface CrudeHibernate  {
	public boolean saveAndUpdateHibernate(Object obj); 
	public boolean updateHibernate(Object obj); 
	public List<?> getDataFromQuery(String sqlQuery);
	public boolean executeUpdate(String strQuery);
	public List<?> getDataInMap(String strQuery);
	public boolean executeSQLQuery(String strQuery);
}
