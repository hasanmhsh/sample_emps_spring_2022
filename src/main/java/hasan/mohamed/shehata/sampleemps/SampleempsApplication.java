package hasan.mohamed.shehata.sampleemps;

import hasan.mohamed.shehata.sampleemps.models.YearFact;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@EnableJpaAuditing
@SpringBootApplication
public class SampleempsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleempsApplication.class, args);

        /*
         * Creates the object that is needed to do a client side Rest API call.
         * We are the client getting data from a remote API.
         */
//        RestTemplate restTemplate = new RestTemplate();
//
//        // we need to tell our RestTemplate what format to expect
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        // a couple of common formats
//        // converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_HTML));
//        // converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
//        // or we can accept all formats! Easiest but least secure
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
//        restTemplate.getMessageConverters().add(converter);
//
//        // create the url to access the API
//        String requestURL = "http://numbersapi.com/random/year?json";
//        // create the responseType expected. Notice the YearFact is the data type we are expecting back from the API!
//        ParameterizedTypeReference<YearFact> responseType = new ParameterizedTypeReference<>()
//        {
//        };
//        // create the response entity. do the get and get back information
//        ResponseEntity<YearFact> responseEntity = restTemplate.exchange(requestURL,
//                HttpMethod.GET,
//                null,
//                responseType);
//        // now that we have our data, let's print it to the console!
//        YearFact ourYearFact = responseEntity.getBody();
//        System.out.println(ourYearFact);

    }

}
