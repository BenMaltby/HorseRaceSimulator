# 🐎 Horse Racing Simulator

A simple console-based Horse Racing Simulator written in Java. Users can set up a custom race, assign horses with unique names and attributes, and watch them compete in real-time!

## 🚀 Project Setup Instructions

Follow these steps to run the project locally:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/horse-racing-simulator.git
   cd horse-racing-simulator
   ```

2. **Compile the Java files**:  
   Ensure all `.java` files (`Main.java`, `Race.java`, `Horse.java`) are in the same directory. Then run:
   ```bash
   javac *.java
   ```

3. **Run the program**:
   ```bash
   java Main
   ```

## 📦 Dependencies

This project uses only standard Java libraries — no external dependencies required.

- **Java Version Required**: Java 8 or higher  
- **Tested on**: OpenJDK 11, Oracle JDK 17

> ✅ No installation of third-party libraries needed.

## 📝 Usage Guidelines

After launching the program (`java Main`), follow the interactive prompts to:

1. Set the **race length** (e.g., 20).
2. Choose the **number of lanes** (e.g., 3 to 5).
3. For each lane:
   - Enter the horse’s **name**
   - Enter a **symbol** (a single character like 🐎, X, etc.)
   - Enter the **confidence level** (between 0.0 and 1.0)
   - You can **leave the name blank** to skip assigning a horse to that lane

The race will begin and display progress in your terminal. Horses may **move**, **fall**, or **win**, and their **confidence adjusts based on performance**:

- ✅ Winning slightly **increases** confidence  
- ❌ Falling slightly **decreases** confidence

## 📂 Files Included

- `Main.java` – Entry point for the program and user interface.
- `Race.java` – Handles race logic, movement, and display.
- `Horse.java` – Defines the Horse class and performance behavior.

## 🤝 Contributions

Contributions are welcome! Feel free to fork the repo and submit a pull request with improvements.

## 📃 License

This project is open source and free to use for educational purposes.
