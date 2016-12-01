---
layout:     post
title:      Размен монет
date:       2016-11-20
categories: programming
---


http://py-algorithm.blogspot.ru/2011/04/blog-post_20.html

Сколькими способами можно оплатить посылку за 19 копеек марками достоинством 1,4,6 или 10 копеек? (Порядок марок не важен)

{% highlight groovy %}
def countChange(amount) {
    return cc(amount, 4)
    }
def cc(amount, kindsOfCoins) {
    if (amount==0) {
        return 1
    }
    if (amount<0 || kindsOfCoins==0) {
        return 0
    } 
    
    return cc(amount, kindsOfCoins-1)+cc(amount-firstDenomination(kindsOfCoins), kindsOfCoins)
}
def firstDenomination(kindsOfCoins) {
    if (kindsOfCoins==1) {
        return 1 //1 цент
    } else if (kindsOfCoins==2) {
        return 4 //5 центов
    } else if (kindsOfCoins==3) {
        return 6 //10 центов
    } else return 10
}

countChange(19)


{% endhighlight %}
