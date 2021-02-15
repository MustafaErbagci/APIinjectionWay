package com.pa.utilityClasses;

import io.cucumber.java.af.En;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class ApiUtils {


    private static String locationEndPoint="/location/{woeid}/";
    private static String locationSearchEndPoint="/location/search/";

    public static int getWoeidNumber(String city){

        Response response=given().accept(ContentType.JSON).
                        and().queryParam("query",city).when().get(locationSearchEndPoint);
        return response.jsonPath().getInt("woeid[0]");
    }

    public static String getLattLong(String city){

        Response response=given().accept(ContentType.JSON).
                and().queryParam("query",city).when().get(locationSearchEndPoint);
        return response.jsonPath().getString("latt_long[0]");
    }


    public static ValidatableResponse getRequestToLocationSearch(String city){
        ValidatableResponse validatableResponse = given().accept(ContentType.JSON)
                .and().queryParam("query", city)
                .when().get(locationSearchEndPoint).then();

        return validatableResponse;
    }

    public static ValidatableResponse getRequestToLocationSearchWithLatLong(String latLong){
        ValidatableResponse validatableResponse = given().accept(ContentType.JSON)
                .and().queryParam("lattlong", latLong)
                .when().get(locationSearchEndPoint).then();

        return validatableResponse;
    }




    public static RequestSpecification getReadyRequestBody(String city){
        RequestSpecification requestSpecification = given().accept(ContentType.JSON)
                .and().queryParam("query", city);
        return requestSpecification;
    }

    public static Response postRequestToLocationSearch(String city){

        return given().accept(ContentType.JSON)
                .and().queryParam("query", city).when().post(locationSearchEndPoint);
    }
    public static Response putRequestToLocationSearch(String city){

        return given().accept(ContentType.JSON)
                .and().queryParam("query", city).when().put(locationSearchEndPoint);
    }

    public static Response patchRequestToLocationSearch(String city){
        return given().accept(ContentType.JSON)
                .and().queryParam("query", city).when().patch(locationSearchEndPoint);
    }

    public static Response deleteRequestToLocationSearch(String city){
        return given().accept(ContentType.JSON)
                .and().queryParam("query", city).when().delete(locationSearchEndPoint);
    }

    public static Response requestToLocationSearch(String requestType, String city){
        Response response = null;
        if (requestType.equalsIgnoreCase("post")){
             response= postRequestToLocationSearch(city);
        }else if (requestType.equalsIgnoreCase("put")){
             response= putRequestToLocationSearch(city);
        }else if (requestType.equalsIgnoreCase("patch")){
             response= patchRequestToLocationSearch(city);
        }else if (requestType.equalsIgnoreCase("delete")){
             response= deleteRequestToLocationSearch(city);
        }
        return response;
    }


//    --------------------------------------------------



    public static ValidatableResponse getRequestToLocationWebService(String city){

        ValidatableResponse validatableResponse = getRequestToLocationSearch(city);

        int cityWoeidID = validatableResponse.extract().response().jsonPath().getInt("woeid[0]");

        ValidatableResponse validatableGetResponseForLocation=  given().pathParam("woeid", cityWoeidID)
                .when().get("/location/{woeid}").then();

        return validatableGetResponseForLocation;
    }

    public static ValidatableResponse getRequestToLocationWebService(String city,String date){

        ValidatableResponse validatableResponse = getRequestToLocationSearch(city);

        Response response = validatableResponse.extract().response();
        int cityWoeidID = response.jsonPath().getInt("woeid[0]");

        ValidatableResponse validatableGetResponseForLocation=given().pathParam("woeid", cityWoeidID).get("/location/{woeid}".concat("/").concat(date)).then();

        return validatableGetResponseForLocation;
    }

    public static ValidatableResponse getRequestToLocationWebServiceWithWoeidNum(String woeidNum){

       ValidatableResponse validatableGetResponseForLocation=given().pathParam("woeid", woeidNum).get("/location/{woeid}".concat("/")).then();

        return validatableGetResponseForLocation;
    }



    public static Response postRequestToLocation(int cityWoiedID){
        return  given().accept(ContentType.JSON)
                    .and().pathParam("woeid",cityWoiedID)
                    .when().post(locationEndPoint);

    }
    public static Response putRequestToLocation(int cityWoiedID){
        return  given().accept(ContentType.JSON)
                .and().pathParam("woeid",cityWoiedID)
                .when().put(locationEndPoint);

    }
    public static Response patchRequestToLocation(int cityWoiedID){
        return  given().accept(ContentType.JSON)
                .and().pathParam("woeid",cityWoiedID)
                .when().patch(locationEndPoint);


    }
    public static Response deleteRequestToLocation(int cityWoiedID){
        return  given().accept(ContentType.JSON)
                .and().pathParam("woeid",cityWoiedID)
                .when().delete(locationEndPoint);

    }

    public static Response requestToLocationEndPoint(String requestType, int cityWoeidId){
        Response response = null;

        if (requestType.equalsIgnoreCase("post")){
            response= postRequestToLocation(cityWoeidId);

        }else if (requestType.equalsIgnoreCase("put")){
            response= putRequestToLocation(cityWoeidId);

        }else if (requestType.equalsIgnoreCase("patch")){
            response= patchRequestToLocation(cityWoeidId);

        }else if (requestType.equalsIgnoreCase("delete")){
            response= deleteRequestToLocation(cityWoeidId);
        }
        return response;
    }




}
