# Coffeemaker-rest-service

Приложение для работы кофеварки с управлением через браузер

## Запуск проекта

Для запуска проекта необходимо записать 3 параметра в application.properties:
-  **```spring.datasource.url```** - URL базы данных
-  **```spring.datasource.username```** - имя пользователя для базы данных
-  **```spring.datasource.password```** - пароль для базы данных

```Хост``` http://localhost:8080

## Последовательность запросов для теста приложения

Данные для запроса можно взять из описания ниже

-  `GET /api/v1/coffeemaker` - кофеварка начнет делать кофе
-  `POST /api/v1/coffeemaker/set` - установить значения жесткости и температуру воды
-  `GET /api/v1/coffeemaker/condition` - показать установленные значения значения
-  `GET /api/v1/coffeemaker/cleaning` - начать очистку от накипи

# Документация к API

SwaggerUI - `http://localhost:8080/swagger-ui.html`
