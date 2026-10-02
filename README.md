# Complex Number Scientific Calculator

![Java](https://img.shields.io/badge/Java-11%2B-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-20.0.1-4796DD?style=for-the-badge&logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.11-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

## 📖 Project Overview
This project is a **Scientific Programmable Calculator** designed to operate on **Complex Numbers** using a **Stack-based** (LIFO) architecture. It was developed as a Project Assignment for the *Software Engineering* course (Ingegneria del Software) at the University of Salerno.

The application allows users to input complex numbers (in Cartesian notation, e.g., `7.2+4.9j`) and perform operations directly on the stack. It features a modern Graphical User Interface (GUI) and supports advanced stack manipulation commands and variable storage mechanisms.

### ✨ Core Features
*   **Complex Numbers Support:** Full support for real and imaginary numbers.
*   **Stack-based Logic:** Operations take operands from the stack and push results back.
*   **Mathematical Operations:** Addition (`+`), Subtraction (`-`), Multiplication (`*`), Division (`/`), Square Root (`sqrt`), and Sign Inversion (`+-` or `inv`).
*   **Stack Manipulation:** `clear`, `drop`, `dup`, `swap`, `over`.
*   **Variable Storage:** 26 memory slots (variables `a` through `z`) with operations to save (`>x`), load (`<x`), add to (`+x`), and subtract from (`-x`) variables.

## 🛠️ Tech Stack
*   **Language:** Java (JDK 11)
*   **UI Framework:** JavaFX 20.0.1 (FXML for layout design)
*   **Build Tool:** Apache Maven
*   **Testing:** JUnit 5 (Jupiter)
*   **Architecture Pattern:** MVC (Model-View-Controller)

## 📁 Folder Structure

The project follows a standard Maven directory layout for modularity and separation of concerns:

```text
calculatorproject/
├── pom.xml                                 # Maven dependencies and build configuration
├── nbactions.xml                           # NetBeans specific run/debug actions
└── src/
    └── main/
        ├── java/
        │   ├── module-info.java            # Java Module definition
        │   └── calculatorproject/          # Root Java package
        │       ├── Calculator.java         # Core calculator engine/facade
        │       ├── CalculatorControllerView.java # JavaFX Controller
        │       ├── CalculatorGUI.java      # Application Main Entry Point
        │       ├── ComplexNumber.java      # Complex Number entity and logic
        │       ├── InputValidator.java     # Input parsing and validation
        │       ├── StackManager.java       # LIFO Stack data structure logic
        │       ├── Variable.java           # Variable entity
        │       ├── VariableManager.java    # Memory management (a-z variables)
        │       └── exceptions/             # Custom Runtime Exceptions
        │           ├── NotEnoughElementsException.java
        │           ├── StackIsEmptyException.java
        │           ├── StackIsFullException.java
        │           └── VariableIsEmptyException.java
        └── resources/
            └── calculatorproject/
                ├── Calculator_v2.fxml      # Main JavaFX GUI layout
                └── imgs/                   # UI Assets and Icons
```

## 🚀 Setup & Run Instructions

### Prerequisites
*   **Java Development Kit (JDK):** Version 11 or higher.
*   **Apache Maven:** Installed and added to your system's PATH.

### Installation & Execution
1. **Clone the repository** (or extract the project folder):
   ```bash
   git clone <repository_url>
   cd calculatorproject
   ```

2. **Clean and Compile the project:**
   Using Maven, you can resolve all dependencies (including JavaFX and JUnit) and compile the project.
   ```bash
   mvn clean compile
   ```

3. **Run the Application:**
   The project is configured with the `javafx-maven-plugin`. You can launch the GUI directly via Maven:
   ```bash
   mvn javafx:run
   ```

### Running Tests
To execute the JUnit 5 test suite and verify the business logic (Complex Number math, Stack operations, etc.):
```bash
mvn test
```

## 🧠 Architecture Highlights
As required by modern Software Engineering principles, the system is designed with **high cohesion** and **low coupling**:
*   **Model:** `ComplexNumber`, `StackManager`, and `VariableManager` encapsulate the core business rules completely independent of the UI.
*   **View:** The UI is declaratively built using FXML (`Calculator_v2.fxml`).
*   **Controller:** `CalculatorControllerView` handles the binding between user inputs (button clicks, keyboard events) and the underlying `Calculator` engine.
*   **Robustness:** Custom Exceptions (`NotEnoughElementsException`, `VariableIsEmptyException`, etc.) are implemented to handle edge cases gracefully without crashing the UI.

---
*Developed for the Software Engineering Course - Università degli Studi di Salerno (UNISA).*
