package com.jl.rest.clients;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jl.configs.RestClientApp;
import com.jl.product.mapper.ProductColorSwatchesMapper;
import com.jl.product.vo.ColorSwatchVO;
import com.jl.product.vo.json.ColorSwatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestClientApp.class)
public class ProductColorSwatchesMapperTest {

	/*@Autowired
	ColorService colorBean;*/

	@Autowired
	ProductColorSwatchesMapper productColorSwatchesMapper;

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

/*	@Test
	public void testValueProduction() {
		String rgbValue = colorBean.getRGBValueForColor("purple");
		assertEquals("rgb{128,0,128}", rgbValue);
		String hexValue = colorBean.getHexValueForColor("purple");
		assertEquals("#800080", hexValue);
	}*/

}
