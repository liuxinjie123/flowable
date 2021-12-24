package com.flowable.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: bpm-platform-server
 * @description:
 * @author: lishuai
 * @create: 2021-12-20 23:02
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {



    @Bean(value = "defaultApi2")
    public Docket defaultApi2(Environment environment) {
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev", "test");
        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        boolean b = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 配置开关
                .enable(b)
                //分组名称
                .groupName("flowable")
                .select()
                //这里指定Controller扫描包路径
//                .apis(RequestHandlerSelectors.basePackage("org.flowable"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("flowable demo")
                .description("flowable 接口文档")
                .termsOfServiceUrl("http://localhost:8080/")
                .version("1.0")
                .contact(new Contact("jack", "", ""))
                .build();
    }


}
