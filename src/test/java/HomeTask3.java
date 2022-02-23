import Pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HomeTask3 {

    RegistrationPage registrationPage = new RegistrationPage();
    String FirstName = "Testov",
            lastName = "Test",
            userEmail = "Test@test.com",
            gender  = "Male",
            userNumber = "9031812772",
            day = "27",
            month = "February",
            year = "1995",
            subjects = "English",
            hobbies = "Sports" + "," + " " + "Reading" + "," + " " + "Music",
            picture = "img.png",
            address = "Test city",
            state = "Rajasthan",
            city = "Jaipur";


    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";  //общий адрес
        Configuration.startMaximized = true;  //масштабизацаия браузера на максимальный размер



    }
    @Test
    void successFillTest(){
        registrationPage.openPage()
                        .setFirstName(FirstName)
                        .setLastName(lastName)
                        .setEmail(userEmail)
                        .setGender(gender)
                        .setUserNumber(userNumber)
                        .setBirthDate(day, month, year)
                        .setSubjectsInput(subjects)
                        .selectHobbies(hobbies)
                        .setPicture(picture)
                        .setAddress(address)
                        .setLocalAddress(state,city)
                        .setScroll()
                        .clickButton();

        //Ассерт
        registrationPage.checkForm("Student Name",FirstName + " " + lastName)
                        .checkForm("Student Email", userEmail)
                        .checkForm("Gender", gender)
                        .checkForm("Gender", userNumber)
                        .checkForm("Date of Birth", day + " " + month + "," + year)
                        .checkForm("Subjects", subjects)
                        .checkForm("Hobbies", hobbies)
                        .checkForm("Picture", picture)
                        .checkForm("Address", address)
                        .checkForm("State and City", state + " " + city);
    }
}
