package com.shopesimple.invManager.ThirdParty.Security;
import com.shopesimple.invManager.DTO.ValidTokenRequestDto;
import com.shopesimple.invManager.DTO.ValidateTokenResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class AuthClient {

    public ValidateTokenResponseDto valid(String token){
        ValidTokenRequestDto request = new ValidTokenRequestDto();
        request.setToken(token);
        String authServer = "http://localhost:8081/auth/validate";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ValidateTokenResponseDto> validateTokenResponseDto = restTemplate.postForEntity(
                authServer,
                request,
                ValidateTokenResponseDto.class
        );

    return validateTokenResponseDto.getBody();

    }

}
