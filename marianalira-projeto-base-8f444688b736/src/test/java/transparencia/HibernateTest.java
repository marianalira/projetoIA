package transparencia;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import br.gov.se.setc.transparencia.util.HibernateUtil;

@DisplayName("HibernateUtil Test")
class HibernateTest{
	private static Session sessionObj;
	
	@Test
	@Order(1)
	@DisplayName("Session Instance Test")
	void sessionTest() {
		try {
			sessionObj = HibernateUtil.getInstance().openSession();
		}catch (Exception e) {
			// TODO: handle exception
			fail("Session instance test fail");
		}
	}
	
	@Test
	@Order(2)
	@DisplayName("Hibernate Query Test")
	void queryTest() {
		try {
			sessionObj = HibernateUtil.getInstance().openSession();
			@SuppressWarnings({ "rawtypes", "deprecation" })
			SQLQuery q = sessionObj.createSQLQuery("SELECT * FROM ODS.TB_PDE_PODER");
			q.list();
		}catch (Exception e) {
			// TODO: handle exception
			fail("Hibernate query test fail");
		}
		
	}

}
