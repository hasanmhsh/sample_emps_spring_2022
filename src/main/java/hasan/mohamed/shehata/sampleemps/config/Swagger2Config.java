package hasan.mohamed.shehata.sampleemps.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configures the default Swagger Documentation
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class Swagger2Config
{
    /**
     * Configures what to document using Swagger
     *
     * @return A Docket which is the primary interface for Swagger configuration
     */
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("hasan.mohamed.shehata.sampleemps"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo()
    {
        return new ApiInfoBuilder().title("Sample Employees Project")
                .description("A Project Used to Introduce Swagger Documentation")
                .contact(new Contact("Hasan" ,
                        "http://www.hasan.local" ,
                        "hasan.mohamed.sh@gmail.com"))
                .license("MIT")
                .licenseUrl("https://github.com/hasanmhsh/translatorapi")
                .version("1.0.0")
                .build();
    }
}