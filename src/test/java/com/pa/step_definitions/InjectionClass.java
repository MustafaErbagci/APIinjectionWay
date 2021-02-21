package com.pa.step_definitions;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class InjectionClass {
    private Response response;
    private ValidatableResponse validatableResponse;
    private RequestSpecification requestSpecification;
//    private ResponseSpecification responseSpecification;

//    Setters

    public void setResponse(Response response) {
        this.response = response;
    }

    public void setValidatableResponse(ValidatableResponse validatableResponse) {
        this.validatableResponse = validatableResponse;
    }

    public void setRequestSpecification(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    //    getters
    public Response getResponse() {
        return response;
    }

    public ValidatableResponse getValidatableResponse() {
        return validatableResponse;
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}