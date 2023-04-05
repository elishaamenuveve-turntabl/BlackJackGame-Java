package org.example.dummy;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        Wall myWall = new Wall();
//        try {
//            myWall.buildWall(-5);
//        } catch (Exception e) {
////            shkj
//        }


//        Map<String, Integer> stringToInt = new HashMap<>();
//        String two = new String("Two");
//        String two2 = new String("Two");
//        String two3 = new String("Two");
//
//        stringToInt.put("One", 1);
//        stringToInt.put(two, 2);
//        two = "two";
//        System.out.println(stringToInt.get(two));

//
//        two = "Two";
//        System.out.println(stringToInt.get(two));


        Map<Wall, Integer> wallToInt = new HashMap<>();
        Wall myWall = new Wall();
        Wall yourWall = new Wall();

        myWall.setNumberOfBricks(10);
        yourWall.setNumberOfBricks(20);

        wallToInt.put(myWall, 22);
        wallToInt.put(yourWall,33);

        System.out.println(wallToInt.get(myWall));
        System.out.println(wallToInt.get(yourWall));

        myWall.setNumberOfBricks(22222);

//        System.out.println(wallToInt.get(myWall));
//        System.out.println(wallToInt.get(yourWall));



    }
}
