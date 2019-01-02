package com.jl.product.pojo.builders;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;

import com.sun.codemodel.JCodeModel;



/**
 * generate POJO files from a given json file    
 * */
public class ProductCataloguePOJOBuilder {
	/**
	 * @param args
	 */
	
	private static final String PACKAGE_NAME = "com.jl.product.catalogue.generated.vo";
	private static final String JSON_EXTENSION = ".json";
	private static final String JSON_FILE_PATH = "/jsonfeed/productCatalogueJSON.json";
	private static final String OUTPUT_DIR = "src/main/java";
	

	public void convert2JSON(URL inputJson, File outputPojoDirectory, String packageName, String className)
			throws IOException {
		JCodeModel codeModel = new JCodeModel();
		URL source = inputJson;
		GenerationConfig config = new DefaultGenerationConfig() {
			@Override
			public boolean isGenerateBuilders() {
				return true;
			}
			public SourceType getSourceType() {
				return SourceType.JSON;
			}
		};
		SchemaMapper mapper = new SchemaMapper(	new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
		mapper.generate(codeModel, className, packageName, source);
		codeModel.build(outputPojoDirectory);
	}
	
	public static void main(String[] args) {
		File inputJson = new File("." + File.separator + JSON_FILE_PATH);
		File outputPojoDirectory = new File("." + File.separator + OUTPUT_DIR);
		outputPojoDirectory.mkdirs();
		try {
			new ProductCataloguePOJOBuilder().convert2JSON(inputJson.toURI().toURL(), outputPojoDirectory, PACKAGE_NAME,inputJson.getName().replace(JSON_EXTENSION, ""));
		} catch (IOException e) {
			//
		}
	}
}
