<!-- ### Collection -->

```mermaid
classDiagram
    class List {
        <<Interface>>
        +size() int
        +isEmpty() boolean
        add(E e) boolean
        remove(Object o) boolean
        get(int index) E
        clear() void
    }
    class Deque {
        <<Interface>>
        addFirst(E e) void
        addLast(E e) void
        offerFirst(E e) boolean
        offerLast(E e) boolean
        removeFirst() E
        removeLast() E
        pollFirst() E
        pollLast() E
        getFirst() E
        getLast() E
        peekFirst() E
        peekLast() E
    }
    class AbstractQueue {
        <<Abstract>>
    }
    class Queue {
        <<Interface>>
        add(e) boolean
        offer(e) boolean
        remove() E
        poll() E
        element() E
        peek() E
    }
    class Stack {
        <<Interface>>
        push(E e) void
        pop() E
        peek() E
    }

    ArrayList ..|> List
    Vector ..|> List
    LinkedList ..|> List

    Deque --|> Stack
    Deque --|> Queue
    LinkedList ..|> Deque
    ArrayDeque ..|> Deque
    AbstractQueue ..|> Queue
    PriorityQueue --|> AbstractQueue
```

&nbsp;

```mermaid
classDiagram
    class Set {
        <<Interface>>
        add(e) boolean
        remove() E
        contains(Object o) boolean
        clear() void
    }
    class AbstractSet {
        <<Abstract>>
    }
    class NavigableSet {
        <<Interface>>
    }

    AbstractSet ..|> Set
    HashSet --|> AbstractSet
    TreeSet --|> AbstractSet
    TreeSet ..|> NavigableSet
```

&nbsp;

```mermaid
classDiagram
    class NavigableMap {
        <<Interface>>
    }
    class Map {
        <<Interface>>
    }
    class AbstractMap {
        <<Abstract>>
    }
    class Dictionary {
    }

    AbstractMap ..|> Map

    TreeMap --|> AbstractMap
    TreeMap ..|> NavigableMap

    HashMap --|> AbstractMap
    LinkedHashMap --|> HashMap

    Hashtable ..|> Map
    Hashtable --|> Dictionary
```

|            | 数据结构 | 线程安全性 | 扩容机制 |
| ---------: | :------: | :--------- | -------- |
|  ArrayList |   数组   | 不安全     | 1.5倍    |
|     Vector |   数组   | 安全       | 2.0倍    |
| LinkedList |   链表   | 不安全     | 无       |

|               | 数据结构 |
| ------------: | :------: |
|    ArrayDeque | 循环数组 |
| PriorityQueue |  小顶堆  |
|    LinkedList | 双向链表 |

|         | 数据结构 | 特点                   |
| ------: | :------: | ---------------------- |
| TreeSet |  二叉树  | 元素有序               |
| HashSet |  哈希表  | 元素无序、可放入null值 |

|               | 数据结构                 | 线程安全 | 特点                       |
| ------------: | :----------------------- | :------: | -------------------------- |
|       HashMap | 散列表、单链表/红黑树    |    无    | `key`和`value`可以为`null` |
| LinkedHashMap | 散列表、单链表、双向链表 |    无    | 双向链表维护键值对的顺序   |
|       TreeMap | 红黑树                   |    无    |                            |
|     Hashtable | 散列表、单链表           |    有    |                            |

```java
// 迭代List
List<String> list = new ArrayList<String>(){{
    add("A"); add("B"); add("C");
}};
Iterator<String> it = list.iterator();

// 方法1
while (it.hasNext()) {
    System.out.printf("%s ", it.next());
}
System.out.print('\n');

// 方法2
for (String item : list) {
    System.out.printf("%s ", item);
}
```
