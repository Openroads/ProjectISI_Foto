package pl.fotoszop.dto;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import java.util.Date;

public class TermFormtDTO {

    private int employeeId;

    @Future
    @DateTimeFormat(pattern = "dd/mm/yyyy")
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
