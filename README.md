# arifmeticRestApi
Данные передаются через параметры запроса

вывод в формате json

Запросы

GET /calculator/summary (операция сложения)
Пример: http://localhost:8080/calculator/summary?numbers=3&numbers=2&numbers=332

GET /calculator/multiply (операция умножение)
Пример:http://localhost:8080/calculator/multiply?numbers=3&numbers=2&numbers=332

GET /calculator/custom (операция умножение и сложение)
Пример:http://localhost:8080/calculator/custom?numbers=3&numbers=2&numbers=332

GET /calculator/divide (операция деление)
Пример:http://localhost:8080/calculator/divide?dividend=3&divisor=2

Все операции сохраняются в бд формате (id,type,param,result)

При запуске измените подключение к бд в application.properties
