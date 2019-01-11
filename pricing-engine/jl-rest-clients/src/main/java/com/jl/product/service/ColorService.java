package com.jl.product.service;

import java.awt.Color;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jl.product.vo.RGB;

@Service
public class ColorService {

	@Autowired
	Map<String, RGB> colorMap;
	
	private static final String COLOR_DEFAULT_HEX_VALUE ="000000";
	private static final String COLOR_HEX_PREFIX = "#";
	private static final int  COLOR_HEX_STRING = 0xffffff ;
	private static final int  COLOR_HEX_LIMIT_VALUE = 6 ;
	

	public String getRGBValueForColor(String colorName) {
		colorName = colorName.toLowerCase();
		if (StringUtils.isNotBlank(colorName) && colorMap.containsKey(colorName)) {
			RGB rgbColor = colorMap.get(colorName.toLowerCase());
			return rgbColor.getRGB();
		} else {
			return "rgb{not parsable color " + colorName + "}";
		}

	}

	public String getHexValueForColor(String colorName)  {
		
		if (StringUtils.isBlank(colorName)) {
			return "";
		}
		if (colorMap.containsKey(colorName.toLowerCase())) {

			RGB rgbColor = colorMap.get(colorName.toLowerCase());
			Color colour = new Color(rgbColor.getRed(), rgbColor.getGreen(), rgbColor.getBlue());

			String hexColour = Integer.toHexString(colour.getRGB() & COLOR_HEX_STRING);
			if (hexColour.length() < COLOR_HEX_LIMIT_VALUE) {
				hexColour = COLOR_DEFAULT_HEX_VALUE.substring(0, COLOR_HEX_LIMIT_VALUE - hexColour.length()) + hexColour;
			}

			return COLOR_HEX_PREFIX + hexColour;
		}
		return "hex{not parsable hex for color " + colorName + "}";
	}

}
