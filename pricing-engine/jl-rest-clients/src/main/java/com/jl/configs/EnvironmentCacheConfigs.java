package com.jl.configs;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jl.app.cache.AppCache;
import com.jl.product.vo.RGB;

/**
 * @author vr41198
 * 
 *
 */
@Configuration
public class EnvironmentCacheConfigs {

	@Bean
	public Map<String,String> envProperties() {
		AppCache.loadEnvProps();
		return AppCache.envPropertyMap;
	}
	
	@Bean
	public Map<String,RGB> colorMap() {
		AppCache.loadColorCache();
		return AppCache.colorMap;
	}

}
