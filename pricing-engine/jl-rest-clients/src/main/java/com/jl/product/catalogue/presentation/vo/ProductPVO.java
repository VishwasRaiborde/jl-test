package com.jl.product.catalogue.presentation.vo;

public class ProductPVO {
	

		/*productId <String>
		title <String>
		colorSwatches. Each element should contain:
			color<String>
			rgbColor<String> which is an RGB  representation of the basicColor in a six digit hexadecimal format, e.g. “F0A1C2”.
		skuid<String>
		nowPrice<String> which is the price.now represented as a string, including the currency, e.g. “£1.75”. For values that are integer, 
		if they are less £10 return a decimal price, otherwise show an integer price, e.g. “£2.00” or  “£10”. 
		priceLabel<String>. An optional query parm called labelType can be set to any of:
		1.	ShowWasNow - in which case return a string saying “Was £x.xx, now £y.yyy”. 
		2.	ShowWasThenNow - in which case return a string saying “Was £x.xx, then £y.yy, now £z.zzz”. If the original price.then2 is not empty use that for the “then” price otherwise use the then1 price. If the then1 price is also empty then don’t show the “then” price.
		3.	ShowPercDscount  - in which case return “x% off - now £y.yy”.
		If the query parm is not set default to use ShowWasNow format.
		In all cases use the price formatting as described for nowPrice.
		
		
*/
	
	private String productId;
	private String title;
	private ColorSwatches colorSwatches; 
	private String 
	private String 
	private String 
	private String 

}
