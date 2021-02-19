package com.pa.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class aaa {

    InjStep injStep;

    public aaa(InjStep injStep1){
        this.injStep=injStep1;
    }




}
