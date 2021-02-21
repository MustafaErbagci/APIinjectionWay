package com.pa.step_definitions;

import com.pa.utilityClasses.ApiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertTrue;

public class AnotherSteps {

    InjectionClass injStep;

    public AnotherSteps(InjectionClass injStep1){
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

    @When("I send a GET request to Location web service for {string} and the date of {string}")
    public void i_send_a_GET_request_to_Location_web_service_for_and_the_date_of(String city, String date) {
        injStep.setValidatableResponse(ApiUtils.getRequestToLocationWebService(city,date));
    }

    @When("I verify the {string} is correct")
    public void i_verify_the_is_correct(String memberName) {
        injStep.getValidatableResponse().assertThat()
                .body("location_type[0]",equalToIgnoringCase(memberName));

    }

    @When("I verify if the payload has those items")
    public void i_verify_if_the_payload_has_those_items(List<String> expectedMembers) {
        Map<String,Object> actualMembers = injStep.getValidatableResponse().extract().response().path("[0]");


        assertTrue(actualMembers.keySet().containsAll(expectedMembers));

    }




}
