package eCommerce.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eCommerce.DAO.CatagoryDAO;
import eCommerce.model.Catagory;

public class CatagoryJunitTest {
	
	static CatagoryDAO catagoryDAO;
	
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("eCommerce");
		context.refresh();
		catagoryDAO=(CatagoryDAO) context.getBean("catagoryDAO");
	}
	@Test
	public void addCatagoryTest() {
		Catagory cat=new Catagory();
		cat.setCatagoryName("T-Shirts");
		cat.setCatagoryDesc("All varieties of T-Shirts");
		
		assertTrue("Problem in adding catagory",catagoryDAO.addCatagory(cat));
		
	}
	public static void main(String[] args) {
		CatagoryJunitTest.executeFirst();
		CatagoryJunitTest cjt=new CatagoryJunitTest();
		cjt.addCatagoryTest();
	}
}
