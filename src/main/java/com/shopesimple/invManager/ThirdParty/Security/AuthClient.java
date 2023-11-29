package com.shopesimple.invManager.ThirdParty.Security;

import com.shopesimple.invManager.DTO.ProductListDto;
import org.springframework.web.client.RestTemplate;

public class AuthClient {
    private final RestTemplate restTemplate;

    public AuthClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public void valid(){
        String authServer = "http://localhost:8081/auth/validate";

        restTemplate.getForEntity(
                authServer,
                ProductListDto[].class
        );
    }

}
