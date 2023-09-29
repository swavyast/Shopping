package eCommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Catagory{
	@Id
	@GeneratedValue
	int catagoryId;
	
	String catagoryName;
	String catagoryDesc;
	public int getCatagoryId() {
		return catagoryId;
	}
	public void setCatagoryId(int catagoryId) {
		this.catagoryId = catagoryId;
	}
	public String getCatagoryName() {
		return catagoryName;
	}
	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}
	public String getCatagoryDesc() {
		return catagoryDesc;
	}
	public void setCatagoryDesc(String catagoryDesc) {
		this.catagoryDesc = catagoryDesc;
	}
}
