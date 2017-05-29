package pl.fotoszop.model;

import java.util.Date;

import pl.fotoszop.modelinterfaces.ITerm;

public class Term implements ITerm{

	private int id;
	private int idEmployee;
	private Date date;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	


}
