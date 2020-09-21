package dto;

public class PersonDTO {
	private int idPerson;
	private String name;
	
	public PersonDTO() {}
	
	public PersonDTO(int idPerson) {
		this.idPerson = idPerson;
	}
	
	public int getIdPerson() {
		return idPerson;
	}
	
	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "PersonDTO ( " + "idPerson =" + ", name=" + name + ")";
	}
	
}
