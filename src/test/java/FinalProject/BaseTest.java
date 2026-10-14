package FinalProject;

import TestRail.TestRequestDTO;
import com.codeborne.selenide.Selenide;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Base64;

import static io.restassured.RestAssured.given;


public class BaseTest {

    protected int testCaseId = 1;
    private static final String RUN_ID = "2";
    private static final String BASE_API_URL = "https://danit.testrail.io/index.php?/api/v2/";
    private static final String USER_EMAIL = "lolcore321@gmail.com";
    private static final String USER_PASSWORD = "Core321456@*";
    private static final String CREDENTIALS = Base64.getEncoder().encodeToString((USER_EMAIL + ":" + USER_PASSWORD).getBytes());

    @BeforeMethod
    public void driverUtil() {
        Selenide.open("https://prom.ua/ua/");
    }

    @AfterMethod
    public void publishTestResultsToTestRail(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.SUCCESS) {
            publishResult(1, testCaseId);
        } else {
            publishResult(5, testCaseId);
        }
    }

    private void publishResult(int statusId, int testCaseId) {
        given()
                .header("Authorization", "Basic " + CREDENTIALS)
                .contentType("application/json")
                .body(new TestRequestDTO(statusId))
                .post(BASE_API_URL + String.format("add_result_for_case/%s/%s", RUN_ID, testCaseId));
    }
}