---
layout:     post
title:      Красивишная печать дерева в консоль TreeNode
date:       2014-12-02
categories: java дерево
---

Cтруктура, известная у программистов как дерево, используется довольно часто. Соответственно, так же часто возникает проблема отладки кода, который работает с этой структурой. Очень удобно иметь под рукой удобный метод "toString()", который нарисует это дерево, например в консоли в графическом виде. 

![](/images/print-tree.png)

Печатает дерево в консоли, с помощью System.out
{% highlight java %}

 public void print(TreeNode root) {
        print(root, "", true);
    }

 private void print(TreeNode root, String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + root.toString());
        List<TreeNode> children = Collections.list(root.children());
        for (int i = 0; i < children.size() - 1; i++) {
            print(children.get(i), prefix + (isTail ? "    " : "│   "), false);
        }
        if (children.size() > 0) {
            print(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true);
        }
}
{% endhighlight %}


Вывод:
{% highlight java %}
----
└── rootFakeNode
    └── lock0
        ├── branchName0
        └── lock1
            ├── branchName0
            └── lock0
                └── branchName0
{% endhighlight %}
Вау, красотища!!!


