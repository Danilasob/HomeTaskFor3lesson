package Pages;

import Components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class RegistrationPage {
    public CalendarComponent calendarComponent = new CalendarComponent();

    //locators
    private SelenideElement HeaderTitleGlobal = $(".main-header"),
                            HeaderTitle = $(".practice-form-wrapper"),
                            firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            userEmailInput = $("#userEmail"),
                            userNumberInput = $("#userNumber"),
                            subjectsInput = $("#subjectsInput"),
                            selectPicture = $("#uploadPicture"),
                            currentAddressInput = $("#currentAddress"),
                            selectState = $("#react-select-3-input"),
                            selectCity = $("#react-select-4-input"),
                            Scroll = $("#submit"),
                            setButton = $("#submit"),
                            resultTable = $(".table-responsive");

    //actions
    public RegistrationPage openPage(){
        open("/automation-practice-form");  //конкретный адрес
        HeaderTitleGlobal.shouldHave(text("Practice Form"));  //ассерт глобального заголовка
        HeaderTitle.shouldHave(text("Student Registration Form"));  //ассерт заголовка
        $("#close-fixedban").click();
        return this;
    }

    public RegistrationPage setFirstName(String firstName){
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName){
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String userEmail){
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setGender(String Gender){
        $(byText(Gender)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber){
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
            $("#dateOfBirthInput").click();
            calendarComponent.setDate(day, month, year);
            return this;
    }


    public RegistrationPage setSubjectsInput(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage selectHobbies(String hobbies) {
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        return this;
    }

    public RegistrationPage setPicture(String picture) {
        selectPicture.uploadFromClasspath("img/1.png");
        return this;
    }

    public RegistrationPage setAddress(String currentAddress){
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public RegistrationPage setLocalAddress(String state, String city) {
        selectState.setValue(state).pressEnter();
        selectCity.setValue(city).pressEnter();
        return this;
    }

    public RegistrationPage setScroll() {
        Scroll.scrollTo();
        return this;
    }

    public RegistrationPage clickButton() {
        setButton.click();
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultTable.$(byText(fieldName)).parent().shouldHave(text(value));
        return this;
    }
}
