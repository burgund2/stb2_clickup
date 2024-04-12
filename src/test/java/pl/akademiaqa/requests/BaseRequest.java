package pl.akademiaqa.requests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import pl.akademiaqa.properties.ClickUpProperties;
import pl.akademiaqa.url.ClickUpUrl;

public class BaseRequest {
    private static RequestSpecBuilder requestBuilder;

    public static RequestSpecification requestSpec() {
        requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri(ClickUpUrl.getBaseUrl());
        requestBuilder.setContentType("application/json");
        requestBuilder.addHeader("Authorization", ClickUpProperties.getToken());
        requestBuilder.addFilter(new AllureRestAssured());

        return requestBuilder.build();
    }

    public static RequestSpecification requestSpecWithLogs() {
        requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri(ClickUpUrl.getBaseUrl());
        requestBuilder.setContentType("application/json");
        requestBuilder.addHeader("Authorization", ClickUpProperties.getToken());
        requestBuilder.addFilter(new RequestLoggingFilter());
        requestBuilder.addFilter(new ResponseLoggingFilter());
        requestBuilder.addFilter(new AllureRestAssured());

        return requestBuilder.build();
    }
}
