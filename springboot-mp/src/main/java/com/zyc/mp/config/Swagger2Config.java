package com.zyc.mp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @author yachao.zhang
 * @description // swagger配置
 * @createTime  2021/1/2 16:31
 **/

@Configuration
@EnableSwagger2WebMvc
public class Swagger2Config {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("MP RESTful APIs")
                        .description("# MP swagger-bootstrap-ui RESTful APIs")
                        .termsOfServiceUrl("http://www.zyc.com/")
                        .contact("zycsmart@qq.com")
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("1.0")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.zyc.mp.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

}
