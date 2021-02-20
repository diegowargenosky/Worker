package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private Double baseSalary;

	private WorkerLevel WorkerLevel;
	private Department department;
	private List<HourContract> contracts = new ArrayList<HourContract>();

	public Worker() {

	}

	public Worker(String name, Double baseSalary, WorkerLevel workerLevel, Department department) {
		this.name = name;
		this.baseSalary = baseSalary;
		WorkerLevel = workerLevel;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public WorkerLevel getWorkerLevel() {
		return WorkerLevel;
	}

	public void setWorkerLevel(WorkerLevel workerLevel) {
		WorkerLevel = workerLevel;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	// MÉTODOS //////////////////////////////////////////////////////

	public void addContract(HourContract contract) {

		contracts.add(contract);

	}

	public void removeContract(HourContract contract) {

		contracts.remove(contract);
	}

	public Double income(Integer year, Integer month) {

		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}

		}

		return sum;
	}

}
