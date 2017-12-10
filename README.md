# sahibinden.project
sahibinden.com dev.akademi project

Hi everyone

In this project i have created a web service that gets informations about SCoin (imaginary currency unit) and shows them in pages.

devakademi.sahibinden.com/ticker    -->    produces current value of SCoin
devakademi.sahibinden.com/history   -->    produces values of SCoin all the time with dates (in ms)

When you run the project, an you will face an welcomePage. There is an 2 links:

GO TO THE HISTORY OF SCOIN : opens a web page that shows values of SCoin all the time like a value - time pairs
  Note: It works good. Time values parsed as 'dd.MM.yyyy HH:mm'

SCOIN <----> OTHER MONEY PRICES : opens a web page. But there is a problem about this page. I created and implemented its back-end side ( like services, methods etc.) but could not completed. So it does not show you anything. Even so i want to explain what it will be do when its completed. There will be two task. One of them converts SCoin to another currency or does the exact opposite. The other task is showing current value SCoin.


REQUIREMENTS

Only Tomcat server.


FEATURES

-> Spring framework
-> RESTful service
-> AngularJS
-> POJO


There is an Abstract classes. The purpose of them, implementing an service class and POJO class will be enough if anyone wants to add a new currency.
