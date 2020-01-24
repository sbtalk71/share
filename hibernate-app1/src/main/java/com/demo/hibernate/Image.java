package com.demo.hibernate;

public class Image {
	private String name;
	private int sizeX;
	private int sizeY;

	public Image() {
		// TODO Auto-generated constructor stub
	}

	public Image(String name, int sizeX, int sizeY) {
		super();
		this.name = name;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

}
