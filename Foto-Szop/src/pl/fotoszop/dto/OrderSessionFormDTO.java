package pl.fotoszop.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class OrderSessionFormDTO {


    // ORDER SESSION //

	 
    private Integer termId;


	@NotEmpty
    @Size(min = 4, max = 256)
    private String subject;
    @NotEmpty
    @Size(min = 4, max = 256)
    private String sessionAddress;
    @NotEmpty
    @Size(min = 4, max = 256)
    private String sessionPlace;
    
    private int bonus;
    private int countOrder;
    

    
    public int getCountOrder() {
		return countOrder;
	}

	public void setCountOrder(int countOrder) {
		this.countOrder = countOrder;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	//@Future
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
	
   public Integer getTermId() {
		return termId;
	}

	public void setTermId(Integer termId) {
		this.termId = termId;
	}

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSessionAddress() {
        return sessionAddress;
    }

    public void setSessionAddress(String sessionAddress) {
        this.sessionAddress = sessionAddress;
    }

    public String getSessionPlace() {
        return sessionPlace;
    }

    public void setSessionPlace(String sessionPlace) {
        this.sessionPlace = sessionPlace;
    }

}
