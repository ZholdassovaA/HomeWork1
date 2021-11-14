package lesson1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
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
        $(".react-datepicker__day.react-datepicker__day--013").click();

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

        // проверки
        verifyData("Student Name","Айдана Жолдасова");
        verifyData("Student Email","user@gmail.com");
        verifyData("Gender","Female");
        verifyData("Mobile","77777777777");
        verifyData("Date of Birth","13 June,1997");
        verifyData("Subjects","Math");
        verifyData("Hobbies","Music");
        verifyData("Picture","girl.jpg");
        verifyData("Address","Тараз, Баженова 36");
        verifyData("State and City","NCR Delhi");
    }

    private void verifyData(String label, String value) {
        $(".table-responsive").$(byText(label)).parent().shouldHave(text(value));
    }

}
