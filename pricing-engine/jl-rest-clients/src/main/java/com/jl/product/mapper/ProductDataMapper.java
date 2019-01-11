package com.jl.product.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jl.product.clients.rest.ProductCatalogueClient;
import com.jl.product.exception.InvalidProductException;
import com.jl.product.vo.ColorSwatchVO;
import com.jl.product.vo.PriceVO;
import com.jl.product.vo.ProductVO;
import com.jl.product.vo.json.Product;

@Service
public class ProductDataMapper extends BaseMapper {
	
	private static final Logger log = LoggerFactory.getLogger(ProductDataMapper.class);
	
	@Autowired ProductPriceMapper priceMapper ;
	@Autowired ProductColorSwatchesMapper mapper ;

	public List<ProductVO> process(List<Product> products) {

		List<ProductVO> productPVOsList = new ArrayList<ProductVO>();
		for (Product sourceProduct : products) {

			ProductVO targetProductVO;
			try {
				targetProductVO = copyProductAttributes(sourceProduct);
				PriceVO proiductPrice = priceMapper.process(sourceProduct.getPrice());
				targetProductVO.setPrice(proiductPrice);

				List<ColorSwatchVO> colorSwatchVOs = mapper.process(sourceProduct.getColorSwatches());
				targetProductVO.setColorSwatches(colorSwatchVOs);

				productPVOsList.add(targetProductVO);
				
			} catch (InvalidProductException e) {
				if (log.isDebugEnabled()) {
					log.debug("Required Fileds for Presentation missing at source!",e.getMessage());
				}
			}

		}
		return productPVOsList;

	}

	public ProductVO copyProductAttributes(Product sourceProduct) throws InvalidProductException {
		if(sourceProduct.getProductId() != null) {
		ProductVO targetProductPVO = new ProductVO();
		targetProductPVO.setProductId(Integer.parseInt(sourceProduct.getProductId()));
		targetProductPVO.setTitle(sourceProduct.getTitle());
		targetProductPVO.setDefaultSkuId(sourceProduct.getDefaultSkuId());
		return targetProductPVO;
		}else {
			throw new InvalidProductException();
		}
		
	}


	public Object processComplexType(Object t) {
	return null;
	}

}
