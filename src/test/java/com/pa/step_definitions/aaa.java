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

    @Given("accept type is HTML")
    public void accept_type_is_HTML() {
        injStep.setRequestSpecification(given().accept(ContentType.HTML).and());
    }

    @Given("accept type is xml")
    public void accept_type_is_XML() {
        injStep.setRequestSpecification(given().accept(ContentType.XML).and());
    }


    @Then("I verify the Content Type is {string}")
    public void i_verify_the_Content_Type_is(String expectedContentType) {
        injStep.getValidatableResponse().assertThat().contentType(expectedContentType);

    }




}
