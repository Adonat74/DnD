
# DnD-Like Java Game

A text-based role-playing game inspired by Dungeons & Dragons, implemented in Java. This project offers a console-based adventure where players can create characters, explore, battle, and interact within a fantasy world.

![alt text](image/Capture%20d’écran%20du%202024-11-06%2020-12-40.png)


## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies](#technologies)
- [Skills Developed](#skills-developed)
- [License](#license)

---

## Features

- **Character Creation**: Create custom characters with unique attributes and skills.
- **Exploration and Interaction**: Navigate through menus to explore different areas and interact with the game world.
- **Combat System**: Engage in turn-based combat with enemies, utilizing character abilities and items.
- **Persistence**: Save and load game states to maintain progress.
- **Error Handling**: Robust exception management for a smooth gaming experience.

---

## Project Structure

```
DnD
├── src
│   ├── Main.java                 # Entry point of the application
│   ├── character                 # Classes for player/NPC characters, attributes, skills
│   ├── db                        # Classes for data storage and retrieval
│   ├── exceptions                # Custom exception classes for error handling
│   ├── game                      # Core game mechanics, combat, and events
│   ├── menu                      # User interface and menu interactions
│   └── util                      # Utility classes for general-purpose methods
├── .gitignore                    # Git ignore file for sensitive data and build artifacts
├── README.md                     # Project documentation (this file)
└── DnD.iml                       # IntelliJ project file
```

---

## Installation

To get started with this project locally:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/DnD.git
   ```

2. **Open in IntelliJ IDEA**:
    - Open IntelliJ and select **File > Open**. Choose the project's root folder.
    - Ensure that all dependencies are configured correctly.

3. **Build the Project**:
    - Open **Build > Build Project** in IntelliJ to compile all classes.

---

## Usage

1. **Run the Application**:
    - In IntelliJ, open `Main.java` and run the main method to start the game.

2. **Navigate the Menu**:
    - Follow on-screen instructions to create your character, explore, engage in combat, and save your progress.

3. **Saving and Loading**:
    - The game automatically saves at specific points. You can also manually save and load using options in the main menu.

---

## Technologies

- **Java**: The core programming language used for the entire project.
- **JDBC (Java Database Connectivity)**: If the `db` package uses it, this allows for connecting to databases for saving/loading game states.
- **Object-Oriented Programming (OOP)**: Fundamental design pattern for game objects like characters, enemies, and menus.

---

## Skills Developed

Working on this project has strengthened the following skills:

- **Object-Oriented Design**: Applied OOP principles such as encapsulation, inheritance, and polymorphism to organize game components.
- **Java Exception Handling**: Created custom exceptions to manage game-specific errors smoothly, improving user experience.
- **Data Persistence**: Developed mechanisms for saving/loading game progress, enabling a continued game experience across sessions.
- **Modular Code Structure**: Organized code into packages (`character`, `db`, `game`, `menu`, `util`), following clean code principles and enhancing maintainability.
- **Designing Interactive Menus**: Implemented a user-friendly console-based UI for navigating through various game options.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---

This README serves as a foundational guide for developers and users interested in extending or playing the game. Enjoy the adventure!

--- 

Feel free to customize sections like the repository URL and license as needed. Let me know if you'd like further customization!