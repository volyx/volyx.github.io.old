#### Задание

Написать функцию, переворачивающую строку без использования дополнительной памяти

<hr>

### Решение
Мы будем менять первый и последний элемент, затем второй и второй с конца, и так далее пока не достигнем середины.

```language-java
  public String reverse(String str) {

    char[] strChars = str.toCharArray();

    int startIndex = 0;
    int endIndex = strChars.length - 1;

    while (startIndex < endIndex) {

        // swap characters
        char temp = strChars[startIndex];
        strChars[startIndex] = strChars[endIndex];
        strChars[endIndex] = temp;

        // move towards middle
        startIndex++;
        endIndex--;
    }

    return new String(strChars);
}
```

Сложность
`O(n)` по времени и `O(1)` по доп. месту.

<hr/>
https://www.interviewcake.com/question/javascript/reverse-string-in-place

