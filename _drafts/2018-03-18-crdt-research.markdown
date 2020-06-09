---
layout:     post
title:      CRDT
date:       2018-03-18
categories: crdt
---


## Op-based 

* prepare()
* effect()

+ reliable causal broadcast messaging middleware


# [Pure Operation-Based Replicated Data Types(2017)](http://haslab.uminho.pt/ashoker/files/arxivjournal.pdf)


Авторы предалгают уместить все CRDT типы в один фреймворк - Pure Op-Based CRDT framework.
Решают проблему унификации типов. Операция effect() становится общей для всех типов(не зависимой от типов. До этого для каждого типа данных нужна своя реализация функций effect() prepare()).
Авторы упаковывают название метода и параметры в "операцию"

Было  - операция inc(), операция dec(). 
Стало - одна операция, в которой inc/dec передаются как парамтеры.

*reliable causal broadcast* расширяют до *Tagged Causal Stable Broadcast*, в котоорый записываются дополнительные метаданные(которые раньше были в effect() функции)

*causal stability* которую обеспечивает TCSB. Идея в том, что операции хранятся в PO-log, но когда они становтся _causally stable_ , данные о казуальности стираются и операции просто хранятся последоавтельно. Это значительно уменьшает затраты на хранение операций, что было проблемой в предыдущих реализациях.

![pure crdt commutative types](https://i.imgur.com/352FToO.png)

Для коммутативных типов это отлично работает. А вот для некоммутативных - нет, например операции [add, v] [remove, v] не коммутативных. 
Для некоммутативных типов нам нужно определить как-то порядок опраций на реплике, в этом нам помжет TCSB.

Для реализации *reliable causal broadcast(RCB)* для упорядочивания сообщений часто используют векторные часы.
В TRCB кроме векторных часов мы будем писать еще временную метку(timestamp)

Понятие  *causal stability* использует как раз эту верменную метку, чтобы прийти в сосостояние *causally stable*
Состояние, в котором все последущие метки больше чем метка текущей.

![causal stability](https://i.imgur.com/uChET7C.png)

