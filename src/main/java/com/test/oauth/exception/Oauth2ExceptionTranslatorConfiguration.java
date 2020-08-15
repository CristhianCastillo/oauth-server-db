package com.test.oauth.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

import java.time.LocalDateTime;

@Configuration
public class Oauth2ExceptionTranslatorConfiguration {

    private static final Logger LOGGER = LogManager.getLogger(Oauth2ExceptionTranslatorConfiguration.class);

    @Bean
    public WebResponseExceptionTranslator oauth2ResponseExceptionTranslator() {
        return new DefaultWebResponseExceptionTranslator() {

            @Override
            public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {

                ResponseEntity<OAuth2Exception> responseEntity = super.translate(e);
                OAuth2Exception body = responseEntity.getBody();
                HttpStatus statusCode = responseEntity.getStatusCode();

                LOGGER.info("-------------------------------------------------");
                LOGGER.info("timestamp: {}", LocalDateTime.now().toString());
                LOGGER.info("status: {}", body.getHttpErrorCode());
                LOGGER.info("message: {}", body.getMessage());
                LOGGER.info("code: {}", body.getOAuth2ErrorCode().toUpperCase());

                body.addAdditionalInformation("timestamp", LocalDateTime.now().toString());
                body.addAdditionalInformation("status", body.getHttpErrorCode() + "");
//                body.addAdditionalInformation("message", body.getMessage()); // We can not show this to final user.
                body.addAdditionalInformation("message", "User or password are not correct.");
                body.addAdditionalInformation("code", body.getOAuth2ErrorCode().toUpperCase());

                HttpHeaders headers = new HttpHeaders();
                headers.setAll(responseEntity.getHeaders().toSingleValueMap());
                // do something with header or response
                return new ResponseEntity<>(body, headers, statusCode);
            }
        };
    }
}
