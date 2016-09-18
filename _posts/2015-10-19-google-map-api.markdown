---
layout:     post
title:      Гугл Мап Апи
date:       2015-10-19
summary: 	Для проекта понадобилось отображать пользовательские маршруты на карте 
categories: google-map
---

Для проекта понадобилось отображать пользовательские маршруты на карте. То есть пользователь должен уметь:

- Ввести название города, населенного пункта или какого-то географического объекта
- Должны найтись координаты этого объекта
- Возможность строить маршрут на карте
- Расставлять фотографии на карте по встроенным координатам

Координаты из фотографии

https://blueimp.github.io/JavaScript-Load-Image/

Пример
![](/content/images/2015/10/75c2290a5e5820e07867fcc3bab544a2.png)

Вон сами координаты: GPSLatitude, GPSLongtitude

Поиск координат по названиям географических объектов:

<iframe width="100%" height="300" src="//jsfiddle.net/mrajcok/pEq6X/embedded/" allowfullscreen="allowfullscreen" frameborder="0"></iframe>

Можно поиграться с веб-сервисом с помощью параметров ссылки

[GoogleMap](http://maps.google.com/maps/api/geocode/json?address=%D0%92%D0%BE%D1%80%D0%BE%D0%BD%D0%B5%D0%B6+%D0%9B%D1%8E%D0%B7%D1%8E%D0%BA%D0%BE%D0%B2%D0%B0+63)

Расставлять на карте точки с "кастомным маркером" и соединить их маршрутом:
<iframe width="100%" height="300" src="//jsfiddle.net/mrbtcrLg/embedded/" allowfullscreen="allowfullscreen" frameborder="0"></iframe>

Примерное решение описал, для себя, поэтому оно просто 100% должно быть не оптимальным и можно сделать лучше.
