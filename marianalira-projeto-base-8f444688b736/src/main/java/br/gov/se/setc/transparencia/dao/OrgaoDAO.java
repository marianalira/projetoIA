package br.gov.se.setc.transparencia.dao;

//import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.gov.se.setc.transparencia.model.Orgao;
import br.gov.se.setc.transparencia.util.HibernateUtil;

public class OrgaoDAO {
	
	private static Session sessionObj = HibernateUtil.getInstance().openSession();
	
	public List<Orgao> getOrgaos() {
		//System.out.println("jsakhdksadjh");
		//List orgaosList = new ArrayList();
		try {
			Query query = sessionObj.createQuery("from Orgao");
			@SuppressWarnings("unchecked") //Suprimindo erro de cast 
			List<Orgao> listOrg = query.getResultList();
			//System.out.println(listOrg.get(0).getCodOrgao());
			return listOrg;
			//return 
			//System.out.println("kjashdkasjhdk");
			//List<Orgao> orgaosList = query.getResultList();
			//System.out.println(orgaosList.get(0).toString());
			//return orgaosList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
