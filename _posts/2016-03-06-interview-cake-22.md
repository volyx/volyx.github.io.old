#### Задача
Имея ссылку на узел удалить его из односвязного списка. Начальный код такой:

```language-java
  public static class LinkedListNode {

    public String value;
    public LinkedListNode next;

    public LinkedListNode(String value) {
        this.value = value;
    }
}

LinkedListNode a = new LinkedListNode("A");
LinkedListNode b = new LinkedListNode("B");
LinkedListNode c = new LinkedListNode("C");

a.next = b;
b.next = c;

deleteNode(b);
```

#### Забегая вперед

Мы сможем сделать это за *O(1)* по сложности и по *O(1)* по памяти! Ответ будет хитрый и будет работать не на всех входных данных...

#### Размышляем
Первое, что приходит в голову - это пройтись по всем узлам списка с начала до искомого узла. Но по условию у нас нет головного узла, у нас есть только ссылка на удаляемый узел.

Подождите-ка, как мы вообще удалим узел, если у нас нет ссылки на первый узел?

Мы сделаем так, что указатель предыдущего узла пропустит удаляемый узел, и будет указывать на узел, следующий за удаляемым. Так узлы выглядят **до** удаления: 

<svg width="455" height="155"><rect x="80" y="45" width="68" height="95" rx="4" ry="4" fill="#E3E3E3" stroke="#777" stroke-width="0"></rect><rect x="193" y="45" width="68" height="95" rx="4" ry="4" fill="rgba(91, 192, 222, 0.6)" stroke="#777" stroke-width="0"></rect><rect x="306" y="45" width="68" height="95" rx="4" ry="4" fill="#E3E3E3" stroke="#777" stroke-width="0"></rect><rect x="86.5" y="51.5" width="55" height="51.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="199.5" y="51.5" width="55" height="51.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="312.5" y="51.5" width="55" height="51.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="86.5" y="109.8" width="55" height="23.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="199.5" y="109.8" width="55" height="23.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="312.5" y="109.8" width="55" height="23.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><polygon points="184.5,130.125 193,121.625 184.5,113.125" fill="white" stroke="#777" stroke-width="1"></polygon><polygon points="297.5,130.125 306,121.625 297.5,113.125" fill="white" stroke="#777" stroke-width="1"></polygon><polygon points="410.5,130.125 419,121.625 410.5,113.125" fill="white" stroke="#777" stroke-width="1"></polygon><rect x="140.5" y="117.6" width="45.5" height="8" rx="0" ry="0" fill="white" stroke="white" stroke-width="1"></rect><rect x="253.5" y="117.6" width="45.5" height="8" rx="0" ry="0" fill="white" stroke="white" stroke-width="1"></rect><rect x="366.5" y="117.6" width="45.5" height="8" rx="0" ry="0" fill="white" stroke="white" stroke-width="1"></rect><line x1="141" y1="117.6" x2="185" y2="117.6" stroke="#555" stroke-width="1"></line><line x1="141" y1="125.6" x2="185" y2="125.6" stroke="#555" stroke-width="1"></line><line x1="254" y1="117.6" x2="298" y2="117.6" stroke="#555" stroke-width="1"></line><line x1="254" y1="125.6" x2="298" y2="125.6" stroke="#555" stroke-width="1"></line><line x1="367" y1="117.6" x2="411" y2="117.6" stroke="#555" stroke-width="1"></line><line x1="367" y1="125.6" x2="411" y2="125.6" stroke="#555" stroke-width="1"></line><text x="114" y="64.5" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">VALUE</text><text x="227" y="64.5" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">VALUE</text><text x="340" y="64.5" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">VALUE</text><text x="114" y="124.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">NEXT</text><text x="227" y="124.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">NEXT</text><text x="340" y="124.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">NEXT</text><text x="436" y="124.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">None</text><text x="114" y="90.5" font-weight="bold" font-size="23px" fill="rgba(91, 192, 222, 0.8)" text-anchor="middle">1</text><text x="227" y="90.5" font-weight="bold" font-size="23px" fill="rgba(91, 192, 222, 0.8)" text-anchor="middle">4</text><text x="340" y="90.5" font-weight="bold" font-size="23px" fill="rgba(91, 192, 222, 0.8)" text-anchor="middle">0</text><text x="227" y="22" font-weight="bold" font-size="9.5px" fill="#777" text-anchor="middle">Удаляемый</text><text x="227" y="35" font-weight="bold" font-size="9.5px" fill="#777" text-anchor="middle">узел</text></svg>

Так будут выглядеть узлы **после** удаления:

<svg width="455" height="180"><rect x="80" y="75" width="68" height="95" rx="4" ry="4" fill="#E3E3E3" stroke="#777" stroke-width="0"></rect><rect x="193" y="42" width="68" height="95" rx="4" ry="4" fill="rgba(91, 192, 222, 0.6)" stroke="#777" stroke-width="0"></rect><rect x="306" y="75" width="68" height="95" rx="4" ry="4" fill="#E3E3E3" stroke="#777" stroke-width="0"></rect><rect x="86.5" y="81.5" width="55" height="51.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="199.5" y="48.5" width="55" height="51.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="312.5" y="81.5" width="55" height="51.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="86.5" y="139.8" width="55" height="23.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="199.5" y="106.8" width="55" height="23.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="312.5" y="139.8" width="55" height="23.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><polygon points="297.5,160.125 306,151.625 297.5,143.125" fill="white" stroke="#777" stroke-width="1"></polygon><polygon points="297.5,127.125 306,118.625 297.5,110.125" fill="white" stroke="#777" stroke-width="1"></polygon><polygon points="410.5,160.125 419,151.625 410.5,143.125" fill="white" stroke="#777" stroke-width="1"></polygon><rect x="140.5" y="147.6" width="158.5" height="8" rx="0" ry="0" fill="white" stroke="white" stroke-width="1"></rect><rect x="253.5" y="114.6" width="45.5" height="8" rx="0" ry="0" fill="white" stroke="white" stroke-width="1"></rect><rect x="366.5" y="147.6" width="45.5" height="8" rx="0" ry="0" fill="white" stroke="white" stroke-width="1"></rect><line x1="141" y1="147.6" x2="298" y2="147.6" stroke="#555" stroke-width="1"></line><line x1="141" y1="155.6" x2="298" y2="155.6" stroke="#555" stroke-width="1"></line><line x1="254" y1="114.6" x2="298" y2="114.6" stroke="#555" stroke-width="1"></line><line x1="254" y1="122.6" x2="298" y2="122.6" stroke="#555" stroke-width="1"></line><line x1="367" y1="147.6" x2="411" y2="147.6" stroke="#555" stroke-width="1"></line><line x1="367" y1="155.6" x2="411" y2="155.6" stroke="#555" stroke-width="1"></line><text x="114" y="94.5" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">VALUE</text><text x="227" y="61.5" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">VALUE</text><text x="340" y="94.5" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">VALUE</text><text x="114" y="154.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">NEXT</text><text x="227" y="121.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">NEXT</text><text x="340" y="154.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">NEXT</text><text x="436" y="154.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">None</text><text x="114" y="120.5" font-weight="bold" font-size="23px" fill="rgba(91, 192, 222, 0.8)" text-anchor="middle">1</text><text x="227" y="87.5" font-weight="bold" font-size="23px" fill="rgba(91, 192, 222, 0.8)" text-anchor="middle">4</text><text x="340" y="120.5" font-weight="bold" font-size="23px" fill="rgba(91, 192, 222, 0.8)" text-anchor="middle">0</text><text x="227" y="19" font-weight="bold" font-size="9.5px" fill="#777" text-anchor="middle">Удаляемый</text><text x="227" y="32" font-weight="bold" font-size="9.5px" fill="#777" text-anchor="middle">узел</text></svg>

Нам нужно как-то пропустить текущий узел и перейти к следующему узлу. Но у нас же нет доступа к предыдущему узлу!

Что если кроме как перенаправлять указатель с предыдущего узла **существует другой способ перепрыгнуть с предыдущего значения на следующий?**

Что если мы изменим значение текущего узла вместо удаления его?

#### Решение
Мы скопируем значение и указатель следующего узла в удаляемый узел. Получится, что предыдущий узел будет пропускать удаляемый узел и указывать на следующий узел.

Так связный список выглядел до применения функции: 

<svg width="520" height="135"><rect x="80" y="35" width="68" height="95" rx="4" ry="4" fill="#E3E3E3" stroke="#777" stroke-width="0"></rect><rect x="193" y="35" width="68" height="95" rx="4" ry="4" fill="rgba(91, 192, 222, 0.6)" stroke="#777" stroke-width="0"></rect><rect x="306" y="35" width="68" height="95" rx="4" ry="4" fill="#E3E3E3" stroke="#777" stroke-width="0"></rect><rect x="86.5" y="41.5" width="55" height="51.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="199.5" y="41.5" width="55" height="51.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="312.5" y="41.5" width="55" height="51.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="86.5" y="99.8" width="55" height="23.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="199.5" y="99.8" width="55" height="23.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="312.5" y="99.8" width="55" height="23.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><polygon points="184.5,120.125 193,111.625 184.5,103.125" fill="white" stroke="#777" stroke-width="1"></polygon><polygon points="297.5,120.125 306,111.625 297.5,103.125" fill="white" stroke="#777" stroke-width="1"></polygon><polygon points="410.5,120.125 419,111.625 410.5,103.125" fill="white" stroke="#777" stroke-width="1"></polygon><rect x="140.5" y="107.6" width="45.5" height="8" rx="0" ry="0" fill="white" stroke="white" stroke-width="1"></rect><rect x="253.5" y="107.6" width="45.5" height="8" rx="0" ry="0" fill="white" stroke="white" stroke-width="1"></rect><rect x="366.5" y="107.6" width="45.5" height="8" rx="0" ry="0" fill="white" stroke="white" stroke-width="1"></rect><line x1="141" y1="107.6" x2="185" y2="107.6" stroke="#555" stroke-width="1"></line><line x1="141" y1="115.6" x2="185" y2="115.6" stroke="#555" stroke-width="1"></line><line x1="254" y1="107.6" x2="298" y2="107.6" stroke="#555" stroke-width="1"></line><line x1="254" y1="115.6" x2="298" y2="115.6" stroke="#555" stroke-width="1"></line><line x1="367" y1="107.6" x2="411" y2="107.6" stroke="#555" stroke-width="1"></line><line x1="367" y1="115.6" x2="411" y2="115.6" stroke="#555" stroke-width="1"></line><text x="114" y="54.5" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">VALUE</text><text x="227" y="54.5" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">VALUE</text><text x="340" y="54.5" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">VALUE</text><text x="114" y="114.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">NEXT</text><text x="227" y="114.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">NEXT</text><text x="340" y="114.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">NEXT</text><text x="436" y="114.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">None</text><text x="114" y="80.5" font-weight="bold" font-size="23px" fill="rgba(91, 192, 222, 0.8)" text-anchor="middle">3</text><text x="227" y="80.5" font-weight="bold" font-size="23px" fill="rgba(91, 192, 222, 0.8)" text-anchor="middle">8</text><text x="340" y="80.5" font-weight="bold" font-size="23px" fill="rgba(91, 192, 222, 0.8)" text-anchor="middle">2</text><text x="227" y="12" font-weight="bold" font-size="9.5px" fill="#777" text-anchor="middle">Удаляемый</text><text x="227" y="25" font-weight="bold" font-size="9.5px" fill="#777" text-anchor="middle">узел</text></svg>

После будет выгдядеть вот так:

<svg width="520" height="135"><rect x="80" y="35" width="68" height="95" rx="4" ry="4" fill="#E3E3E3" stroke="#777" stroke-width="0"></rect><rect x="193" y="35" width="68" height="95" rx="4" ry="4" fill="rgba(91, 192, 222, 0.6)" stroke="#777" stroke-width="0"></rect><rect x="366" y="35" width="68" height="95" rx="4" ry="4" fill="#E3E3E3" stroke="#777" stroke-width="0"></rect><rect x="86.5" y="41.5" width="55" height="51.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="199.5" y="41.5" width="55" height="51.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="372.5" y="41.5" width="55" height="51.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="86.5" y="99.8" width="55" height="23.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="199.5" y="99.8" width="55" height="23.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><rect x="372.5" y="99.8" width="55" height="23.75" rx="2" ry="2" fill="white" stroke="#777" stroke-width="1"></rect><polygon points="184.5,120.125 193,111.625 184.5,103.125" fill="white" stroke="#777" stroke-width="1"></polygon><polygon points="297.5,120.125 306,111.625 297.5,103.125" fill="white" stroke="#777" stroke-width="1"></polygon><polygon points="470.5,120.125 479,111.625 470.5,103.125" fill="white" stroke="#777" stroke-width="1"></polygon><rect x="140.5" y="107.6" width="45.5" height="8" rx="0" ry="0" fill="white" stroke="white" stroke-width="1"></rect><rect x="253.5" y="107.6" width="45.5" height="8" rx="0" ry="0" fill="white" stroke="white" stroke-width="1"></rect><rect x="426.5" y="107.6" width="45.5" height="8" rx="0" ry="0" fill="white" stroke="white" stroke-width="1"></rect><line x1="141" y1="107.6" x2="185" y2="107.6" stroke="#555" stroke-width="1"></line><line x1="141" y1="115.6" x2="185" y2="115.6" stroke="#555" stroke-width="1"></line><line x1="254" y1="107.6" x2="298" y2="107.6" stroke="#555" stroke-width="1"></line><line x1="254" y1="115.6" x2="298" y2="115.6" stroke="#555" stroke-width="1"></line><line x1="427" y1="107.6" x2="471" y2="107.6" stroke="#555" stroke-width="1"></line><line x1="427" y1="115.6" x2="471" y2="115.6" stroke="#555" stroke-width="1"></line><text x="114" y="54.5" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">VALUE</text><text x="227" y="54.5" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">VALUE</text><text x="400" y="54.5" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">VALUE</text><text x="114" y="114.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">NEXT</text><text x="227" y="114.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">NEXT</text><text x="400" y="114.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">NEXT</text><text x="496" y="114.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">None</text><text x="323" y="114.9" font-weight="normal" font-size="9.5px" fill="#777" text-anchor="middle">None</text><text x="114" y="80.5" font-weight="bold" font-size="23px" fill="rgba(91, 192, 222, 0.8)" text-anchor="middle">3</text><text x="227" y="80.5" font-weight="bold" font-size="23px" fill="rgba(91, 192, 222, 0.8)" text-anchor="middle">2</text><text x="400" y="80.5" font-weight="bold" font-size="23px" fill="rgba(91, 192, 222, 0.8)" text-anchor="middle">2</text><text x="227" y="12" font-weight="bold" font-size="9.5px" fill="#777" text-anchor="middle">Удаляемый</text><text x="227" y="25" font-weight="bold" font-size="9.5px" fill="#777" text-anchor="middle">узел</text></svg>

В некоторых языках, например в С нам потребовалось бы руками удалять скопированный узел. Но в Java есть сборщик мусора, который сам позаботится об этом.

```language-java
  public void deleteNode(LinkedListNode nodeToDelete) {

    // get the input node's next node, the one we want to skip to
    LinkedListNode nextNode = nodeToDelete.next;

    if (nextNode != null) {

        // replace the input node's value and pointer with the next
        // node's value and pointer. the previous node now effectively
        // skips over the input node
        nodeToDelete.value = nextNode.value;
        nodeToDelete.next  = nextNode.next;

    } else {

        // eep, we're trying to delete the last node!
        throw new IllegalArgumentException("Can't delete the last node with this method!");
    }
}
```

Есть две проблемы в нашем решении:

- **Первое, наша функция не работает в случае удаления последнего элемента.** Мы можем поменять значение удаляемого элемента на `null`, но указатель предыдущего узла все также будет ссылаться на этот узел, хоть и со значением `null`. Мы конечно можем трактовать узлы со значение `null` как удаленные и останавливать поиск при нахождении такого узла. 

- **Второе,** метод может выдавать неожиданные результаты. Возьмем такой код:

```language-java
LinkedListNode a = new LinkedListNode(3);
LinkedListNode b = new LinkedListNode(8);
LinkedListNode c = new LinkedListNode(2);

a.next = b;
b.next = c;

deleteNode(b);
```

Есть несколько побочных эффектов:

- **Не существует эффективного способа переписать ссылки с входящего узла на следующий узел.** Например, мы "удалили" узел который хранит ссылку на переменную `b`, но на самом деле, мы лишь присваиваем узлу новое значение(2) и новую ссылку `next`. Если мы имеем другой указатель на `b` откуда-нибудь из другой части кода и мы предполагаем, что объект имеет свое старое значение(8), что может привести к багам.
- **Если существуют указатели на следующий узел за входящим узлом, то эти указатели будут указывать на "висячие узлы"** (узел, который не достижим из связного списка). В примере выше, узел `c` будет "подвешан". Если мы поменяем `c`, мы никогда не достигнем это новое значение, двигаясь с головы связного списка до хвоста.

#### Сложность
`O(1)` по времени и `O(1)` по дополнительной памяти.

#### Источник
https://www.interviewcake.com/question/java/delete-node