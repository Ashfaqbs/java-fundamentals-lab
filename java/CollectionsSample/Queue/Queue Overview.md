Let’s explore the **Queue** interface and one of its key implementations, **PriorityQueue**.

---

### **1. Overview of `Queue` Interface**
- Part of `java.util` package.
- Represents a **First-In-First-Out (FIFO)** data structure.
- Used when elements need to be processed in a specific order.
- Some implementations may follow different orders, like **priority**.

---

### **Hierarchy of Queue**

1. **Queue (Interface)**
   - **LinkedList**: Implements both `Queue` and `Deque` interfaces. Supports FIFO order.
   - **PriorityQueue**: Maintains a **priority heap**; elements are ordered by natural order or custom comparator.

---

### **Common Queue Operations**

| **Operation**            | **Method**           | **Description**                                                    |
|--------------------------|---------------------|--------------------------------------------------------------------|
| Add element              | `offer(element)`    | Adds an element to the queue. Returns `false` if it fails.        |
| Remove element           | `poll()`            | Removes and returns the head. Returns `null` if the queue is empty.|
| Peek at the head         | `peek()`            | Returns the head without removing it. Returns `null` if empty.    |
| Check if empty           | `isEmpty()`         | Returns `true` if the queue is empty.                             |
| Iterate over elements    | `forEach` or `iterator()` | Loops through all elements in the queue.                   |

---

### **2. PriorityQueue**

#### **Overview**:
- A queue that processes elements in **natural order** or **custom order** defined by a `Comparator`.
- **Not thread-safe** (use `PriorityBlockingQueue` for concurrent environments).
- Does **not allow null elements**.

---

#### **Key Features of PriorityQueue**:
- Elements are **not stored in FIFO order**; they are ordered based on priority.
- Backed by a **binary heap**.
- Suitable for scenarios where you need to process elements in a specific order (e.g., shortest job first).

---

#### **PriorityQueue Operations**

1. **Add Elements**:
   Use `offer()` or `add()` to insert elements. Elements are automatically ordered.

   ```java
   PriorityQueue<Integer> pq = new PriorityQueue<>();
   pq.offer(10);
   pq.offer(5);
   pq.offer(20);
   System.out.println(pq); // [5, 10, 20] (natural order)
   ```

2. **Peek at the Head**:
   Retrieves the element with the **highest priority** (smallest in natural order).

   ```java
   System.out.println(pq.peek()); // 5
   ```

3. **Remove the Head**:
   Removes and returns the element with the **highest priority**.

   ```java
   System.out.println(pq.poll()); // 5
   System.out.println(pq);        // [10, 20]
   ```

4. **Custom Comparator**:
   Use a custom comparator for custom ordering.

   ```java
   PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
   maxPQ.offer(10);
   maxPQ.offer(5);
   maxPQ.offer(20);
   System.out.println(maxPQ); // [20, 5, 10] (max-heap)
   ```

---

### **Example: Basic PriorityQueue Operations**

```java
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Natural order
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements
        pq.offer(15);
        pq.offer(10);
        pq.offer(20);

        // Peek at the smallest element
        System.out.println("Head of the queue: " + pq.peek()); // 10

        // Poll elements
        while (!pq.isEmpty()) {
            System.out.println("Removed: " + pq.poll()); // 10, 15, 20
        }
    }
}
```

---

### **Comparison: LinkedList vs PriorityQueue**

| Feature             | `LinkedList` as Queue       | `PriorityQueue`                |
|---------------------|-----------------------------|---------------------------------|
| Order               | FIFO                        | Natural or custom priority     |
| Null Elements       | Allowed                     | Not allowed                    |
| Performance         | Slower for random access    | Fast priority-based operations |
| Use Case            | Simple FIFO queue           | Priority-based processing      |

---
