###  How Do the Stack and Heap Work Together?

#### **Stack Memory**
- **Purpose:** Holds method call information and local variables.
- Each thread gets its own stack.
  
#### **Heap Memory**
- **Purpose:** Stores objects created at runtime and is shared among all threads.

#### **Example of Stack and Heap Interaction**
```java
public class Demo {
    public static void main(String[] args) {
        int x = 10; // Stored in the stack
        Person p = new Person(); // Reference in stack, object in heap
    }
}
```
- **Stack:**  
  - Holds `x` and the reference `p`.
- **Heap:**  
  - Holds the `Person` object.

---
