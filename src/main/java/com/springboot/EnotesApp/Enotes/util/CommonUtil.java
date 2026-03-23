package com.springboot.EnotesApp.Enotes.util;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springboot.EnotesApp.Enotes.handler.GenericResponse;

public class CommonUtil {

    public static ResponseEntity<?> createBuildResponse(Object data, HttpStatus httpStatus) {
        GenericResponse genericResponse = GenericResponse.builder()
                .httpStatus(httpStatus)
                .status("success")
                .message("Successfull")
                .data(data)
                .build();

        return genericResponse.create();
    }

    public static ResponseEntity<?> createBuildResponseMessagEntity(String message, HttpStatus httpStatus) {

        GenericResponse genericResponse = GenericResponse.builder()
                .message(message)
                .httpStatus(httpStatus)
                .status("success")
                .build();
        return genericResponse.create();

    }

    public static ResponseEntity<?> createErrorResponse(Object data, HttpStatus httpStatus) {

        GenericResponse genericResponse = GenericResponse.builder()
                .httpStatus(httpStatus)
                .status("failed")
                .message("Unsuccessfull")
                .data(data)
                .build();

        return genericResponse.create();
    }

    public static ResponseEntity<?> createErrorResponseMessageEntity(String message, HttpStatus httpStatus) {

        GenericResponse genericResponse = GenericResponse.builder()
                .message(message)
                .httpStatus(httpStatus)
                .status("failed")
                .build();
        return genericResponse.create();

    }

    public static String getContentFile(String originallFileName) {

        return null;
    }

}
