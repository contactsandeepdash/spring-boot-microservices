package com.dash.orderservice.external.errorDecoder;

import com.dash.orderservice.exception.CustomException;
import com.dash.orderservice.external.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        ObjectMapper objectMapper = new ObjectMapper();

        log.info("Request URL :: {}", response.request().url());
        log.info("Request URL headers :: {}", response.request().headers());

        try {
            ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
            return new CustomException(errorResponse.getErrorMessage(), errorResponse.getErrorCode(), response.status());

        } catch (IOException e) {
            throw new CustomException("Internal Server Error", "INTERNAL_SERVER_ERROR", 500);
        }
    }
}
