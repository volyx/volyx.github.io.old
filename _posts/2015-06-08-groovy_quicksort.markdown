---
layout:     post
title:      Groovy. Быстрая сортировка.
date:       2015-06-08
categories: algorithm
---

Groovy отличный язык, если захотелось прям с ходу взять и написать какой-то алгоритм или скрипт. Советую всем программистам иногда "разминать" свои интерпрайзные мозги какими-нибудь задачками.

![](/images/quicksort.png)

Этот алгоритм, наверное, является самым популярным алгоритмом сортировки. Он весьма прост, быстр и сортирует задействуя минимальное количество дополнительной памяти. Для большинства задач, где требуется сортировка "Quick sort" является хорошим выбором.

{% highlight java %}
// массив, который будем сортировать
def a = [1,5,7,8,45,7,45,34,45,78,9]

/**
 * Печать массива. Наверное, такой метод, уже есть, елнь было искать.
 */
void printArr(a) {
    
    a.each{i -> 
    
        print i + ', '
    
    }

} 

/**
 * Сортировка
 */
void sort(a) {
    sort(a, 0, a.size() - 1)
}

void sort(a, s, e) {
    int index = partition(a, s, e)
   
   
    printArr(a);
    
    if (s < index -1 ) 
        sort(a, s, index -1)
    if (index < e) 
        sort(a, index, e)
    

}

/**
 * Находим "средний" элемент и сортируем относительно него
 */    
def partition(a, s , e) {
 int p = (s + e) / 2

    def i = s;
    def j = e;
    def pivot = a[p];
    println "pivot=" + pivot
    
    while (i<=j) {
        while (a[i] < pivot) {
            i++;
        }
        
        while (a[j] > pivot) {
            j--
        }
        
        println "i=" + i + " j=" + j
        
        def tmp;
        if (i<=j) {
             tmp = a[i]
             a[i] = a[j]
             a[j] = tmp
             println "swap " + a[i] + " " + a[j]  + " i j " + i + "-" + j
             i++
             j--
        }
        
        printArr(a);
    }
     println "index=" + i
        
    return i
}

println "Исходный массив:"
printArr(a);

sort(a)
println "Отсортированный:"
printArr(a)
{% endhighlight %}