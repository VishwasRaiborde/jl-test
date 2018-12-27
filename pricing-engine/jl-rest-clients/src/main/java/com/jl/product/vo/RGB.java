package com.jl.product.vo;

public  class RGB {
	
	int red;
	int blue;
	int green;

	public RGB(int red, int blue, int green) {
		super();
		this.red = red;
		this.blue = blue;
		this.green = green;
	}

	public int getRed() {
		return this.red;
	}

	public int getBlue() {
		return this.blue;
	}


	public int getGreen() {
		return this.green;
	}

	public String getRGB() {
		return "rgb{" + this.red + "," + this.green + "," + this.blue + "}";

	}
}


