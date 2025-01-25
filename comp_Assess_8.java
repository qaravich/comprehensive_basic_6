package com.restAssuredPractice;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class comp_Assess_8 {

	@Test
	public void check_capital() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://restcountries.com/v3.1/capital/";
		// Get the RequestSpecification of the request to be sent to the server.
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get("tallinn");

		String responsevalue = response.asPrettyString();
		System.out.println(" responsevalue is " + responsevalue);

		JsonPath jp = response.jsonPath();
		// System.out.println(" JP is ---->"+jp);

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200, "Correct status code returned");

		String expectedcommonname = "Estonia";
		String actcommonname = (String) jp.getList("name.common").get(0);
		Assert.assertEquals(actcommonname, expectedcommonname, "expected commonname is returned");
		Assert.assertNotNull(actcommonname, "expected commonname is not null");

		String expectedofficialname = "Republic of Estonia";
		String actofficialname = (String) jp.getList("name.official").get(0);
		Assert.assertEquals(actofficialname, actofficialname, " expectedofficialname is returned");
		Assert.assertNotNull(actofficialname, "expectedofficialname is not null");

		String expectednavofficialname = "Eesti Vabariik";
		String actnatofficialname = (String) jp.getList("name.nativeName.est.official").get(0);
		Assert.assertEquals(actnatofficialname, expectednavofficialname, "expectednavofficialname is returned");
		Assert.assertNotNull(actnatofficialname, "expectednavofficialname is not null");

		String expectednavcommonname = "Eesti";
		String actnatcommonname = (String) jp.getList("name.nativeName.est.common").get(0);
		Assert.assertEquals(actnatcommonname, expectednavcommonname, "expectednavcommonname is returned");
		Assert.assertNotNull(actnatcommonname, "expectednavcommonname is not null");

		String expectedcurrencies = "Euro";
		String actcurrencies = (String) jp.getList("currencies.EUR.name").get(0);
		Assert.assertEquals(actcurrencies, expectedcurrencies, "expectedcurrencies is returned");
		Assert.assertNotNull(actcurrencies, "expectedcurrencies is not null");
		
		Currency cur1 = Currency.getInstance("EUR");
		String symbol = cur1.getSymbol();
	    //System.out.println("Currency symbol is = " + symbol); 

		String expectedcurrencysymbol = symbol;
		String actcurrencysymbol = (String) jp.getList("currencies.EUR.symbol").get(0);
		Assert.assertEquals(actcurrencysymbol, expectedcurrencysymbol, "expectedcurrencysymbol is returned");
		Assert.assertNotNull(actcurrencysymbol, "expectedcurrencysymbol is not null");

		String expectedcapital = "Tallinn";
		String actualcapital = (String) jp.getList("capital[0]").get(0);
		Assert.assertEquals(actualcapital, expectedcapital, "expectedcapital is returned");
		Assert.assertNotNull(actualcapital, "expectedcapital is not null");

		boolean expectedindependent = true;
		boolean actindependent = (boolean) jp.getList("independent").get(0);
		Assert.assertEquals(actindependent, expectedindependent, "expectedindependent is returned");
		Assert.assertNotNull(actindependent, "expectedindependent is not null");

		String expstatus = "officially-assigned";
		String actstatus = (String) jp.getList("status").get(0);
		Assert.assertEquals(actstatus, expstatus, "expstatus is returned");
		Assert.assertNotNull(actstatus, "expstatus is not null");

		boolean expunMember = true;
		boolean actunMember = (boolean) jp.getList("unMember").get(0);
		Assert.assertEquals(actunMember, expunMember, "expunMember is returned");
		Assert.assertNotNull(actunMember, "expunMember is not null");

		String expregion = "Europe";
		String actregion = (String) jp.getList("region").get(0);
		Assert.assertEquals(actregion, expregion, "expregion is returned");
		Assert.assertNotNull(actregion, "expregion is not null");

		String expsubregion = "Northern Europe";
		String actsubregion = (String) jp.getList("subregion").get(0);
		Assert.assertEquals(actsubregion, expsubregion, "expsubregion is returned");
		Assert.assertNotNull(actsubregion, "expsubregion is not null");

		String explanguages = "Estonian";
		String actlanguages = (String) jp.getList("languages.est").get(0);
		Assert.assertEquals(actlanguages, explanguages, "explanguages is returned");
		Assert.assertNotNull(actlanguages, "explanguages is not null");

		double exparea = 45227.0;
		double actarea = (float) jp.getList("area").get(0);
		Assert.assertEquals(actarea, exparea, "exparea is returned");
		Assert.assertNotNull(actarea, "exparea is not null");

		int exppopulation = 1331057;
		int actpopulation = (int) jp.getList("population").get(0);
		Assert.assertEquals(actpopulation, exppopulation, "exppopulation is returned");
		Assert.assertNotNull(actpopulation, "exppopulation is not null");

		String exptimezones = "UTC+02:00";
		String acttimezones = (String) jp.getList("timezones[0]").get(0);
		Assert.assertEquals(acttimezones, exptimezones, "exptimezones is returned");
		Assert.assertNotNull(acttimezones, "exptimezones is not null");

		String expcontinents = "Europe";
		String actcontinents = (String) jp.getList("continents[0]").get(0);
		Assert.assertEquals(actcontinents, expcontinents, "expcontinents is returned");
		Assert.assertNotNull(actcontinents, "expcontinents is not null");

		String expstartOfWeek = "monday";
		String actstartOfWeek = (String) jp.getList("startOfWeek").get(0);
		Assert.assertEquals(actstartOfWeek, expstartOfWeek, "expstartOfWeek is returned");
		Assert.assertNotNull(actstartOfWeek, "expstartOfWeek is not null");

	}
}