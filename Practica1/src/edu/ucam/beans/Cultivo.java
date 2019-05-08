package edu.ucam.beans;

public class Cultivo {
	private String id;
	private String description;
	
		public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Cultivo(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}


	@Override
	public String toString() {
		return "Cultivo [id=" + id + ", description=" + description + "]";
	}
	

}
