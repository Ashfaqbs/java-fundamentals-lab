
###  How Does Garbage Collection Work?
Garbage collection (GC) in Java automatically manages memory by reclaiming unused objects in the heap. The process involves algorithms and phases. Here's the breakdown:

#### **How GC Works (Phases)**
1. **Mark Phase:**
   - The GC marks all objects reachable from the **root set** (e.g., global/static references, stack references, etc.).
   - Objects not marked as reachable are considered garbage.

2. **Sweep Phase:**
   - The GC reclaims memory occupied by unreachable objects.
   - This phase clears space for new objects.

3. **Compact Phase:**
   - To eliminate fragmentation, live objects are moved to a contiguous memory block.

#### **GC Algorithms**
1. **Serial GC** (Single-threaded, good for small applications):
   - Processes heap spaces sequentially (Eden, Survivor, Old).
   
2. **Parallel GC** (Multi-threaded, better for larger heaps):
   - Performs collection in multiple threads to improve speed.
   
3. **G1 GC (Garbage First GC)** (Default since Java 9):
   - Divides the heap into regions and prioritizes regions with most garbage.

4. **CMS GC (Concurrent Mark Sweep):** 
   - Reduces pause times by running GC alongside the application (deprecated in Java 14).

#### **When Does GC Trigger?**
- **Minor GC:** Happens in the **Young Generation** (Eden + Survivor spaces) to clean up short-lived objects.
- **Major/Full GC:** Cleans the **Old Generation**, involves compacting, and is more time-consuming.

