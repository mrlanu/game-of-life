package life;

import java.util.Random;

public class Universe {

    private int size;
    private char[][] currentGeneration;
    private char[][] nextGeneration;

    public Universe(int size, Random random) {
        this.size = size;
        this.currentGeneration = new char[size][size];
        this.nextGeneration = new char[size][size];

        for (int y = 0; y < size; y++){
            for (int x = 0; x < size; x++){
                if(random.nextBoolean()){
                    currentGeneration[y][x] = 'O';
                }else currentGeneration[y][x] = ' ';
            }
        }
    }

    public void printCurrentGeneration(){
        for (int y = 0; y < this.size; y++){
            for (int x = 0; x < this.size; x++){
                System.out.print(this.currentGeneration[y][x]);
            }
            System.out.println();
        }
    }

    public void printNextGeneration(){
        for (int y = 0; y < this.size; y++){
            for (int x = 0; x < this.size; x++){
                System.out.print(this.nextGeneration[y][x]);
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public char[][] getCurrentGeneration() {
        return currentGeneration;
    }

    public void setCurrentGeneration(char[][] currentGeneration) {
        this.currentGeneration = currentGeneration;
    }

    public char[][] getNextGeneration() {
        return nextGeneration;
    }

    public void setNextGeneration(char[][] nextGeneration) {
        this.nextGeneration = nextGeneration;
    }
}
