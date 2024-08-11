# Text Editor Command Pattern Example

This project demonstrates the Command Design Pattern through a simple text editor application. The editor supports basic text manipulation commands such as Copy, Cut, Paste, and Undo using the Command pattern.

## Project Structure

The project is organized into the following packages:

### Commands Package (`refactoring_guru.command.example.commands`)

1. **Command (abstract class)**
    - **Fields:**
        - `public Editor editor`: An instance of the `Editor` class, which provides access to the text area and clipboard.
        - `private String backup`: Stores a backup of the text before the command is executed.
    - **Constructor:**
        - `Command(Editor editor)`: Initializes the `editor` field with the provided `Editor` instance.
    - **Methods:**
        - `void backup()`: Saves the current text from the editor's text field to the `backup` field. This is used to restore the text if the command is undone.
        - `public void undo()`: Restores the text in the editor's text field to the last backed-up state.
        - `public abstract boolean execute()`: Executes the command. Must be implemented by subclasses to define the specific behavior of the command.

2. **CommandHistory**
    - **Fields:**
        - `private Stack<Command> history`: A stack that stores executed commands to support undo functionality.
    - **Methods:**
        - `public void push(Command c)`: Adds a command to the history stack.
        - `public Command pop()`: Removes and returns the most recent command from the history stack.
        - `public boolean isEmpty()`: Checks if the history stack is empty.

3. **CopyCommand**
    - **Constructor:**
        - `CopyCommand(Editor editor)`: Initializes the command with the provided `Editor` instance.
    - **Methods:**
        - `@Override public boolean execute()`: Copies the selected text from the editor's text field to the clipboard. Returns `false` indicating no text was changed in the text field (since copying does not modify the text).

4. **CutCommand**
    - **Constructor:**
        - `CutCommand(Editor editor)`: Initializes the command with the provided `Editor` instance.
    - **Methods:**
        - `@Override public boolean execute()`: Cuts the selected text from the editor's text field and saves it to the clipboard. It updates the text field to remove the cut text. Returns `true` if text was cut successfully, `false` otherwise.
        - `private String cutString(String source)`: Removes the selected text from the provided `source` string and returns the resulting string.

5. **PasteCommand**
    - **Constructor:**
        - `PasteCommand(Editor editor)`: Initializes the command with the provided `Editor` instance.
    - **Methods:**
        - `@Override public boolean execute()`: Pastes the text from the clipboard at the current caret position in the editor's text field. Returns `true` if text was pasted successfully, `false` otherwise.

### Editor Package (`refactoring_guru.command.example.editor`)

1. **Editor**
    - **Fields:**
        - `public JTextArea textField`: The text area where users can input and edit text.
        - `public String clipboard`: Stores the copied or cut text.
        - `private CommandHistory history`: Manages the history of commands for undo functionality.
    - **Methods:**
        - `public void init()`: Sets up the GUI with a text area and buttons for the commands. Adds action listeners to the buttons for executing commands and performing undo operations.
        - `private void executeCommand(Command command)`: Executes a given command and pushes it onto the history stack if the command was executed successfully.
        - `private void undo()`: Retrieves the most recent command from the history stack and calls its `undo` method to revert the last operation.

### Demo Package (`refactoring_guru.command.example`)

1. **Demo**
    - **Methods:**
        - `public static void main(String[] args)`: The entry point of the application. Creates an instance of the `Editor` class and initializes the GUI.

## Requirements

- **Java Development Kit (JDK) 8 or higher**: Ensure that you have JDK installed on your system.

## Setup and Run

Follow these steps to set up and run the project:

1. **Clone the Repository**

   Clone the repository to your local machine using Git:

   ```bash
   git clone <repository-url>
