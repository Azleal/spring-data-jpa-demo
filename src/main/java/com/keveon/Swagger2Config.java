package com.keveon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Keveon on 2017/2/23.
 * Swagger2 配置
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.keveon.rest"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring Data Jpa 常用功能演示项目中使用Swagger2展示RESTful APIs")
				.description("查看源码及更多内容请关注：https://github.com/keveon/spring-data-jpa-demo")
				.termsOfServiceUrl("https://github.com/keveon/spring-data-jpa-demo")
				.contact("Keveon")
				.version("1.0")
				.build();
	}
}