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
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class PetshopruTests extends TestBase {
    @Test
    @Description("Open https://www.petshop.ru/ and verify the title")
    @DisplayName("Main page title should be correct")
    void titleMainPageCheckTest() {
        step("open https://www.petshop.ru/", () -> {
            open("https://www.petshop.ru/");
        });

        step("check the title is 'Товары для животных, зоотовары онлайн, корма для домашних животных купить в интернет-магазине Petshop.ru'", () -> {
            String expectedTitle = "Товары для животных, зоотовары онлайн, корма для домашних животных купить в интернет-магазине Petshop.ru";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Checking the console logs for severe errors")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.petshop.ru/'", () ->
                open("https://www.petshop.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Description("Open https://www.petshop.ru/about/ and verify the title")
    @DisplayName("About page title should be correct")
    void titleAboutPageCheckTest() {
        step("Open url 'https://www.petshop.ru/about/'", () ->
                open("https://www.petshop.ru/about/"));

        step("check the title is 'О компании - информация об интернет-магазине и сети зоомагазинов Petshop'", () -> {
            Selenide.webdriver().shouldHave(WebDriverConditions.title("О компании - информация об интернет-магазине и сети зоомагазинов Petshop"));
        });
    }

    @Test
    @Description("Check that a cart can be opened")
    @DisplayName("Cart should be openable")
    void cartOpenTest() {
        step("Open url 'https://www.petshop.ru/'", () ->
                open("https://www.petshop.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            $("[data-testid='CartCounter_empty']").click();
            $("[data-testid='FullCart__header']").shouldHave(text("Корзина"));
        });
    }

    @Test
    @Description("Check that you can open registration form")
    @DisplayName("Registration button should be clickable")
    void registrationOpenTest() {
        step("Open url 'https://www.petshop.ru/'", () ->
                open("https://www.petshop.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            $(".action-header-top__auth").click();
            $("[data-testid='DialogWindow__wrap']").shouldBe(visible);
        });
    }
}