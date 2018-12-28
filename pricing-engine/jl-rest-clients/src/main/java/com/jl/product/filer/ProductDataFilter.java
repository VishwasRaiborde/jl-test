package com.jl.product.filer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.jl.product.vo.NowPriceRangeVO;
import com.jl.product.vo.PriceVO;
import com.jl.product.vo.ProductVO;

public class ProductDataFilter extends DataFilter<ProductVO> {

	private final static String OPENING_BRACES = " {";
	private final static String CLOSING_BRACES = "}";
	private final static String SPACE = " ";
	private final static String COMMA_SEPERATOR = ",";
	private final static String WAS_PRICE_LABEL = "was = ";
	private final static String NOW_PRICE_LABEL = "now = ";
	private final static String THEN_1_PRICE_LABEL = "then1 = ";
	private final static String THEN_2_PRICE_LABEL = "then2 = ";
	private final static String PER_DISCOUNT_LABEL = " % off - now ";

	public enum PriceLableType {
		SHOW_WAS_NOW, SHOW_WAS_THEN_NOW, SHOW_PER_DISCOUNT
	}

	public enum ProductSortBy {
		PRODUCT_ID_ASC, PRODUCT_PRICE_REDUCTION_DESC, PRODUCT_PRICE_REDUCTION_ASC
	}

	PriceLableType labelType;
	ProductSortBy productSortBy;
	List<ProductVO> productVOs;

	public ProductDataFilter(List<ProductVO> productVOs, PriceLableType labelType, ProductSortBy productSortBy) {
		this.productVOs = productVOs;
		this.labelType = labelType;
		this.productSortBy = productSortBy;
	}

	public ProductDataFilter() {
	}

	public Object filter() {

		List<ProductVO> filteredListByCondition = new ArrayList<ProductVO>();

		for (ProductVO productVO : productVOs) {

			boolean hasPriceReduced = hasPriceReduction(productVO);
			if (hasPriceReduced) {

				switch (labelType) {
				case SHOW_WAS_NOW: {
					decorateProductForPriceWithWasAndNowAttribute(filteredListByCondition, productVO);
					break;
				}
				case SHOW_WAS_THEN_NOW: {
					decorateProductForPriceWitWasThenAndNowAttribute(filteredListByCondition, productVO);
					break;
				}
				case SHOW_PER_DISCOUNT: {
					decorateProductForPriceDiscount(filteredListByCondition, productVO);
					break;
				}
				}
			}
		}
		doSorting(filteredListByCondition);
		return filteredListByCondition;

	}



	class ProductSPriceComparatorDESC implements Comparator<ProductVO> {
		public int compare(ProductVO o1, ProductVO o2) {

			if ((o1.getReducedPrice()) == (o2.getReducedPrice())) {
				return 0;
			} else if ((o1.getReducedPrice()) < (o2.getReducedPrice())) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	private void decorateProductForPriceWithWasAndNowAttribute(List<ProductVO> filteredListByCondition,
			ProductVO productVO) {

		// some smart way for null check , null check before use ,
		Double wasPrice = productVO.getPrice().getWas();
		Object nowPrice = productVO.getPrice().getNow();
		String priceLabel = productVO.getPrice().getCurrency();

		StringBuilder showWasNow = new StringBuilder();
		showWasNow.append(OPENING_BRACES);
		showWasNow.append(WAS_PRICE_LABEL);
		showWasNow.append(wasPrice);
		showWasNow.append(SPACE);
		showWasNow.append(priceLabel != null ? priceLabel : "");
		showWasNow.append(COMMA_SEPERATOR);
		showWasNow.append(NOW_PRICE_LABEL);
		showWasNow.append(nowPrice);
		showWasNow.append(SPACE);
		showWasNow.append(priceLabel != null ? priceLabel : "");
		showWasNow.append(CLOSING_BRACES);

		productVO.setNowPrice(showWasNow.toString());
		filteredListByCondition.add(productVO);
	}

	private void decorateProductForPriceWitWasThenAndNowAttribute(List<ProductVO> filteredListByCondition,
			ProductVO productVO) {

		Double wasPrice = productVO.getPrice().getWas();
		Double then1Price = productVO.getPrice().getThen1();
		Double then2Price = productVO.getPrice().getThen2();
		Object nowPrice = productVO.getPrice().getNow();
		String priceLabel = productVO.getPrice().getCurrency();

		StringBuilder showWasThenNow = new StringBuilder();

		showWasThenNow.append(OPENING_BRACES);
		showWasThenNow.append(WAS_PRICE_LABEL);
		showWasThenNow.append(wasPrice);
		showWasThenNow.append(SPACE);
		showWasThenNow.append(priceLabel != null ? priceLabel : "");
		showWasThenNow.append(COMMA_SEPERATOR);

		if (StringUtils.isNotBlank(then1Price.toString()) && (then1Price > 0)) {
			showWasThenNow.append(THEN_1_PRICE_LABEL);
			showWasThenNow.append(then1Price);
			showWasThenNow.append(SPACE);
			showWasThenNow.append(COMMA_SEPERATOR);
		}

		if (StringUtils.isNotBlank(then2Price.toString()) && (then2Price > 0)) {
			showWasThenNow.append(THEN_2_PRICE_LABEL);
			showWasThenNow.append(then2Price);
			showWasThenNow.append(SPACE);
			showWasThenNow.append(priceLabel != null ? priceLabel : "");
			showWasThenNow.append(COMMA_SEPERATOR);
		}

		showWasThenNow.append(NOW_PRICE_LABEL);
		showWasThenNow.append(nowPrice);
		showWasThenNow.append(SPACE);
		showWasThenNow.append(priceLabel != null ? priceLabel : "");

		showWasThenNow.append(CLOSING_BRACES);

		productVO.setNowPrice(showWasThenNow.toString());
		filteredListByCondition.add(productVO);
	}

	private void decorateProductForPriceDiscount(List<ProductVO> filteredListByCondition, ProductVO productVO) {
		
		if (productVO.getPrice() != null) {
			
			String priceLabel = productVO.getPrice().getCurrency();
			double discount = calculateDiscount(productVO.getPrice());

			StringBuilder showDiscount = new StringBuilder();
			showDiscount.append(discount);
			showDiscount.append(PER_DISCOUNT_LABEL);
			showDiscount.append(getNowPrice(productVO.getPrice()));
			showDiscount.append(SPACE);
			showDiscount.append(priceLabel != null ? priceLabel : "");
			
			productVO.setNowPrice(showDiscount.toString());
			filteredListByCondition.add(productVO);
		}
	}

	private double calculateDiscount(PriceVO price) {
		double reduction = price.getWas() - getNowPrice(price);
		return (reduction / price.getWas()) * 100;

	}

	private double getNowPrice(PriceVO price) {

		if (price.getNow() instanceof NowPriceRangeVO) {
			return ((NowPriceRangeVO) price.getNow()).getTo();
		} else {
			return Double.parseDouble(price.getNow().toString());
		}
	}

	private boolean hasPriceReduction(ProductVO product) {
		PriceVO price = product.getPrice();
		Double reducedPrice;

		boolean hasPriceReduction = false;

		if (price.getWas() == 0.0 && price.getThen2() == 0.0 && price.getThen1() == 0.0 && price.getNow() != null) {
			reducedPrice = 0.00;
			product.setReducedPrice(reducedPrice);
			return false;

		} else if (price.getNow() instanceof NowPriceRangeVO) {
			double toPrice = ((NowPriceRangeVO) price.getNow()).getTo();
			double wasPrice = price.getWas();
			reducedPrice = wasPrice - toPrice;
			price.setReducedPrice(reducedPrice);
			product.setReducedPrice(reducedPrice);
			hasPriceReduction = true;

		} else {
			double toPrice = Double.parseDouble(price.getNow().toString());
			double wasPrice = price.getWas();
			reducedPrice = wasPrice - toPrice;
			price.setReducedPrice(reducedPrice);
			product.setReducedPrice(reducedPrice);
			hasPriceReduction = true;
		}
		return hasPriceReduction;
	}
	
	
	private void doSorting(List<ProductVO> filteredListByCondition) {

		switch (productSortBy) {
		case PRODUCT_ID_ASC: {
			Collections.sort(filteredListByCondition, new ProductComparator());
			break;
		}
		case PRODUCT_PRICE_REDUCTION_ASC: {
			Collections.sort(filteredListByCondition, new ProductSPriceComparatorASC());
			break;
		}
		case PRODUCT_PRICE_REDUCTION_DESC: {
			Collections.sort(filteredListByCondition, new ProductSPriceComparatorDESC());
			break;
		}
		default: {
			Collections.sort(filteredListByCondition, new ProductComparator());
			break;
		}

		}
	}

	class ProductComparator implements Comparator<ProductVO> {
		public int compare(ProductVO o1, ProductVO o2) {

			if ((o1.getProductId()) == (o2.getProductId())) {
				return 0;
			} else if ((o1.getProductId()) < (o2.getProductId())) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	class ProductSPriceComparatorASC implements Comparator<ProductVO> {
		public int compare(ProductVO o1, ProductVO o2) {

			if ((o1.getReducedPrice()) == (o2.getReducedPrice())) {
				return 0;
			} else if ((o1.getReducedPrice()) < (o2.getReducedPrice())) {
				return -1;
			} else {
				return 1;
			}
		}
	}

}
