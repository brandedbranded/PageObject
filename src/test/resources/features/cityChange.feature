Feature: Смена города

  Background: Я нахожусь на главной странице сайта
    Given Открываем сайт "https://www.wildberries.ru/"

  Scenario Outline: Изменение адреса пункта выдачи для доставки товаров

    When Нажимаем на кнопку смены города
    And Вводим "<Название города>" в поисковую строку
    And Выбираем первый адрес из списка адресов
    And Нажимаем кнопку "Выбрать"

    Then Произошел переход на домашнюю страницу
    And На странице присутствует адрес выбранного пункта выдачи

    Examples:
      | Название города |
      | Санкт-петербург |
      | Москва          |
      | Обнинск         |

