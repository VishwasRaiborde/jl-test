package com.jl.product.filer;

import java.util.ArrayList;
import java.util.List;

import com.jl.product.utils.PriceComputorUtils;
import com.jl.product.vo.ProductVO;

public class ProductDataFilter extends DataFilter<ProductVO> {

	public enum PriceLableType {
		ShowWasNow, ShowWasThenNow, ShowPercDscount
	}

	PriceLableType labelType;

	List<ProductVO> productVOs;

	public ProductDataFilter(List<ProductVO> productVOs, PriceLableType labelType) {
		this.productVOs = productVOs;
		this.labelType = labelType;
	}

	public Object filter() {

		List<ProductVO> filteredListByCondition = new ArrayList<ProductVO>();

		for (ProductVO productVO : productVOs) {

			boolean hasPriceReduced = PriceComputorUtils.calculatePriceDrop(productVO.getPrice());
			if (hasPriceReduced) {

				Double wasPrice = productVO.getPrice().getWas();
				Double then1Price = productVO.getPrice().getThen1();
				Double then2Price = productVO.getPrice().getThen2();
				Object nowPrice = productVO.getPrice().getNow();
				String priceLabel = productVO.getPrice().getCurrency();

				switch (labelType) {
				case ShowWasNow: {

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
					break;

				}
				case ShowWasThenNow: {

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
					break;
				}
				case ShowPercDscount: {
					filteredListByCondition.add(productVO);
					break;
				}
				}

			}

		}
		return filteredListByCondition;

	}

}
