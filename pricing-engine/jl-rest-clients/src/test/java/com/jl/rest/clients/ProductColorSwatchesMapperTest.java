package com.jl.rest.clients;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.junit.Test;

import com.jl.factory.ColorFactory;
import com.jl.product.mapper.ProductColorSwatchesMapper;
import com.jl.product.vo.ColorSwatchVO;
import com.jl.product.vo.json.ColorSwatch;

public class ProductColorSwatchesMapperTest {

	ProductColorSwatchesMapper productColorSwatchesMapper = new ProductColorSwatchesMapper();

	public static final Hashtable<String, String> colorCache = new Hashtable<String, String>();

	@Test
	public void testColorSwatesCopy() {
		List<ColorSwatch> colorSwatches = new ArrayList<ColorSwatch>();

		ColorSwatch swatches = new ColorSwatch();
		swatches.setBasicColor("purple");
		colorSwatches.add(swatches);
		List<ColorSwatchVO> colorSwatchVOs = productColorSwatchesMapper.process(colorSwatches);
		for (ColorSwatchVO colorSwatchVO : colorSwatchVOs) {
			System.out.println(colorSwatchVO.toString());
			assertEquals("#800080", colorSwatchVO.getRgbColor().toString());
		}
		

	}
	
	@Test
	public void testValueProduction() {
		String rgbValue = ColorFactory.getInstance().getRGBValueForColor("purple");
		assertEquals("rgb{128,0,128}", rgbValue);
		String hexValue = ColorFactory.getInstance().getHexString("purple");
		assertEquals("#800080", hexValue);
	}
		
	

}
