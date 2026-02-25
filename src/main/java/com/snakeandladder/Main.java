package com.snakeandladder;

import com.snakeandladder.game.Game;
import com.snakeandladder.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Snake and Ladder!");

        int numPlayers = 0;
        while (numPlayers < 2 || numPlayers > 4) {
            System.out.print("How many players? (2-4): ");
            try {
                numPlayers = Integer.parseInt(scanner.nextLine().trim());
                if (numPlayers < 2 || numPlayers > 4) {
                    System.out.println("Please enter a number between 2 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 2 and 4.");
            }
        }

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                name = "Player " + i;
            }
            players.add(new Player(name));
        }

        System.out.println();
        Game game = new Game(players, scanner);
        game.start();

        scanner.close();
    }
}
