package com.jl.product.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jl.product.exception.InvalidProductException;
import com.jl.product.vo.ColorSwatchVO;
import com.jl.product.vo.PriceVO;
import com.jl.product.vo.ProductVO;
import com.jl.product.vo.json.Product;

@Service
public class ProductDataMapper extends BaseMapper {

	public List<ProductVO> process(List<Product> products) {

		List<ProductVO> productPVOsList = new ArrayList<ProductVO>();
		for (Product sourceProduct : products) {

			ProductVO targetProductVO;
			try {
				targetProductVO = copyProductAttributes(sourceProduct);
				ProductPriceMapper priceMapper = new ProductPriceMapper();
				PriceVO proiductPrice = priceMapper.process(sourceProduct.getPrice());
				targetProductVO.setPrice(proiductPrice);

				ProductColorSwatchesMapper mapper = new ProductColorSwatchesMapper();
				List<ColorSwatchVO> colorSwatchVOs = mapper.process(sourceProduct.getColorSwatches());
				targetProductVO.setColorSwatches(colorSwatchVOs);

				productPVOsList.add(targetProductVO);
				
			} catch (InvalidProductException e) {
				e.printStackTrace();
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
