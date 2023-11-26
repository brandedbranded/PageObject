package stepdefinitions;

import io.cucumber.java.en.*;

public class AddToCartSteps {
    @And("Наводим курсор на первый товар выдачи")
    public void наводимКурсорНаПервыйТоварВыдачи() {
    }

    @And("Нажимаем кнопку корзины в правом верхнем углу")
    public void нажимаемКнопкуКорзиныВПравомВерхнемУглу() {
    }

    @And("Путь фильтра соответствует Главная \\/ {string} \\/ {string} \\/ {string}")
    public void путьФильтраСоответствуетГлавная(String arg0, String arg1, String arg2) {
    }

    @And("В правом верхнем углу над логотипом {string} появилась красная цифра {string}")
    public void вПравомВерхнемУглуНадЛоготипомПоявиласьКраснаяЦифра(String arg0, String arg1) {
    }

    @And("Текст и цена товара соответствует цене и названию товара из выдачи товаров")
    public void текстИЦенаТовараСоответствуетЦенеИНазваниюТовараИзВыдачиТоваров() {
    }

    @And("Поле {string} равняется цене товара")
    public void полеРавняетсяЦенеТовара(String arg0) {
    }

    @And("Кнопка {string} кликабельна")
    public void кнопкаКликабельна(String arg0) {
    }
}
