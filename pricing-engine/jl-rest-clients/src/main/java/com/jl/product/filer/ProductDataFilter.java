package com.jl.product.filer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jl.product.vo.NowPriceRangeVO;
import com.jl.product.vo.PriceVO;
import com.jl.product.vo.ProductVO;

public class ProductDataFilter extends DataFilter<ProductVO> {

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

			boolean hasPriceReduced = wasHistoricPriceHigherThanPresent(productVO);
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
					break;
				}
				}
			}
		}
		doSorting(filteredListByCondition);
		return filteredListByCondition;

	}

	private void doSorting(List<ProductVO> filteredListByCondition) {

		switch (productSortBy) {
		case PRODUCT_ID_ASC: {
			Collections.sort(filteredListByCondition, new ProductComparator());
			break;
		}

		case PRODUCT_PRICE_REDUCTION_DESC: {
			Collections.sort(filteredListByCondition, new ProductSPriceComparator());
			break;
		}
		default: {
			Collections.sort(filteredListByCondition, new ProductComparator());
		}
		}
	}

	class ProductComparator implements Comparator<ProductVO> {
		public int compare(ProductVO o1, ProductVO o2) {

			if ((o1.getProductId()) == (o2.getProductId())) {
				return 0;
			} else if ((o1.getProductId()) < (o2.getProductId())) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	class ProductSPriceComparator implements Comparator<ProductVO> {
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

		Double wasPrice = productVO.getPrice().getWas();
		Double then1Price = productVO.getPrice().getThen1();
		Double then2Price = productVO.getPrice().getThen2();
		Object nowPrice = productVO.getPrice().getNow();
		String priceLabel = productVO.getPrice().getCurrency();

		StringBuilder showWasNow = new StringBuilder();
		showWasNow.append(" {");
		showWasNow.append("was=");
		showWasNow.append(wasPrice);
		showWasNow.append(priceLabel != null ? priceLabel : "");
		showWasNow.append(", ");
		showWasNow.append("now=");
		showWasNow.append(nowPrice);
		showWasNow.append("}");

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

		showWasThenNow.append("{");
		showWasThenNow.append("was=");
		showWasThenNow.append(wasPrice);
		showWasThenNow.append(priceLabel != null ? priceLabel : "");
		showWasThenNow.append(",");

		showWasThenNow.append("then1=");
		showWasThenNow.append(then1Price);
		showWasThenNow.append(priceLabel != null ? priceLabel : "");
		showWasThenNow.append(",");

		showWasThenNow.append("then2=");
		showWasThenNow.append(then2Price);
		showWasThenNow.append(priceLabel != null ? priceLabel : "");
		showWasThenNow.append(",");

		showWasThenNow.append("now=");
		showWasThenNow.append(nowPrice);
		showWasThenNow.append(priceLabel != null ? priceLabel : "");

		showWasThenNow.append("}");

		productVO.setNowPrice(showWasThenNow.toString());
		filteredListByCondition.add(productVO);
	}

	private void SHOW_PER_DISCOUNT(List<ProductVO> filteredListByCondition, ProductVO productVO) {
		Double wasPrice = productVO.getPrice().getWas();
		Double then1Price = productVO.getPrice().getThen1();
		Double then2Price = productVO.getPrice().getThen2();
		Object nowPrice = productVO.getPrice().getNow();
		String priceLabel = productVO.getPrice().getCurrency();
	}

	private boolean wasHistoricPriceHigherThanPresent(ProductVO product) {
		PriceVO price = product.getPrice();
		Double reducedPrice = 0.00;

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

}
