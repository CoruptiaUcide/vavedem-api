package ro.vavedem.restapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by CoruptiaUcide
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ro.vavedem.restapi.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());


    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "VaVedem API",
                "Api to access romanian institutions public general available contact details.",
                "v0.0.1",
                "Terms of service",
                "email@coruptiaucide.ro",
                "GNU LESSER GENERAL PUBLIC LICENSE",
                "https://github.com/CoruptiaUcide/va-vedem-api/blob/master/LICENSE");
        return apiInfo;
    }
}
