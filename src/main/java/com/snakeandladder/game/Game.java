package com.snakeandladder.game;

import com.snakeandladder.model.Player;

import java.util.List;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final Dice dice;
    private final List<Player> players;
    private final Scanner scanner;

    public Game(List<Player> players, Scanner scanner) {
        this.board = new Board();
        this.dice = new Dice();
        this.players = players;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("\nGame started! First to reach position 100 wins!\n");
        Player winner = null;

        while (winner == null) {
            for (Player player : players) {
                System.out.println("--- " + player.getName() + "'s Turn ---");
                System.out.print("Press Enter to roll the dice...");
                scanner.nextLine();

                int roll = dice.roll();
                int oldPosition = player.getPosition();
                int newPosition = oldPosition + roll;

                if (newPosition > Board.SIZE) {
                    System.out.println(player.getName() + " rolled a " + roll
                            + "! Cannot move — roll would exceed 100. Stays at " + oldPosition + ".");
                } else {
                    player.setPosition(newPosition);
                    System.out.println(player.getName() + " rolled a " + roll
                            + "! Moved from " + oldPosition + " to " + newPosition + ".");

                    if (board.hasSnake(newPosition)) {
                        int tail = board.getSnakeTail(newPosition);
                        player.setPosition(tail);
                        System.out.println("🐍 Snake! " + player.getName()
                                + " slides down from " + newPosition + " to " + tail + "!");
                    } else if (board.hasLadder(newPosition)) {
                        int top = board.getLadderTop(newPosition);
                        player.setPosition(top);
                        System.out.println("🪜 Ladder! " + player.getName()
                                + " climbs from " + newPosition + " to " + top + "!");
                    }

                    if (player.getPosition() == Board.SIZE) {
                        winner = player;
                        break;
                    }
                }
                System.out.println();
            }
        }

        System.out.println("🎉 " + winner.getName() + " wins the game! Congratulations! 🎉");
    }
}
