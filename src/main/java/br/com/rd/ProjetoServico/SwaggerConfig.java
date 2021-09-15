package br.com.rd.ProjetoServico;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//https://github.com/springfox/springfox#migrating-from-earlier-snapshot - Configurando o Swagger
import java.util.ArrayList;

@Configuration
public class SwaggerConfig {
    //http://localhost:8080/swagger-resources/
    //http://localhost:8080/swagger-resources/configuration/ui
    //http://localhost:8080/swagger-ui/index.html
    @Bean
    public Docket apiConfigDocs(){
        return new Docket(DocumentationType.SWAGGER_2) //tipo de documentação
                            .select()
                            .apis(RequestHandlerSelectors.basePackage("br.com.rd.ProjetoServico.Controller")) //método de pesquisa (o pacote onde estão os api)
//                            .apis(RequestHandlerSelectors.any())
                            .paths(PathSelectors.any())
                            .build()
                            .apiInfo(infoDocs())
                ;
    }

    private ApiInfo infoDocs(){
        //return new ApiInfo("First Service Project API", "Service Project", "1.0", "Terms", new Contact("Raphael", "www.rd.com","rgandrade@rd.com.br"), "RD", "www.rd.com.br", new ArrayList<VendorExtension>());
        return new ApiInfo("First Service Project API", "Service Project", "1.0",
                "Terms",
                new Contact("Raphael", null,"rgandrade@rd.com.br"), null, null,
                new ArrayList<VendorExtension>());
    }
}
