Let’s dive into **Set**, its hierarchy, and its key operations.

---

### **Set Overview**
- A **Set** is a collection that **does not allow duplicate elements**.
- Implements the **Collection** interface.
- Does **not maintain insertion order** (except specific implementations like `LinkedHashSet`).
- Commonly used to store unique elements or eliminate duplicates from a collection.

---

### **Hierarchy of Set**

1. **Set (Interface)**
   - **HashSet**: Fastest; no order.
   - **LinkedHashSet**: Maintains insertion order.
   - **TreeSet**: Sorted in natural order or by a custom comparator.

---

### **Implementations of Set**

#### 1. **HashSet**
- Backed by a **HashMap**.
- Does **not guarantee any order** of elements.
- Best for **performance** (constant-time operations for add, remove, contains).

#### 2. **LinkedHashSet**
- Backed by a **LinkedHashMap**.
- Maintains the **insertion order**.

#### 3. **TreeSet**
- Backed by a **TreeMap**.
- Elements are sorted in **natural order** or by a custom comparator.

---

### **Important Set Operations**

#### **1. Add Elements**
Elements can be added using the `add()` method. Duplicate elements are ignored.

```java
Set<String> set = new HashSet<>();
set.add("Apple");
set.add("Banana");
set.add("Apple"); // Duplicate, will not be added
System.out.println(set); // [Apple, Banana]
```

---

#### **2. Remove Elements**
You can remove elements using `remove()`.

```java
set.remove("Apple");
System.out.println(set); // [Banana]
```

---

#### **3. Check Size**
Use `size()` to get the number of elements.

```java
System.out.println(set.size()); // 1
```

---

#### **4. Iterate Over Elements**
Since `Set` does not have indexing, you iterate using a loop or a lambda expression.

- **Enhanced for-loop**:
  ```java
  for (String fruit : set) {
      System.out.println(fruit);
  }
  ```

- **Iterator**:
  ```java
  Iterator<String> iterator = set.iterator();
  while (iterator.hasNext()) {
      System.out.println(iterator.next());
  }
  ```

- **Lambda**:
  ```java
  set.forEach(System.out::println);
  ```

---

#### **5. Check Existence**
Use `contains()` to check if an element exists.

```java
System.out.println(set.contains("Banana")); // true
System.out.println(set.contains("Apple"));  // false
```

---

#### **6. Clear Set**
Remove all elements using `clear()`.

```java
set.clear();
System.out.println(set); // []
```

---

#### **7. Union, Intersection, and Difference**
You can achieve these using `addAll`, `retainAll`, and `removeAll`.

```java
Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
Set<Integer> set2 = new HashSet<>(Set.of(2, 3, 4));

// Union
Set<Integer> union = new HashSet<>(set1);
union.addAll(set2); 
System.out.println(union); // [1, 2, 3, 4]

// Intersection
Set<Integer> intersection = new HashSet<>(set1);
intersection.retainAll(set2);
System.out.println(intersection); // [2, 3]

// Difference
Set<Integer> difference = new HashSet<>(set1);
difference.removeAll(set2);
System.out.println(difference); // [1]
```

---

### **Set Implementations in Detail**

#### **HashSet**
- Backed by a **hash table** (internally uses a `HashMap`).
- Best for performance but **unordered**.

```java
Set<String> hashSet = new HashSet<>();
hashSet.add("Zebra");
hashSet.add("Lion");
hashSet.add("Tiger");
System.out.println(hashSet); // Order may vary
```

#### **LinkedHashSet**
- Maintains **insertion order**.
- Slightly slower than `HashSet`.

```java
Set<String> linkedHashSet = new LinkedHashSet<>();
linkedHashSet.add("Zebra");
linkedHashSet.add("Lion");
linkedHashSet.add("Tiger");
System.out.println(linkedHashSet); // [Zebra, Lion, Tiger]
```

#### **TreeSet**
- Stores elements in **sorted order**.
- Slower compared to `HashSet` and `LinkedHashSet`.

```java
Set<String> treeSet = new TreeSet<>();
treeSet.add("Zebra");
treeSet.add("Lion");
treeSet.add("Tiger");
System.out.println(treeSet); // [Lion, Tiger, Zebra]
```

---

### **Set Operations Summary**

| **Operation**          | **Method**                   | **Description**                              |
|-------------------------|-----------------------------|----------------------------------------------|
| Add elements            | `add(element)`             | Adds an element to the set. Ignores duplicates. |
| Remove elements         | `remove(element)`          | Removes the specified element.               |
| Check existence         | `contains(element)`        | Returns `true` if the element exists.        |
| Get size                | `size()`                   | Returns the total number of elements.        |
| Iterate                 | `forEach`, `iterator()`    | Loops through the set elements.             |
| Clear                   | `clear()`                  | Removes all elements.                        |
| Union                   | `addAll(collection)`       | Combines two sets.                           |
| Intersection            | `retainAll(collection)`    | Retains common elements.                     |
| Difference              | `removeAll(collection)`    | Removes common elements.                     |

---
