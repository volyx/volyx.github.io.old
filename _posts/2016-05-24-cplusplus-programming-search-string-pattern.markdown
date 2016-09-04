---
layout:     post
title:      Поиска первого вхождения шаблона в текст
date:       2016-05-24
categories: c-plus-plus course stepic
---

Задание 

[https://stepic.org/lesson/Использование-указателей-540/step/8](https://stepic.org/lesson/Использование-указателей-540/step/8)

Напишите функцию поиска первого вхождения шаблона в текст. В качестве первого параметра функция принимает текст (C-style строка), в которой нужно искать шаблон. В качестве второго параметра строку-шаблон (C-style строка), которую нужно найти. Функция возвращает позицию первого вхождения строки-шаблона, если он присутствует в строке (помните, что в C++ принято считать с 0), и -1, если шаблона в тексте нет. 

Учтите, что пустой шаблон (строка длины 0) можно найти в любом месте текста. 

Требования к реализации: при выполнении данного задания вы можете определять любые вспомогательные функции, если они вам нужны. Вводить или выводить что-либо не нужно. Реализовывать функцию main не нужно.


Решение

{% highlight cpp %}
#include <iostream>
using namespace std;

int strstr(const char *text, const char *pattern)
{	
	if(pattern[0] == '\0') {
		return 0;
	}
	int j = 0;
    for (; *text != '\0' ; text++) 
	{	
		// cout << text << endl;
		// cout << pattern[0] << endl;
		int i = 0;
		while (text[i] == pattern[i]) 
		{	
			// cout << pattern[i] << endl;
			i++;
			if (pattern[i] == '\0') 
			{
				return j;
			}
		}
		j++;
	}
	return -1;
	
}

int main() {
    cout << strstr("12345", "") << endl;
    cout << strstr("12345", "3") << endl;
    cout << strstr("12345", "34") << endl;
    cout << strstr("Java Pascal C++ Go", "C++") << endl;
}
{% endhighlight %}

Сам курс [https://stepic.org/course/7](https://stepic.org/course/7)