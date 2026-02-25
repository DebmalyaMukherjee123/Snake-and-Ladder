package com.snakeandladder.game;

import com.snakeandladder.model.Ladder;
import com.snakeandladder.model.Snake;

import java.util.HashMap;
import java.util.Map;

public class Board {
    public static final int SIZE = 100;

    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    public Board() {
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        initializeSnakes();
        initializeLadders();
    }

    private void initializeSnakes() {
        snakes.put(99, 54);
        snakes.put(70, 55);
        snakes.put(52, 42);
        snakes.put(25, 2);
        snakes.put(95, 72);
        snakes.put(92, 73);
    }

    private void initializeLadders() {
        ladders.put(2, 38);
        ladders.put(7, 14);
        ladders.put(8, 31);
        ladders.put(15, 26);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(78, 98);
        ladders.put(71, 91);
    }

    /**
     * Returns the new position after applying any snake or ladder at the given position.
     * Returns the same position if there is no snake or ladder there.
     */
    public int applySnakeOrLadder(int position) {
        if (snakes.containsKey(position)) {
            return snakes.get(position);
        }
        if (ladders.containsKey(position)) {
            return ladders.get(position);
        }
        return position;
    }

    public boolean hasSnake(int position) {
        return snakes.containsKey(position);
    }

    public boolean hasLadder(int position) {
        return ladders.containsKey(position);
    }

    public int getSnakeTail(int position) {
        return snakes.get(position);
    }

    public int getLadderTop(int position) {
        return ladders.get(position);
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }
}
