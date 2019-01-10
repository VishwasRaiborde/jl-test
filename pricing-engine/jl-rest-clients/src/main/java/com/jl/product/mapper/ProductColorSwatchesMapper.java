package com.jl.product.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jl.product.service.ColorService;
import com.jl.product.vo.ColorSwatchVO;
import com.jl.product.vo.json.ColorSwatch;

@Service
public class ProductColorSwatchesMapper extends BaseMapper {

	@Autowired
	ColorService colorService ;
	
	public List<ColorSwatchVO> process(List<ColorSwatch> colorSwatchVOs) {
		return copyColorSwatchAttributes(colorSwatchVOs);
	}

	private List<ColorSwatchVO> copyColorSwatchAttributes(List<ColorSwatch> colorSwatches) {
		List<ColorSwatchVO> colorSwatchVOs = new ArrayList<ColorSwatchVO>();
		for (ColorSwatch colorSwatch : colorSwatches) {
			ColorSwatchVO colorSwatchVO = new ColorSwatchVO();
			colorSwatchVO.setColor(colorSwatch.getColor());
			colorSwatchVO.setBasicColor(colorSwatch.getBasicColor());
			colorSwatchVO.setRgbColor(getHexValueOfColor(colorSwatchVO.getBasicColor()));
			colorSwatchVOs.add(colorSwatchVO);
		}
		return colorSwatchVOs;
	}

	public String getRGBValueOfColor(String basicColorName) {
		return 	colorService.getRGBValueForColor(basicColorName);
	}
	public String getHexValueOfColor(String basicColorName) {
		return 	colorService.getHexValueForColor(basicColorName);
	}

	@Override
	public Object processComplexType(Object t) {
		return null;
	}

}
