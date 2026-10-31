
###  Types of Memory in the Heap
The **heap** is divided into generations, each with a specific role for memory management.

#### **Heap Structure**
1. **Young Generation (Short-lived objects):**
   - **Eden Space:**
     - Newly created objects are allocated here.
     - Most objects die here (short-lived).
   - **Survivor Spaces (S0, S1):**
     - Objects that survive Minor GC in Eden are moved here.

2. **Old Generation (Long-lived objects):**
   - Objects promoted from the Young Generation after surviving multiple Minor GCs reside here.
   - Garbage collection here is triggered less frequently but takes longer.

3. **Metaspace (Post Java 8):**
   - Stores **class metadata** (e.g., loaded classes, methods).
   - Replaced the older **PermGen**.

4. **String Constant Pool (SCP):**
   - Special part of the heap for **interned strings**.
   - Ensures `String` objects are reused to save memory.

---

### **Where Do Objects Reside?**
1. **Objects:**
   - Always created in the **heap** (Eden Space initially).
   
2. **Primitive Variables:**
   - Stored in the **stack** or within objects in the heap.

3. **References to Objects:**
   - Stored in the **stack**.

---
