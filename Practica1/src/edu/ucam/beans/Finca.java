package edu.ucam.beans;

public class Finca {
	
	private int id;
	private int hectareas;
	private String name;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHectareas() {
		return hectareas;
	}

	public void setHectareas(int hectareas) {
		this.hectareas = hectareas;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Finca(int id, int hectareas, String name) {
		super();
		this.id = id;
		this.hectareas = hectareas;
		this.name = name;
	}
	
}
