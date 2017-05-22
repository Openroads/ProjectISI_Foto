package pl.fotoszop.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class TermFormtDTO {
	
	private int employeeId;
	
	@Future
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date date;
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
