package com.jl.test.step;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jl.product.service.ColorService;

@Component
public class ColorFactoryStoryStep {
	
	@Autowired
	ColorService colorService;

	@Given("a Color factory exists")
	public void givenAColorFactoryExists() {
		assertTrue(colorService != null); 
	}

	@When("a color name is feed to factory with name $colorName")
	public void whenAColorNameIsFeedToFactoryWithNamePurple(@Named("colorName") String colorName) {
		String hexValueforColor = colorService.getHexValueForColor(colorName);
		String rgbValueforColor = colorService.getRGBValueForColor(colorName);
		
		DataStoreSteps.cachedMap.put("hexValueforColor", hexValueforColor);
		DataStoreSteps.cachedMap.put("rgbValueforColor", rgbValueforColor);
	}

	@Then("a color hex value is returned by color factory")
	public void thenAColorHexValueIsReturnedByColorFactory() {
		String  hexValueforColor =  (String) DataStoreSteps.cachedMap.get("hexValueforColor");
		System.out.println(hexValueforColor);
		assertTrue(hexValueforColor != null); 
	}
	
	@Then("a color rgb value is returned by color factory")
	public void thenAColorRgbValueIsReturnedByColorFactory() {
		String rgbValueforColor = (String) DataStoreSteps.cachedMap.get("rgbValueforColor");
		System.out.println(rgbValueforColor);
		assertTrue(rgbValueforColor != null);
	}
}
