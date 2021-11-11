package Lesson1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormForStudents {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void FormToFill(){
        // открываем страницу для тестирования
        open("https://demoqa.com/automation-practice-form");

        // заполняем поля
        // имя
        $("#firstName").setValue("Айдана");

        // фамилия
        $("#lastName").setValue("Жолдасова");

        // адрес электронной почты
        $("#userEmail").setValue("user@gmail.com");

        // пол
        $(byText("Female")).click();

        // номер мобильного телефона
        $("#userNumber").setValue("7777777777");

        // дата рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOptionByValue("1997");
        $(".react-datepicker__day.react-datepicker__day--03").click();

        // предмет
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Math");
        $(byText("Math")).click();

        // хобби
        $(byText("Music")).click();

        // загрузить фотографию
        $("#uploadPicture").uploadFile(new File("src//test//resources//girl.jpg"));

        // адресс
        $("#currentAdress").setValue("Тараз, Баженова 36");

        // штат
        $("#state").click();
        $(byText("NCR")).click();

        // город
        $("#city").click();
        $(byText("Delhi")).click();

        // утверждение
        $("#submit").click();

    }



}
