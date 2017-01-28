---
layout:     post
title:      Перестановочки
date:       2015-08-28
categories: algorithm
---

![](/images/permutation.png)


{% highlight java %}
def permutation(String input){
          permutation("", input);
}

def permutation(String perm, String word) {
        if (word.isEmpty()) {
            println(perm + word);

        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) 
                                        + word.substring(i + 1, word.length()));
            }
        }
}

permutation("123")
{% endhighlight%}