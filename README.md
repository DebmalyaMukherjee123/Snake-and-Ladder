# Snake and Ladder

A fully functional Snake and Ladder board game playable via the command line, written in Java.

## Project Structure

```
src/
  main/
    java/
      com/
        snakeandladder/
          Main.java
          game/
            Game.java
            Board.java
            Dice.java
          model/
            Player.java
            Snake.java
            Ladder.java
README.md
```

## How to Compile and Run

### Prerequisites
- Java 8 or higher installed (`java -version` to verify)
- `javac` compiler available on your PATH

### Compile

From the project root directory, compile all source files:

```bash
find src -name "*.java" | xargs javac -d out
```

This will place the compiled `.class` files into the `out/` directory.

### Run

```bash
java -cp out com.snakeandladder.Main
```

## Gameplay

- **2 to 4 players** are supported.
- Players take turns rolling a six-sided dice.
- Players start **off the board** at position 0 and must reach **exactly position 100** to win.
- If a dice roll would take a player beyond 100, they **do not move**.
- Landing on a **snake's head** slides the player down to the snake's tail.
- Landing on the **bottom of a ladder** climbs the player up to the top.
- The **first player to reach exactly 100** wins.

## Snakes

| Head | Tail |
|------|------|
| 99   | 54   |
| 95   | 72   |
| 92   | 73   |
| 70   | 55   |
| 52   | 42   |
| 25   | 2    |

## Ladders

| Bottom | Top |
|--------|-----|
| 2      | 38  |
| 7      | 14  |
| 8      | 31  |
| 15     | 26  |
| 28     | 84  |
| 36     | 44  |
| 51     | 67  |
| 71     | 91  |
| 78     | 98  |

## Example Interaction

```
Welcome to Snake and Ladder!
How many players? (2-4): 2
Enter name for Player 1: Alice
Enter name for Player 2: Bob

Game started! First to reach position 100 wins!

--- Alice's Turn ---
Press Enter to roll the dice...
Alice rolled a 4! Moved from 0 to 4.

--- Bob's Turn ---
Press Enter to roll the dice...
Bob rolled a 3! Moved from 0 to 3.

--- Alice's Turn ---
Press Enter to roll the dice...
Alice rolled a 3! Moved from 4 to 7.
🪜 Ladder! Alice climbs from 7 to 14!

...

🎉 Alice wins the game! Congratulations! 🎉
```
