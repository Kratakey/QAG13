package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GoogleTests extends TestBase {
    @Test
    @Description("Open github.com and verify the title")
    @DisplayName("Main page title should be correct")
    void titleMainPageCheckTest() {
        step("open " + baseUrl, () -> {
            open(baseUrl);
        });

        step("check the title is 'GitHub: Where the world builds software · GitHub'", () -> {
            String expectedTitle = "GitHub: Where the world builds software · GitHub";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Checking the console logs for severe errors")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("open " + baseUrl, () -> {
            open(baseUrl);
        });

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Description("Click 'Sign up' button")
    @DisplayName("Sign up should be clickable")
    void signUpTest() {

        step("open " + baseUrl, () -> {
            open(baseUrl);
        });

        step("click 'Sign up'", () -> {
            $(byText("Sign up")).click();
        });

        step("verify that the register page is displayed", () -> {
            $("div[id='email-container']").shouldBe(visible);
        });
    }

    @Test
    @Description("Check that services could be opened")
    @DisplayName("Service menu should be visible")
    void openServicesMenu() {
        step("open " + baseUrl, () -> {
            open(baseUrl);
        });

        step("accept cookies", () -> {
            if ($("#gksS1d").isDisplayed()) {
                $("#gksS1d").click();
            }
        });

        step("Click on services", () -> {
            $("#gbwa").click();
        });

            step("Services should be visible", () -> {
            $("iframe").shouldBe(visible);
        });
    }

    @Test
    @Description("Check that you can open settings list")
    @DisplayName("Settings should be visible after the click")
    void registrationOpenTest() {
        step("open " + baseUrl, () -> {
            open(baseUrl);
        });

        step("accept cookies", () -> {
            if ($("#gksS1d").isDisplayed()) {
                $("#gksS1d").click();
            }
        });

        step("Click on settings", () -> {
            $("#Mses6b").click();
        });

        step("Settings should be visible", () -> {
            $("#dEjpnf").shouldBe(visible);
        });
    }
}