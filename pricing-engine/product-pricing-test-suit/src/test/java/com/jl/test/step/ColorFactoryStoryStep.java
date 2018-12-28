package com.jl.test.step;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import com.jl.factory.ColorFactory;

@Component
public class ColorFactoryStoryStep {
	
	ColorFactory factory = ColorFactory.getInstance();

	@Given("a Color factory exists")
	public void givenAColorFactoryExists() {
		factory.getInstance();
	}

	@When("a color name is feed to factory with name $colorName")
	public void whenAColorNameIsFeedToFactoryWithNamePurple(@Named("colorName") String colorName) {
		String hexValueforColor = factory.getInstance().getHexString(colorName);
		String rgbValueforColor = factory.getInstance().getRGBValueForColor(colorName);
		
		DataStore.cachedMap.put("hexValueforColor", hexValueforColor);
		DataStore.cachedMap.put("rgbValueforColor", rgbValueforColor);
	}

	@Then("a color hex value is returned by color factory")
	public void thenAColorHexValueIsReturnedByColorFactory() {
		String  hexValueforColor =  (String) DataStore.cachedMap.get("hexValueforColor");
		System.out.println(hexValueforColor);
		assertTrue(hexValueforColor != null); 
	}
	
	@Then("a color rgb value is returned by color factory")
	public void thenAColorRgbValueIsReturnedByColorFactory() {
		String rgbValueforColor = (String) DataStore.cachedMap.get("rgbValueforColor");
		System.out.println(rgbValueforColor);
		assertTrue(rgbValueforColor != null);
	}
}
