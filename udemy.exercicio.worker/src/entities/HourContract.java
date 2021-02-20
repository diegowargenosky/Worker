package entities;

import java.util.Date;

public class HourContract {

	Date date;
	Double ValuePerHour;
	Integer Hours;

	public HourContract() {

	}

	public HourContract(Date date, Double valuePerHour, Integer hours) {
		this.date = date;
		this.ValuePerHour = valuePerHour;
		this.Hours = hours;
	}
	
	
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return ValuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		ValuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return Hours;
	}

	public void setHours(Integer hours) {
		Hours = hours;
	}
	
	// MÉTODOS //////////////////////////////////////////////////
	public Double totalValue() {
		
		double total = this.Hours * this.ValuePerHour;
		return total;
		
	}

}
