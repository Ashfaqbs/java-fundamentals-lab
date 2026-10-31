Let’s explore **Vector** and **Stack**, which are part of the **List** family but have unique characteristics.

---

### **1. Vector**

#### **Overview**:
- **Legacy class** in Java, part of the `java.util` package.
- Implements the **List** interface and is similar to `ArrayList`, but it is **synchronized**.
- Slower than `ArrayList` due to thread-safe operations.
- Can grow dynamically, doubling its size when needed.

#### **Key Points**:
- Allows **duplicate elements**.
- Maintains **insertion order**.
- Uses **synchronization**, making it thread-safe.

#### **Important Methods in Vector**:
1. **Add Elements**:
   ```java
   Vector<String> vector = new Vector<>();
   vector.add("Apple");
   vector.add("Banana");
   System.out.println(vector); // [Apple, Banana]
   ```

2. **Access and Update**:
   ```java
   System.out.println(vector.get(0)); // Apple
   vector.set(1, "Mango");
   System.out.println(vector); // [Apple, Mango]
   ```

3. **Remove Elements**:
   ```java
   vector.remove("Apple");
   System.out.println(vector); // [Mango]
   ```

4. **Iterate Over Elements**:
   ```java
   for (String fruit : vector) {
       System.out.println(fruit);
   }
   ```

5. **Capacity and Size**:
   - **`capacity()`**: Returns the current capacity of the vector.
   - **`size()`**: Returns the number of elements.
   ```java
   System.out.println(vector.capacity()); // Default is 10
   System.out.println(vector.size());    // 1
   ```

6. **Check if Empty**:
   ```java
   System.out.println(vector.isEmpty()); // false
   ```

#### **When to Use Vector?**
- Use `Vector` only if you need **thread-safe operations** and don't want to use **synchronized collections** explicitly.

---

### **2. Stack**

#### **Overview**:
- Subclass of `Vector` that implements a **Last-In-First-Out (LIFO)** data structure.
- Part of `java.util` package.
- Provides methods for stack operations like **push**, **pop**, and **peek**.

#### **Key Points**:
- Extends `Vector`, so it inherits all `Vector` functionalities.
- Thread-safe due to `Vector`.

#### **Important Methods in Stack**:
1. **Push an Element**:
   Adds an element to the top of the stack.
   ```java
   Stack<Integer> stack = new Stack<>();
   stack.push(10);
   stack.push(20);
   System.out.println(stack); // [10, 20]
   ```

2. **Pop an Element**:
   Removes and returns the top element.
   ```java
   System.out.println(stack.pop()); // 20
   System.out.println(stack);       // [10]
   ```

3. **Peek at Top Element**:
   Returns the top element without removing it.
   ```java
   System.out.println(stack.peek()); // 10
   ```

4. **Check if Empty**:
   ```java
   System.out.println(stack.isEmpty()); // false
   ```

5. **Search for an Element**:
   Returns the **1-based position** of an element from the top of the stack.
   ```java
   System.out.println(stack.search(10)); // 1
   System.out.println(stack.search(30)); // -1 (not found)
   ```

#### **Example: Basic Stack Operations**
```java
public class StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // Push elements
        stack.push("A");
        stack.push("B");
        stack.push("C");

        // Peek and pop
        System.out.println("Top element: " + stack.peek()); // C
        System.out.println("Popped element: " + stack.pop()); // C

        // Check remaining elements
        System.out.println("Stack: " + stack); // [A, B]

        // Check if empty
        System.out.println("Is empty: " + stack.isEmpty()); // false
    }
}
```

#### **When to Use Stack?**
- Use `Stack` for **LIFO** operations.
- For modern, unsynchronized alternatives, consider **Deque** (`ArrayDeque`).

---

### **Vector vs Stack**

| Feature              | Vector                      | Stack                     |
|----------------------|-----------------------------|---------------------------|
| Type                 | General-purpose collection | LIFO data structure       |
| Thread-Safety        | Synchronized               | Synchronized              |
| Order Maintenance    | Maintains insertion order  | Maintains insertion order |
| Use Case             | List-like operations       | LIFO operations           |
| Key Methods          | `add()`, `get()`, `remove()` | `push()`, `pop()`, `peek()` |

---
