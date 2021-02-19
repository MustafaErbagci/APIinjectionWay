package com.pa.step_definitions;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class InjStep {
    private Response response;
    private ValidatableResponse validatableResponse;

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public void setRequestSpecification(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    private RequestSpecification requestSpecification;

    public void setResponse(Response response) {
        this.response = response;
    }

    public void setValidatableResponse(ValidatableResponse validatableResponse) {
        this.validatableResponse = validatableResponse;
    }

    public Response getResponse() {
        return response;
    }

    public ValidatableResponse getValidatableResponse() {
        return validatableResponse;
    }
}
