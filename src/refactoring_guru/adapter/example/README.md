# Adapter Pattern Demo

This project demonstrates the **Adapter Pattern** to enable square pegs to fit into round holes. The Adapter Pattern is used to create a compatible interface between two incompatible interfaces.

## Task Description

1. **Implement the Adapter Pattern**:
    - **Adapter**: Create a class `SquarePegAdapter` that extends `RoundPeg` and adapts a `SquarePeg` to fit into a `RoundHole`. The adapter should compute the minimum radius required for the round hole to fit the square peg.
    - **SquarePeg**: This class represents a square peg with a width and a method to calculate its square area.
    - **RoundPeg**: This class represents a round peg with a radius.
    - **RoundHole**: This class represents a round hole with a radius and a method to check if a `RoundPeg` fits.

2. **Integrate the Adapter into Client Code**:
    - **Demo**: In the `Demo` class, demonstrate how the adapter allows a square peg to fit into a round hole. Show cases where direct fitting fails and how the adapter solves the problem.

## Project Structure

### Classes

- **RoundHole**: Represents a round hole with a specific radius.
    - `public RoundHole(double radius)`: Constructor to initialize the radius.
    - `public double getRadius()`: Returns the radius of the hole.
    - `public boolean fits(RoundPeg peg)`: Checks if the given round peg fits into the hole.

- **RoundPeg**: Represents a round peg with a specific radius.
    - `public RoundPeg(double radius)`: Constructor to initialize the radius.
    - `public double getRadius()`: Returns the radius of the peg.

- **SquarePeg**: Represents a square peg with a width.
    - `public SquarePeg(double width)`: Constructor to initialize the width.
    - `public double getWidth()`: Returns the width of the peg.
    - `public double getSquare()`: Returns the square area of the peg.

- **SquarePegAdapter**: Adapter that allows a `SquarePeg` to fit into a `RoundHole`.
    - `public SquarePegAdapter(SquarePeg peg)`: Constructor to initialize the adapter with a square peg.
    - `@Override public double getRadius()`: Calculates and returns the minimum radius of a round hole that can fit the square peg.

- **Demo**: Demonstrates the use of the Adapter Pattern.
    - `public static void main(String[] args)`: Main method to execute the demo. It shows how round pegs fit into round holes directly and how the adapter enables square pegs to fit.

## How It Works

1. **Direct Compatibility**:
    - A `RoundHole` can fit a `RoundPeg` directly without issues. This is demonstrated in the `Demo` class with a round peg that fits a round hole.

2. **Adapter Compatibility**:
    - `SquarePeg` cannot fit into a `RoundHole` directly. The `SquarePegAdapter` adapts the `SquarePeg` to be compatible with the `RoundHole` by calculating the required radius.
    - The `Demo` class shows how the adapter solves this problem, allowing a square peg to fit into a round hole where it would otherwise fail.

## Getting Started

### Prerequisites

Make sure you have the Java Development Kit (JDK) installed. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use a package manager for your operating system.

### Compilation

To compile the project, use the following command:

```bash
javac -d out src/refactoring_guru/adapter/example/**/*.java
