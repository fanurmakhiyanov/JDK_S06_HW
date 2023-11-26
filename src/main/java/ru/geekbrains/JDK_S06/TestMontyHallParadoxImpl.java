package ru.geekbrains.JDK_S06;

import java.util.Random;
import java.util.stream.IntStream;

public class TestMontyHallParadoxImpl implements TestMontyHallParadox{
    private static final Random RANDOM = new Random();
    private static final int CAR_BEHIND_DOOR = 1;
    private static final int GOAT_BEHIND_DOOR = 0;

    public boolean fetchResultGame(int numberDoors, boolean playersChangeDoor) {
        int[] doors = initialDoorsToGame(numberDoors);
        int indexSelectedDoor = RANDOM.nextInt(numberDoors);
        if (playersChangeDoor) {
            indexSelectedDoor = numberDoors - indexSelectedDoor - findIndexDoorWithGoat(doors, indexSelectedDoor);
        }
        return doors[indexSelectedDoor] == CAR_BEHIND_DOOR;
    }

    private static int findIndexDoorWithGoat(int[] doors, int indexSelectedDoor) {
        return IntStream.range(0, doors.length)
                .filter(x -> x != indexSelectedDoor && doors[x] == GOAT_BEHIND_DOOR)
                .findAny().getAsInt();
    }

    private static int[] initialDoorsToGame(int size) {
        int[] doors = new int[size];
        doors[RANDOM.nextInt(size)] = CAR_BEHIND_DOOR;
        return doors;
    }
}