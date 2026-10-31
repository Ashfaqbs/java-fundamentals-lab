### How Java Code Executes (Step by Step)

1. **Write Code:**
   - Developer writes `.java` file.

2. **Compile Code:**
   - **Javac** (Java Compiler) converts the `.java` file into bytecode (`.class` file).

3. **Class Loading:**
   - **ClassLoader** loads the `.class` file into memory (method area).

4. **Bytecode Execution:**
   - JVM executes bytecode using:
     - **Interpreter:** Executes bytecode line-by-line.
     - **JIT Compiler:** Optimizes frequently executed code (hotspots) by converting it to native machine code.

5. **Memory Allocation:**
   - Objects are created in the heap.
   - References and local variables are stored in the stack.

6. **Runtime Execution:**
   - JVM manages method execution, memory, and garbage collection during runtime.

