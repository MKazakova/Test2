package com.aftertest.races;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RaceResults {

    private HashMap<String, Integer> results = new HashMap<>();

    public static void main(String ...args) {
        RaceResults rs = new RaceResults();
        rs.onNewResult("1524", new TimeDuration(1200));
        rs.onNewResult("1557", new TimeDuration(800));
        rs.onNewResult("9000", new TimeDuration(1100));
        rs.printResults();
    }

    public void onNewResult(String tagNumber, TimeDuration resultTime){
        results.put(tagNumber, resultTime.getNbSeconds());
    }

    public void printResults(){
        for (Entry<String, Integer> entry : results.entrySet()) {
        	int nbWinners = 0;
            if (entry.getValue()==Collections.min(results.values())) {
                if(nbWinners==0) System.out.println("The winner is "+entry.getKey());
                else System.out.println("Another winner is "+entry.getKey());
                nbWinners++;
            }
        }
        System.out.println("All the results : ");
        results.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }
}
