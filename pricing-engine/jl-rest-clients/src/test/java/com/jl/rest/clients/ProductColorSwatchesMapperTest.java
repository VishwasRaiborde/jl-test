package com.jl.rest.clients;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.junit.Test;

import com.jl.product.mapper.ProductColorSwatchesMapper;
import com.jl.product.vo.ColorSwatchVO;
import com.jl.product.vo.json.ColorSwatch;
import com.jl.utils.ColorFactory;

public class ProductColorSwatchesMapperTest {

	ProductColorSwatchesMapper productColorSwatchesMapper = new ProductColorSwatchesMapper();

	public static final Hashtable<String, String> colorCache = new Hashtable<String, String>();

	@Test
	public void testColorSwatesCopy() {
		List<ColorSwatch> colorSwatches = new ArrayList<ColorSwatch>();

		ColorSwatch swatches = new ColorSwatch();
		swatches.setBasicColor("Purple");
		colorSwatches.add(swatches);
		List<ColorSwatchVO> colorSwatchVOs = productColorSwatchesMapper.process(colorSwatches);
		for (ColorSwatchVO colorSwatchVO : colorSwatchVOs) {
			System.out.println(colorSwatchVO.toString());
		}

	}
	
	@Test
	public void testSet() {
		List<ColorSwatch> colorSwatches = new ArrayList<ColorSwatch>();
		ColorFactory.getRGBValueForColor("Prurple");

	}

}
