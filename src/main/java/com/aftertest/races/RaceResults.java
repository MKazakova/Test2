package com.aftertest.races;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class RaceResults {
    private HashMap<String, TimeDuration> results = new HashMap<>();

    public static void main(String ...args) {
        RaceResults rs = new RaceResults();
        rs.onNewResult("Tom Johnson", new TimeDuration(1200));
        rs.onNewResult("Pamela Stone", new TimeDuration(800));
        rs.onNewResult("Peter Stevenson", new TimeDuration(800));
        rs.onNewResult("Roy Bowers", new TimeDuration(1100));
        rs.onNewResult("Anne Tompson", new TimeDuration(970));
        rs.printResults();
    }

    public void onNewResult(String tagNumber, TimeDuration resultTime){
        results.put(tagNumber, resultTime);
    }

    public void printResults(){
    	TimeDuration  TimeMin = Collections.min(results.values(), (a, b)->a.getNbSeconds()-b.getNbSeconds());        	
    	int nbWinners = (int)results.entrySet()
                                        .stream()	
                                        .filter(a->a.getValue().equals(TimeMin))
                                        .count();

        String affichage = nbWinners>1?"We have "+nbWinners+" winners :\n":"The winner is ";
        System.out.print(affichage);
        for (Entry<String, TimeDuration> entry : results.entrySet()) {

            if (entry.getValue().equals(TimeMin)) {
                System.out.println(entry.getKey()+" with a result of "+entry.getValue());
            }
        }
        System.out.println("The results of other participants : ");
        results.entrySet()
                .stream()
                .filter(a->!a.getValue().equals(TimeMin))
                .sorted((t1, t2)->t1.getValue().getNbSeconds()-t2.getValue().getNbSeconds())
                .forEach(System.out::println);
    }
    

}
