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

	public String getRGB() {
		return "rgb{" + this.red + "," + this.blue + "," + this.green + "}";

	}
}


