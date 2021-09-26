package dev.informacoesubs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@Configuration
public class SpringFoxConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
				.withClassAnnotation(Api.class))
				.paths(PathSelectors.any())
				.build()
			.apiInfo(metaData());
	}

	@Bean
	UiConfiguration uiConfig() {
		return UiConfigurationBuilder
				.builder()
				.displayOperationId(false)
				.docExpansion(DocExpansion.LIST)
			.build();
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Pesquisa UBSs REST API")
				.description("\"Lista as UBSs próximas de uma determinada origem\"").version("1.0.0")
				.license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				.build();
	}
}