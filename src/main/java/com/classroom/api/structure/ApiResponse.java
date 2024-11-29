package com.classroom.api.structure;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;

import org.json.JSONArray;
import org.json.JSONObject;
/*import org.json.JSONArray;
import org.json.JSONObject;*/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ApiResponse<T> extends ApiResponseSkeleton {
    ObjectMapper mapper = new ObjectMapper();
    HttpStatus httpStatus;

    public ApiResponse(HttpStatus httpStatus, Boolean success, T data, String message) throws JsonProcessingException {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        setHttpCode(httpStatus);
        setSuccess(success);
        setMessage(message);
        if (data instanceof String || data instanceof JSONArray|| data instanceof JSONObject) {
            try {
                setData(mapper.readTree(String.valueOf(data)));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } else
            setData(mapper.valueToTree(data));
        this.httpStatus = httpStatus;
    }

    public void setData(JsonNode data) {
        this.data = data;
    }

    public ResponseEntity<String> getResponse(T apiResponse) {
        try {
            mapper.writeValueAsString(apiResponse);
            return new ResponseEntity<String>(mapper.writeValueAsString(apiResponse), httpStatus);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
