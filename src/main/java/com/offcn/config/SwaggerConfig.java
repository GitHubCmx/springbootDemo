package com.offcn.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //开启在线文档
public class SwaggerConfig {

    //1 声明api  文档的属性 构建器
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("springboot使用在线文档构建restful风格")
                .description("中工就业").termsOfServiceUrl("www.baidu.com").contact("0708java").version("0.0.1")
                .build();
    }

    //2 配置核心配置信息
    private Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.offcn.controller"))
                .paths(PathSelectors.any()).build();
    }
}
