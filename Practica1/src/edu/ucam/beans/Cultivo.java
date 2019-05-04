package edu.ucam.beans;

public class Cultivo {
	private int id;
	private String description;
	
		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Cultivo(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}


	@Override
	public String toString() {
		return "Cultivo [id=" + id + ", description=" + description + "]";
	}
	

}
