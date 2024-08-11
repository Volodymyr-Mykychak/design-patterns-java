# Bridge Pattern Demo

This project demonstrates the **Bridge Pattern**, which separates an abstraction from its implementation, allowing the two to vary independently. In this example, we have a `Device` interface with two implementations (`Radio` and `TV`) and two types of remotes (`BasicRemote` and `AdvancedRemote`) to control the devices.

## Task Description

1. **Implement the Bridge Pattern**:
    - **Device**: This interface defines the operations that any device should support, such as enabling/disabling, setting volume/channel, and printing status.
    - **Radio** and **TV**: These classes implement the `Device` interface, each representing a different type of device with their specific behaviors.
    - **Remote**: This interface defines the operations for controlling devices.
    - **BasicRemote**: This class implements the `Remote` interface and provides basic control functionality.
    - **AdvancedRemote**: This class extends `BasicRemote` to add more functionality, such as muting the device.

2. **Integrate Devices and Remotes**:
    - **Demo**: In the `Demo` class, demonstrate how both `Radio` and `TV` devices can be controlled using `BasicRemote` and `AdvancedRemote`. Show how the bridge allows for flexibility in adding new devices or remotes without altering existing code.

## Project Structure

### Classes

- **Device**: Interface for devices that can be controlled by remotes.
    - `boolean isEnabled()`: Checks if the device is enabled.
    - `void enable()`: Enables the device.
    - `void disable()`: Disables the device.
    - `int getVolume()`: Returns the current volume of the device.
    - `void setVolume(int percent)`: Sets the volume of the device.
    - `int getChannel()`: Returns the current channel of the device.
    - `void setChannel(int channel)`: Sets the channel of the device.
    - `void printStatus()`: Prints the current status of the device.

- **Radio**: Implements the `Device` interface for a radio.
    - Includes methods for enabling/disabling, setting volume/channel, and printing status.

- **Tv**: Implements the `Device` interface for a TV.
    - Includes methods for enabling/disabling, setting volume/channel, and printing status.

- **Remote**: Interface for remote controls.
    - `void power()`: Toggles power on/off.
    - `void volumeDown()`: Decreases the volume.
    - `void volumeUp()`: Increases the volume.
    - `void channelDown()`: Decreases the channel.
    - `void channelUp()`: Increases the channel.

- **BasicRemote**: Implements the `Remote` interface for basic control of devices.
    - Provides functionality for toggling power, adjusting volume, and changing channels.

- **AdvancedRemote**: Extends `BasicRemote` to add advanced features such as muting.
    - `void mute()`: Mutes the device.

- **Demo**: Demonstrates how to use the `BasicRemote` and `AdvancedRemote` with different devices.
    - `public static void main(String[] args)`: Main method to execute the demo.

## How It Works

1. **Basic Remote Functionality**:
    - The `BasicRemote` can control both `Radio` and `TV` devices by interacting with their common `Device` interface. It provides basic operations such as toggling power, adjusting volume, and changing channels.

2. **Advanced Remote Functionality**:
    - The `AdvancedRemote` builds on the functionality of `BasicRemote` by adding additional features such as muting. It demonstrates how new functionality can be introduced without modifying existing device or remote code.

3. **Flexibility and Extensibility**:
    - The Bridge Pattern allows for adding new types of devices or remotes without changing existing code. New device implementations can be introduced and controlled by existing remotes or new remotes can be created to control existing devices.

## Getting Started

### Prerequisites

Make sure you have the Java Development Kit (JDK) installed. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use a package manager for your operating system.

### Compilation

To compile the project, use the following command:

```bash
javac -d out src/refactoring_guru/bridge/example/**/*.java
