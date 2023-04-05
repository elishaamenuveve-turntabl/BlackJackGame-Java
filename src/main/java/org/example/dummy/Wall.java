package org.example.dummy;

import java.util.NoSuchElementException;

public class Wall {
    private int numberOfBricks;

    public void buildWall (int numberOfBricks) throws Exception{
        if (numberOfBricks > 0){
            build();
        } else {
            throw new NoSuchElementException("Can't build with negative");
        }
    }

    public int getNumberOfBricks() {
        return numberOfBricks;
    }

    public void setNumberOfBricks(int numberOfBricks) {
        this.numberOfBricks = numberOfBricks;
    }

    private void build() {
        System.out.println("Building wall...");
    }
}
