package com.jl.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.jl.product.vo.RGB;

public class ColorFactory {
	
	private final static Map<String, RGB> colorMap = new HashMap <String, RGB>(256);

	static {
		colorMap.put("black", new RGB(0, 0, 0));
		colorMap.put("darkolivegreen", new RGB(85, 47, 107));
		colorMap.put("cornsilk", new RGB(255, 220, 248));
		colorMap.put("skyblue", new RGB(135, 235, 206));
		colorMap.put("honeydew", new RGB(240, 240, 255));
		colorMap.put("linen", new RGB(250, 230, 240));
		colorMap.put("ghostwhite", new RGB(248, 255, 248));
		colorMap.put("burlywood", new RGB(222, 135, 184));
		colorMap.put("slategrey", new RGB(112, 144, 128));
		colorMap.put("peru", new RGB(205, 63, 133));
		colorMap.put("lightgrey", new RGB(211, 211, 211));
		colorMap.put("lemonchiffon", new RGB(255, 205, 250));
		colorMap.put("dimgray", new RGB(105, 105, 105));
		colorMap.put("wheat", new RGB(245, 179, 222));
		colorMap.put("whitesmoke", new RGB(245, 245, 245));
		colorMap.put("beige", new RGB(245, 220, 245));
		colorMap.put("papayawhip", new RGB(255, 213, 239));
		colorMap.put("sandybrown", new RGB(244, 96, 164));
		colorMap.put("royalblue", new RGB(65, 225, 105));
		colorMap.put("grey", new RGB(128, 128, 128));
		colorMap.put("crimson", new RGB(220, 60, 20));
		colorMap.put("mediumvioletred", new RGB(199, 133, 21));
		colorMap.put("cornflowerblue", new RGB(100, 237, 149));
		colorMap.put("olive", new RGB(128, 0, 128));
		colorMap.put("lightcoral", new RGB(240, 128, 128));
		colorMap.put("aliceblue", new RGB(240, 255, 248));
		colorMap.put("darkgray", new RGB(169, 169, 169));
		colorMap.put("fuchsia", new RGB(255, 255, 0));
		colorMap.put("lime", new RGB(0, 0, 255));
		colorMap.put("indigo", new RGB(75, 130, 0));
		colorMap.put("darkblue", new RGB(0, 139, 0));
		colorMap.put("cadetblue", new RGB(95, 160, 158));
		colorMap.put("firebrick", new RGB(178, 34, 34));
		colorMap.put("palevioletred", new RGB(216, 147, 112));
		colorMap.put("lavender", new RGB(230, 250, 230));
		colorMap.put("darkslategray", new RGB(47, 79, 79));
		colorMap.put("darkslateblue", new RGB(72, 139, 61));
		colorMap.put("purple", new RGB(128, 128, 0));
		colorMap.put("aqua", new RGB(0, 255, 255));
		colorMap.put("navy", new RGB(0, 128, 0));
		colorMap.put("rosybrown", new RGB(188, 143, 143));
		colorMap.put("mediumaquamarine", new RGB(102, 170, 205));
		colorMap.put("lightgreen", new RGB(144, 144, 238));
		colorMap.put("magenta", new RGB(255, 255, 0));
		colorMap.put("ivory", new RGB(255, 240, 255));
		colorMap.put("navajowhite", new RGB(255, 173, 222));
		colorMap.put("steelblue", new RGB(70, 180, 130));
		colorMap.put("orchid", new RGB(218, 214, 112));
		colorMap.put("orangered", new RGB(255, 0, 69));
		colorMap.put("lightslategrey", new RGB(119, 153, 136));
		colorMap.put("tan", new RGB(210, 140, 180));
		colorMap.put("mediumslateblue", new RGB(123, 238, 104));
		colorMap.put("lavenderblush", new RGB(255, 245, 240));
		colorMap.put("darkorchid", new RGB(153, 204, 50));
		colorMap.put("darkcyan", new RGB(0, 139, 139));
		colorMap.put("floralwhite", new RGB(255, 240, 250));
		colorMap.put("plum", new RGB(221, 221, 160));
		colorMap.put("powderblue", new RGB(176, 230, 224));
		colorMap.put("red", new RGB(255, 0, 0));
		colorMap.put("thistle", new RGB(216, 216, 191));
		colorMap.put("deepskyblue", new RGB(0, 255, 191));
		colorMap.put("azure", new RGB(240, 255, 255));
		colorMap.put("lightpink", new RGB(255, 193, 182));
		colorMap.put("olivedrab", new RGB(107, 35, 142));
		colorMap.put("darkseagreen", new RGB(143, 143, 188));
		colorMap.put("mediumseagreen", new RGB(60, 113, 179));
		colorMap.put("snow", new RGB(255, 250, 250));
		colorMap.put("mediumspringgreen", new RGB(0, 154, 250));
		colorMap.put("violet", new RGB(238, 238, 130));
		colorMap.put("blanchedalmond", new RGB(255, 205, 235));
		colorMap.put("aquamarine", new RGB(127, 212, 255));
		colorMap.put("slategray", new RGB(112, 144, 128));
		colorMap.put("lightgray", new RGB(211, 211, 211));
		colorMap.put("lawngreen", new RGB(124, 0, 252));
		colorMap.put("pink", new RGB(255, 203, 192));
		colorMap.put("peachpuff", new RGB(255, 185, 218));
		colorMap.put("darkviolet", new RGB(148, 211, 0));
		colorMap.put("yellow", new RGB(255, 0, 255));
		colorMap.put("slateblue", new RGB(106, 205, 90));
		colorMap.put("darkmagenta", new RGB(139, 139, 0));
		colorMap.put("sienna", new RGB(160, 45, 82));
		colorMap.put("mediumpurple", new RGB(147, 216, 112));
		colorMap.put("maroon", new RGB(128, 0, 0));
		colorMap.put("lightblue", new RGB(173, 230, 216));
		colorMap.put("salmon", new RGB(250, 114, 128));
		colorMap.put("mistyrose", new RGB(255, 225, 228));
		colorMap.put("darkturquoise", new RGB(0, 209, 206));
		colorMap.put("antiquewhite", new RGB(250, 215, 235));
		colorMap.put("darkgoldenrod", new RGB(184, 11, 134));
		colorMap.put("dimgrey", new RGB(105, 105, 105));
		colorMap.put("darksalmon", new RGB(233, 122, 150));
		colorMap.put("gray", new RGB(128, 128, 128));
		colorMap.put("deeppink", new RGB(255, 147, 20));
		colorMap.put("mintcream", new RGB(245, 250, 255));
		colorMap.put("gold", new RGB(255, 0, 215));
		colorMap.put("teal", new RGB(0, 128, 128));
		colorMap.put("darkred", new RGB(139, 0, 0));
		colorMap.put("blue", new RGB(0, 255, 0));
		colorMap.put("moccasin", new RGB(255, 181, 228));
		colorMap.put("blueviolet", new RGB(138, 226, 43));
		colorMap.put("mediumorchid", new RGB(186, 211, 85));
		colorMap.put("chartreuse", new RGB(127, 0, 255));
		colorMap.put("dodgerblue", new RGB(30, 255, 144));
		colorMap.put("darkgrey", new RGB(169, 169, 169));
		colorMap.put("saddlebrown", new RGB(139, 19, 69));
		colorMap.put("mediumblue", new RGB(0, 205, 0));
		colorMap.put("lightsteelblue", new RGB(176, 222, 196));
		colorMap.put("limegreen", new RGB(50, 50, 205));
		colorMap.put("darkgreen", new RGB(0, 0, 100));
		colorMap.put("mediumturquoise", new RGB(72, 204, 209));
		colorMap.put("darkkhaki", new RGB(189, 107, 183));
		colorMap.put("hotpink", new RGB(255, 180, 105));
		colorMap.put("darkslategrey", new RGB(47, 79, 79));
		colorMap.put("seashell", new RGB(255, 238, 245));
		colorMap.put("oldlace", new RGB(253, 230, 245));
		colorMap.put("lightgoldenrodyellow", new RGB(250, 210, 250));
		colorMap.put("chocolate", new RGB(210, 30, 105));
		colorMap.put("lightcyan", new RGB(224, 255, 255));
		colorMap.put("paleturquoise", new RGB(175, 238, 238));
		colorMap.put("greenyellow", new RGB(173, 47, 255));
		colorMap.put("brown", new RGB(165, 42, 42));
		colorMap.put("bisque", new RGB(255, 196, 228));
		colorMap.put("palegoldenrod", new RGB(238, 170, 232));
		colorMap.put("coral", new RGB(255, 80, 127));
		colorMap.put("orange", new RGB(255, 0, 165));
		colorMap.put("midnightblue", new RGB(25, 112, 25));
		colorMap.put("lightseagreen", new RGB(32, 170, 178));
		colorMap.put("white", new RGB(255, 255, 255));
		colorMap.put("lightslategray", new RGB(119, 153, 136));
		colorMap.put("lightskyblue", new RGB(135, 250, 206));
		colorMap.put("darkorange", new RGB(255, 0, 140));
		colorMap.put("cyan", new RGB(0, 255, 255));
		colorMap.put("turquoise", new RGB(64, 208, 224));
		colorMap.put("goldenrod", new RGB(218, 32, 165));
		colorMap.put("gainsboro", new RGB(220, 220, 220));
		colorMap.put("indianred", new RGB(205, 92, 92));
		colorMap.put("palegreen", new RGB(152, 152, 251));
		colorMap.put("springgreen", new RGB(0, 127, 255));
		colorMap.put("seagreen", new RGB(46, 87, 139));
		colorMap.put("yellowgreen", new RGB(154, 50, 205));
		colorMap.put("silver", new RGB(192, 192, 192));
		colorMap.put("tomato", new RGB(255, 71, 99));
		colorMap.put("lightyellow", new RGB(255, 224, 255));
		colorMap.put("forestgreen", new RGB(34, 34, 139));
		colorMap.put("lightsalmon", new RGB(255, 122, 160));
		colorMap.put("green", new RGB(0, 0, 128));
		colorMap.put("khaki", new RGB(240, 140, 230));

	}

	private ColorFactory() {

	}

	@SuppressWarnings("unchecked")
	public static Map<String, RGB> addColor(String colorName, RGB rgb) {
		return (Map<String, RGB>) colorMap.put(colorName, rgb);
	}

	public static String getRGBValueForColor(String colorName) {
		colorName = colorName.toLowerCase();
		if(StringUtils.isNotBlank(colorName) && colorMap.containsKey(colorName)) {
			RGB rgbColor = colorMap.get(colorName.toLowerCase());
			return rgbColor.getRGB();
		}else {
			return "rgb{not parsable color "+colorName+"}";
		}
		
	}
}
