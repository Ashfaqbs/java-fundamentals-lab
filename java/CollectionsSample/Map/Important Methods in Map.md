
---

### **1. `getOrDefault(K key, V defaultValue)`**
This method returns the value associated with the key if it exists, or returns the default value if the key is not found.

#### **Example**:
```java
import java.util.HashMap;
import java.util.Map;

public class MapMethodsExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        // Using getOrDefault
        System.out.println(map.getOrDefault("A", 0)); // Output: 1
        System.out.println(map.getOrDefault("C", 0)); // Output: 0 (because "C" is not in the map)
    }
}
```
- **Explanation**: If "A" exists, its value (1) is returned. If "C" doesn't exist, the default value (0) is returned.

---

### **2. `computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)`**
This method computes the value for the key if it's not already present in the map. If the key is already present, it returns the existing value.

#### **Example**:
```java
import java.util.HashMap;
import java.util.Map;

public class MapMethodsExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);

        // Using computeIfAbsent
        map.computeIfAbsent("B", k -> k.length());  // If "B" is absent, calculate its value (length of "B")
        map.computeIfAbsent("A", k -> k.length());  // "A" already exists, so it won't recompute

        System.out.println(map); // Output: {A=1, B=1}
    }
}
```
- **Explanation**: The function `k -> k.length()` is applied to compute the value for the key "B" because it's absent, but for "A", since it's already present, no change is made.

---

### **3. `compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`**
This method computes a new value for the given key using the provided function. If the key is absent, a new value is computed and stored; if present, the existing value is passed to the function.

#### **Example**:
```java
import java.util.HashMap;
import java.util.Map;

public class MapMethodsExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);

        // Using compute
        map.compute("A", (key, value) -> value == null ? 0 : value + 10); // Increments value by 10
        map.compute("B", (key, value) -> 5); // Adds "B" with value 5

        System.out.println(map); // Output: {A=11, B=5}
    }
}
```
- **Explanation**: For key "A", the value was 1, and after `compute`, it was updated to 11. For "B", the value was calculated to 5.

---

### **4. `computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`**
This method updates the value for the key only if it is present in the map. If the key is not present, it does nothing.

#### **Example**:
```java
import java.util.HashMap;
import java.util.Map;

public class MapMethodsExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);

        // Using computeIfPresent
        map.computeIfPresent("A", (key, value) -> value + 5); // Increases value by 5
        map.computeIfPresent("B", (key, value) -> value + 5); // Does nothing because "B" is absent

        System.out.println(map); // Output: {A=15}
    }
}
```
- **Explanation**: Since "A" is present, its value is updated to 15, but nothing happens for "B" because it's not in the map.

---

### **5. `remove(Object key, Object value)`**
This method removes the entry for the specified key if it is currently mapped to the specified value. It returns `true` if the key-value pair was removed.

#### **Example**:
```java
import java.util.HashMap;
import java.util.Map;

public class MapMethodsExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        // Using remove with key-value
        System.out.println(map.remove("A", 1)); // Output: true (A=1 removed)
        System.out.println(map.remove("B", 3)); // Output: false (no such value for "B")

        System.out.println(map); // Output: {B=2}
    }
}
```
- **Explanation**: "A" is removed because its value matches the given value (1). "B" is not removed because its value does not match the provided value (3).

---

### **6. `forEach(BiConsumer<? super K,? super V> action)`**
This method performs the specified action for each entry in the map.

#### **Example**:
```java
import java.util.HashMap;
import java.util.Map;

public class MapMethodsExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Using forEach to print all key-value pairs
        map.forEach((key, value) -> System.out.println(key + " = " + value));
    }
}
```
- **Explanation**: This will print:
  ```
  A = 1
  B = 2
  C = 3
  ```

---

### **7. `replace(K key, V oldValue, V newValue)`**
This method replaces the entry for the specified key if the current value matches the given old value.

#### **Example**:
```java
import java.util.HashMap;
import java.util.Map;

public class MapMethodsExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);

        // Using replace with old and new values
        map.replace("A", 10, 15);  // "A" is replaced with 15
        map.replace("B", 25, 30);  // Does nothing because the old value doesn't match

        System.out.println(map); // Output: {A=15, B=20}
    }
}
```
- **Explanation**: "A" is replaced with 15 because its current value matches the old value (10), but "B" is not replaced because its value doesn't match the given old value (25).

---

### **Summary of Important Methods in `Map` Interface:**
- **getOrDefault(K key, V defaultValue)**: Returns the value or default if the key is absent.
- **computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)**: Computes and adds a value if the key is absent.
- **compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)**: Computes or updates the value for a key.
- **computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)**: Updates the value for an existing key.
- **remove(Object key, Object value)**: Removes the entry if the key-value pair matches.
- **forEach(BiConsumer<? super K,? super V> action)**: Applies the action to each entry.
- **replace(K key, V oldValue, V newValue)**: Replaces the value for the key if the old value matches.

---

These methods add significant flexibility and make `Map` operations more powerful, especially when dealing with collections that require frequent updates or condition-based processing.

---
