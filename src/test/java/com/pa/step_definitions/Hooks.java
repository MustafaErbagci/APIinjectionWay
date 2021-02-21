package com.pa.step_definitions;

import com.pa.utilityClasses.ConfigReader;
import io.cucumber.java.Before;

import static io.restassured.RestAssured.*;

public class Hooks {
    @Before
    public void setUp(){
        baseURI= ConfigReader.get("apiUrl");
    }

}
