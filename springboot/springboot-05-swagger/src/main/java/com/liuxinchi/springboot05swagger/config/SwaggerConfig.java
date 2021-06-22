package com.liuxinchi.springboot05swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo()).
                select().
                //过滤接口
                apis(RequestHandlerSelectors.basePackage("com.liuxinchi.springboot05swagger.controller")).
                //过滤链接
                paths(PathSelectors.ant("/root")).
                build();
    }

    public ApiInfo apiInfo(){
        Contact contact = new Contact("柳鑫驰","http://localhost","pickices@qq.com");
        return new ApiInfo(
                "Swagger Test",
                "拾荒老冰棍学习swagger",
                "v1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }
}
