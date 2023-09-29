package eCommerce.DAO;

import java.util.List;

import eCommerce.model.Catagory;

public interface CatagoryDAO {
	
	public boolean addCatagory(Catagory cat);
	public boolean deleteCatagory(Catagory cat);
	public boolean updateCatagory(Catagory cat);
	public List<Catagory> listCatagories();
	public Catagory getCatagory(int catagoryId);

}
