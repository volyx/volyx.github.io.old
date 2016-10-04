---
layout:     post
title:      Изменить размер фотографий с помощью groovy и imgscalr
date:       2014-11-10
categories: javaswag
---

Простой кейс: у вас лежит где-то папка с фотографиями, которые используются в блоге и жестко "закодированны", но размер их очень большой. Загрузка страницы занимает около МИНУТЫ! Итак, ваша задача изменить параметры каждой фотки, не меняя названия и к тому же сохранить исходные фотографии. Можно конечно надолго зависнуть в интернете и потратить время на изучение и опробование разных готовых бесплатных программ, или можно быстро на коленке написать свое решение например на groovy!

![images](/images/groovy-image.jpg)

Полезные штуки если вы зашли сюда случайно.

* [Скачать Groovy](http://groovy-lang.org/download.html)
* [Веб-консоль, чтобы потренироваться и понять что такое groovy](https://groovyconsole.appspot.com)
* Менеджер зависимостей [Grape](http://groovy.codehaus.org/Grape), по типу maven, gradle. Динамически подгружает необходимые библиотеки для скрипта.

Сразу к делу, вот итоговый скрипт:

{% highlight groovy %}

@Grapes(
        @Grab(group='org.imgscalr', module='imgscalr-lib', version='4.2')
)
import static org.imgscalr.Scalr.*;
import org.imgscalr.Scalr;
import javax.imageio.ImageIO;
import javax.imageio.IIOException;
import java.awt.image.BufferedImage;

def srcFolder = "src"; // Из какой папки берем фотки
def destFolder = srcFolder + "/result/"; //В какую складываем 

BufferedImage img = null;
def amount = 0
new File(srcFolder).eachFile() {
    f ->

        try {
            img = ImageIO.read(f);
        }
        catch (IOException e) {
            println "IOException " + f.getName()
            return;
        }
        catch (IIOException ei) {
            println "IIOException"
            return;
        }

        if (img == null) return;

        BufferedImage thumbnail = Scalr.resize(img, 1000);

        File outputfile = new File(destFolder + f.getName());

        ImageIO.write(thumbnail, "jpg", outputfile);

        println "Path " + outputfile.toURL();
        
        amount++;

}

println amount + " images resized"

{% endhighlight %}

