package unq.tpi.persistencia.performanceEj.model;

public class DatosEmpleados {

	private String firstName;
    private String lastName;
    private String title;
    private Double salaryAmount;
    
    public DatosEmpleados(String firstName, String lastName,String title, Double salaryAmount) {
    	super();
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.title = title;
    	this.salaryAmount = salaryAmount;
    }
    
        
    public String getNombreCompleto() {
        return this.getLastName() + ", " + this.getFirstName();
    }
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getSalaryAmount() {
		return salaryAmount;
	}
	public void setSalaryAmount(Double salaryAmount) {
		this.salaryAmount = salaryAmount;
	}
    
    
	
}
