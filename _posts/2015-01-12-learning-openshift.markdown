---
layout:     post
title:      Обзор книги "Learning OpenShift" 
date:       2015-01-12
categories: book openshift
---

Мне приглянулся openshift с самого начала. Я уже не помню, когда я первый раз задеплоил туда свое первое приложение. На протяжении всех этих лет я конечно поглядывал одним глазком на конкурентов, но каждый раз, когда мне неожиданно нужен был сервис для развертывания java-приложения, я непременно вспоминал про openshift и возвращался назад. По мне, так это самый удобный сервис для быстрого деплоя, прототипированя ваших приложений.

С годами [Openshift](https://www.openshift.com) заматерел, обзавелся поддержкой большого количества фрэймворков и технологий. Мне естественно нравятся java штуки, который предоставляет openshift - всякие apache tomcat, jboss eap и моя любимая mongodb. Полный список технологий можно поcмотреть тут [https://marketplace.openshift.com/home](https://marketplace.openshift.com/home). 

Когда мне предложили написать ревью на книгу [Learning Openshift](https://www.packtpub.com/virtualization-and-cloud/learning-openshift) я сразу согласился, потому что меня разрывало любопытство, что может быть я пропутил что-то очень важное в опешифте и непременно нужно это узнать.

Так как я считаю себя весьма опытным пользователем [openshift](https://www.openshift.com/), бронзовый план все-таки. То я бегло пробежал первые главы, потому что все эти шаги по настройки я много раз проворачивал на разных своих домашних машинах и знал почти наизусть. Мое внимание привлекла глава 6, в которой показывался пример быстрой разработки java-приложения с использованием spring, mongodb. Пример как быстро написать такое приложение я и хотел бы здесь привести. Материалы взяты из книги.

Для нетерпеливых [http://mlbparks-onpaas.rhcloud.com/](http://mlbparks-onpaas.rhcloud.com/) вот пример того, какое приложение получится в итоге. Если сайт сразу не загрузится - обновите несколько раз, такое бывает.

Ну и конечно и самое кратчайшее руководство, как сделать аналогичное приложение и картинка чтобы заинтересовать.

![](/images/learning_openshift_1.jpg)

{% highlight bash %}
$ rhc app create springmlb tomcat7 mongodb-2.4 --from-code https://github.com/gshipley/springmlb.git
{% endhighlight %}

Это для тех кто уже зарегистрировался в openshift и установил `rhc`, для остальных сюда [](https://developers.openshift.com/en/overview-what-is-openshift.html.) Это не сложно.

После выполненой команды подключимся к нашему приложении с помощью `ssh` для этого в консоли нужно выполнить команду

{% highlight bash %}
$ rhc app ssh springmlb
{% endhighlight %}

[Документация по ключам ssh](https://developers.openshift.com/en/managing-remote-connection.html)

После того как мы подключились к нашей машине загрузим json файл с данными и сохраним в папке `/tmp` на удаленной машине. Для этого выполним команду:

{% highlight bash %}
$ cd /tmp
$ wget https://raw.github.com/gshipley/springmlb/master/mlbparks.json
{% endhighlight %}

{% highlight bash %}
$ mongoimport --jsonArray -d $OPENSHIFT_APP_NAME -c teams --type json --file /tmp/mlbparks.json  -h $OPENSHIFT_MONGODB_DB_HOST --port $OPENSHIFT_MONGODB_DB_PORT -u $OPENSHIFT_MONGODB_DB_USERNAME  -p $OPENSHIFT_MONGODB_DB_PASSWORD
{% endhighlight %}


Потом можно проверить, зайдя по соответствующему `url`

![](/images/learning_openshift_2.jpg)

Вот собственно и все! Более подробную информацию можно увидеть в книге [https://www.packtpub.com/virtualization-and-cloud/learning-openshift](https://www.packtpub.com/virtualization-and-cloud/learning-openshift)

Так же очень хороший пример разработки похожего приложения находится тут [developing-single-page-applications-with-spring-mongodb-and-angularjs](https://blog.openshift.com/day-22-developing-single-page-applications-with-spring-mongodb-and-angularjs/)

Это блог разработчика [Shekhar Gulati](https://github.com/shekhargulati), у него есть очень интересный [цикл статей](https://blog.openshift.com/learning-30-technologies-in-30-days-a-developer-challenge/), в котором он в течении 30 дней разрабатывает по одному приложению в день с используя openshift


