# **Processor Execution Simulator**

## Project Overview:
This project aims to build a simulator that models the execution of tasks by processors in a synchronized environment. The simulation will mimic the real-world behavior of processors executing tasks, with priorities and scheduling rules to determine how tasks are assigned to available processors. The simulator handles task creation, assignment, and execution, while adhering to clock cycles and priority constraints.

## Objectives:
- Simulate the execution of tasks by a fixed number of processors, ensuring synchronization across all processors.
- Implement a scheduling mechanism that assigns tasks to processors based on priority and execution time.
- Provide a detailed cycle-by-cycle report on the state of the system, including task creation, execution, and completion.
- Allow flexibility in the number of processors and clock cycles for the simulation.

## Key Features:
1. **Processor Configuration**:
   - The simulator operates with a fixed number of processors, synchronized by a single clock. Each processor is assigned a unique identifier (e.g., P1, P2, P3).
   
2. **Task Management**:
   - Tasks are represented with unique identifiers (e.g., T1, T2, T3) and are described by three parameters: 
     - Creation time: when the task is created
     - Execution time: the number of clock cycles required to complete the task
     - Priority: either high (1) or low (0).
   - Tasks are added to a queue when they are created and wait for processor availability.

3. **Task Scheduling**:
   - The simulator includes a scheduler that determines which tasks are assigned to available processors.
   - High-priority tasks are assigned first, and in the case of a tie (i.e., multiple high-priority tasks), the task with the longest execution time is chosen. If a tie persists, a task is chosen at random.
   - Similarly, low-priority tasks are handled in the same manner when no high-priority tasks are available.

4. **Task Execution**:
   - Processors can only execute one task at a time. Once a task is assigned to a processor, it cannot be interrupted and must complete execution before the processor becomes available for a new task.
   - Task creation time is considered negligible, allowing for immediate assignment to an available processor in the same clock cycle as creation.

5. **Simulator Input**:
   - The simulator accepts three input arguments:
     1. **Number of processors**: An integer that defines the number of processors in the system.
     2. **Total clock cycles**: An integer that specifies the total number of clock cycles for the simulation.
     3. **Task input file**: A string that contains the path to the text file with task details (creation time, execution time, and priority).

6. **Simulator Output**:
   - The simulator produces a readable cycle-by-cycle report detailing important events, such as:
     - Tasks created, executed, and completed
     - The state of each processor (busy or idle).
   - The report is printed directly to the console, offering a clear and simple view of the simulation process.
