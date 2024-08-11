# Abstract Factory Pattern Demo

This project demonstrates the **Abstract Factory Pattern** for creating graphical user interface components (buttons and checkboxes) for different operating systems (MacOS and Windows).

## Task Description

1. **Implement the Abstract Factory Pattern**:
    - Define interfaces for `Button` and `Checkbox` that specify the common methods for these components.
    - Implement concrete classes for MacOS (`MacOSButton`, `MacOSCheckbox`) and Windows (`WindowsButton`, `WindowsCheckbox`) that adhere to these interfaces.
    - Create an abstract factory interface (`GUIFactory`) that includes methods for creating buttons and checkboxes.
    - Implement concrete factories for MacOS (`MacOSFactory`) and Windows (`WindowsFactory`) that create the respective components.

2. **Integrate with the Application**:
    - Develop an `Application` class that accepts a factory as a parameter and uses it to create and paint buttons and checkboxes.
    - Create a `Demo` class that selects the appropriate factory based on the system property `"os.name"` and runs the application.

## Project Structure

### Classes

- **Application**: The main class that uses the abstract factory to create and paint buttons and checkboxes.
- **Button**: Interface for buttons.
    - **MacOSButton**: Implementation of a button for MacOS.
    - **WindowsButton**: Implementation of a button for Windows.
- **Checkbox**: Interface for checkboxes.
    - **MacOSCheckbox**: Implementation of a checkbox for MacOS.
    - **WindowsCheckbox**: Implementation of a checkbox for Windows.
- **GUIFactory**: Abstract factory for creating buttons and checkboxes.
    - **MacOSFactory**: Concrete factory for MacOS.
    - **WindowsFactory**: Concrete factory for Windows.
- **Demo**: Class for demonstrating the abstract factory pattern. It selects the appropriate factory based on the operating system and paints the components.

## How It Works

1. The **Demo** class determines which factory to use based on the `"os.name"` system property.
2. An **Application** instance is created with the selected factory (either MacOS or Windows).
3. The **Application** uses the factory to create buttons and checkboxes and calls their `paint()` method to display them.

## Getting Started

### Prerequisites

Ensure you have Java Development Kit (JDK) installed. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or install it via a package manager for your operating system.

### Compilation

To compile the project, use the following command:

```bash
javac -d out src/refactoring_guru/abstract_factory/example/**/*.java
