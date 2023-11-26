package ru.geekbrains.JDK_S06;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {
    private static final int NUMBER_GAMES = 10000;
    private static final int NUMBER_DOORS = 3;

    private static Map<Integer,Boolean> playersChangeDoors = new HashMap<>();
    private static Map<Integer,Boolean> playersNotChangeDoors = new HashMap<>();

    public static void main(String[] args) {
        TestMontyHallParadox testMontyHallParadox = new TestMontyHallParadoxImpl();

        IntStream.range(0,NUMBER_GAMES)
                .forEach(x -> playersChangeDoors
                        .put(x,testMontyHallParadox.fetchResultGame(NUMBER_DOORS,true)));

        IntStream.range(0,NUMBER_GAMES)
                .forEach(x -> playersNotChangeDoors
                        .put(x,testMontyHallParadox.fetchResultGame(NUMBER_DOORS,false)));


        System.out.println("Игроки меняют дверь");
        System.out.println(getStatistic(playersChangeDoors));
        System.out.println("Игроки не меняют дверь");
        System.out.println(getStatistic(playersNotChangeDoors));
    }

    private static String getStatistic(Map<Integer,Boolean> map) {
        int percent = NUMBER_GAMES/100;
        int countWin = Maps.filterEntries(map, Map.Entry::getValue).size();
        return String.format("Кол-во сыгранных игр: %d \nПроцент выигрыша: %d%%", NUMBER_GAMES, countWin/percent);
    }


}