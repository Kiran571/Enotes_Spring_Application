package com.springboot.EnotesApp.Enotes.handler;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GenericResponse {

    public HttpStatus httpStatus;

    public String status;

    private String message;

    private Object data;

    public ResponseEntity<?> create() {
        Map<String, Object> mapped = new LinkedHashMap<>();
        mapped.put("status", status);
        mapped.put("message", message);

        if (!ObjectUtils.isEmpty(data)) {
            mapped.put("data", data);
        }

        return new ResponseEntity<>(mapped, httpStatus);

    }

}
