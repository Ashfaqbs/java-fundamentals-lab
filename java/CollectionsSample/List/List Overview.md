Let’s focus on **List** in detail, covering **important operations** and their examples.

---

### **List Overview**
A **List** in Java is an ordered collection that:
- Allows duplicate elements.
- Maintains insertion order.
- Provides indexed access to elements.

### **Common Implementations of List**
1. **ArrayList** (backed by a resizable array).
2. **LinkedList** (backed by a doubly linked list).
3. **Vector** (thread-safe, rarely used now).

---

### **Common Operations on List**

#### 1. **Add Elements**
You can add elements at the end or at a specific index.

```java
List<String> list = new ArrayList<>();
list.add("Apple");  // Adds to the end
list.add("Banana");
list.add(1, "Mango");  // Adds at index 1
System.out.println(list); // [Apple, Mango, Banana]
```

---

#### 2. **Access Elements**
You can access elements using the `get(index)` method.

```java
System.out.println(list.get(0)); // Apple
System.out.println(list.get(1)); // Mango
```

---

#### 3. **Update Elements**
Replace an element at a specific index using `set(index, element)`.

```java
list.set(1, "Orange"); // Replace Mango with Orange
System.out.println(list); // [Apple, Orange, Banana]
```

---

#### 4. **Remove Elements**
You can remove elements by index or value.

```java
list.remove(0); // Removes the element at index 0 (Apple)
list.remove("Banana"); // Removes the element by value
System.out.println(list); // [Orange]
```

---

#### 5. **Check Size**
Get the total number of elements using `size()`.

```java
System.out.println(list.size()); // 1
```

---

#### 6. **Iterate Through List**
- Using a `for` loop:
```java
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}
```

- Using an enhanced `for` loop:
```java
for (String item : list) {
    System.out.println(item);
}
```

- Using a lambda expression:
```java
list.forEach(System.out::println);
```

---

#### 7. **Check Existence**
Use `contains()` to check if a list contains an element.

```java
System.out.println(list.contains("Orange")); // true
System.out.println(list.contains("Apple")); // false
```

---

#### 8. **Sort a List**
You can sort using `Collections.sort()` for natural ordering or a custom comparator.

```java
List<Integer> numbers = new ArrayList<>(List.of(5, 2, 8, 1));
Collections.sort(numbers); // Sort in ascending order
System.out.println(numbers); // [1, 2, 5, 8]

// Custom Comparator: Sort in descending order
numbers.sort(Comparator.reverseOrder());
System.out.println(numbers); // [8, 5, 2, 1]
```

---

#### 9. **Convert Between List and Array**
- Convert List to Array:
```java
String[] array = list.toArray(new String[0]);
System.out.println(Arrays.toString(array)); // [Orange]
```

- Convert Array to List:
```java
String[] fruits = {"Apple", "Mango", "Banana"};
List<String> fruitList = Arrays.asList(fruits);
System.out.println(fruitList); // [Apple, Mango, Banana]
```

---

#### 10. **Sublist**
Extract a portion of the list using `subList(start, end)`.

```java
List<String> subList = fruitList.subList(0, 2);
System.out.println(subList); // [Apple, Mango]
```

---

#### 11. **Clear List**
Remove all elements from the list.

```java
list.clear();
System.out.println(list); // []
```

---

#### 12. **List Equals**
Check if two lists are equal (same elements and order).

```java
List<String> list1 = new ArrayList<>(List.of("Apple", "Banana"));
List<String> list2 = new ArrayList<>(List.of("Apple", "Banana"));
System.out.println(list1.equals(list2)); // true
```

---

#### 13. **List to Stream (For Advanced Use Cases)**
Java 8 streams can be used for powerful manipulations.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);
List<Integer> evenNumbers = numbers.stream()
                                    .filter(n -> n % 2 == 0)
                                    .collect(Collectors.toList());
System.out.println(evenNumbers); // [2, 4]
```

---

### Summary of Operations

| **Operation**         | **Method**                   |
|-----------------------|-----------------------------|
| Add element           | `add(element)`, `add(index, element)` |
| Access element        | `get(index)`               |
| Update element        | `set(index, element)`      |
| Remove element        | `remove(index)`, `remove(value)` |
| Size of list          | `size()`                   |
| Check existence       | `contains(value)`          |
| Sort list             | `Collections.sort(list)`   |
| Convert to array      | `toArray()`                |
| Extract sublist       | `subList(start, end)`      |
| Clear list            | `clear()`                 |
| Compare lists         | `equals(list)`            |

---

