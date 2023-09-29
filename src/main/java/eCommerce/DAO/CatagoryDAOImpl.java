package eCommerce.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eCommerce.model.Catagory;
@Repository("catagoryDAO")
@Transactional

public class CatagoryDAOImpl implements CatagoryDAO{

	@Autowired
	SessionFactory sf=null;

	@Override
	public boolean addCatagory(Catagory cat) {
		try {
			sf.getCurrentSession().save(cat);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCatagory(Catagory cat) {
		
		try {
			sf.getCurrentSession().delete(cat);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCatagory(Catagory cat) {
		try {
			sf.getCurrentSession().update(cat);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Catagory> listCatagories() {
		Session session=sf.openSession();
		Query query=session.createQuery("from catagory");
		List<Catagory> listCatagories=query.list();
		session.close();
		return listCatagories;
	}

	@Override
	public Catagory getCatagory(int catagoryId) {
		Session session=sf.openSession();
		Catagory cat=session.get(Catagory.class, catagoryId);
		return cat;
	}

}
