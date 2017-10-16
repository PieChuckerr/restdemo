package com.example.restdemo.web;


import ch.qos.logback.core.net.SyslogOutputStream;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.AssertionFailedError;
import  org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class StepDefinition {


    String contentType = "";
    String baseUri = "";
    String result="";
    int statusCode=0;

    @Autowired
    private MockMvc mockMvc;


    @When("^baseUri is (.*)$")
    public void baseUri(String uri) {

    }

   @When("^I set the numbers to (.*) and (.*)$")
    public void header(String pathParam1, String pathParam2) {
        this.setPathParam(pathParam1, pathParam2);
    }

    @When("I make get request")
    public void makeTheRequest() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(baseUri).accept(MediaType.APPLICATION_JSON);
        System.out.print(mockMvc == null);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        this.statusCode = mvcResult.getResponse().getStatus();
        this.contentType= mvcResult.getResponse().getContentType();
        this.result = mvcResult.getResponse().toString();
        System.out.println("result");
    }

    @Then("result should be (\\d+)")
    public void checkResult(int result){
        Assert.assertEquals(result, this.result);
    }

    @Then("status code should be (.*)")
    public void statusCodeCheck(String statusCode){
        Assert.assertEquals(statusCode, this.statusCode);
    }

    @Then("response data should in (.*)")
    public void generateResult(String headerVal){
        Assert.assertEquals(headerVal, this.contentType);
    }

    public void setPathParam(String pathParam1, String pathParam2) {
        Assert.assertNotNull(pathParam1);
        Assert.assertNotNull(pathParam2);

        try {
            Double.parseDouble(pathParam1);
            Double.parseDouble(pathParam2);
        }
        catch (Exception e) {
            Assert.fail("One of the value is not a number");
        }

        baseUri = baseUri+"/"+pathParam1+"/"+pathParam2;
    }
}