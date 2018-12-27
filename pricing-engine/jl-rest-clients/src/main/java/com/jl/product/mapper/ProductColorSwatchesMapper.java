package com.jl.product.mapper;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.jl.product.vo.ColorSwatchVO;
import com.jl.product.vo.json.ColorSwatch;
import com.jl.utils.ColorFactory;

@Service
public class ProductColorSwatchesMapper extends BaseMapper {

	public static final Hashtable<String, String> colorCache = new Hashtable<String, String>();

	public List<ColorSwatchVO> process(List<ColorSwatch> colorSwatchVOs) {
		List<ColorSwatchVO> colorSwatchVos = copyColorSwatchAttributes(colorSwatchVOs);
		return colorSwatchVos;
	}

	private List<ColorSwatchVO> copyColorSwatchAttributes(List<ColorSwatch> colorSwatches) {
		List<ColorSwatchVO> colorSwatchVOs = new ArrayList<ColorSwatchVO>();
		for (ColorSwatch colorSwatch : colorSwatches) {
			ColorSwatchVO colorSwatchVO = new ColorSwatchVO();
			BeanUtils.copyProperties(colorSwatch, colorSwatchVO);
			colorSwatchVO.setRgbColor(getRGBValueOfColor(colorSwatchVO.getBasicColor()));
			colorSwatchVOs.add(colorSwatchVO);
		}
		return colorSwatchVOs;
	}

	public String getRGBValueOfColor(String basicColorName) {
		
		return ColorFactory.getRGBValueForColor(basicColorName);
	}

	@Override
	public Object processComplexType(Object t) {
		return null;
	}

}
