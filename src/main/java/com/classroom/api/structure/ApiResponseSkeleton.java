package com.classroom.api.structure;

import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;


public class ApiResponseSkeleton {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode status = mapper.createObjectNode();
    JsonNode data = mapper.createObjectNode();

    public void setSuccess(Boolean success) {
        ((ObjectNode) status).put("success", success);
    }
    public void setMessage(String message) {
        ((ObjectNode) status).put("message", message);
    }


    public void setHttpCode(HttpStatus httpCode) {
        ((ObjectNode) status).put("httpCode", String.valueOf(httpCode.value()));
    }

    public JsonNode getStatus() {
        return status;
    }

    public JsonNode getData() {
        return data;
    }

}
