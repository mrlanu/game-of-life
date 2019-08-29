package life;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //System.out.println("PRINT ----->>>>> ");
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int M = scanner.nextInt();

        //System.out.println("S = " + S);
        Random random = new Random(S);

        Universe universe = new Universe(N, random);
        //universe.printCurrentGeneration();
        if (M == 0){
            universe.printCurrentGeneration();
        } else {
            for (int i = 0; i < M; i++) {
                getNextGeneration(universe);
            }
            universe.printNextGeneration();
        }
        //System.out.println("NEXT");
        //universe.printCurrentGeneration();
    }

    public static void getNextGeneration(Universe universe){
        char[][] currGen = universe.getCurrentGeneration();
        int neighbours = 0;
        for (int i = 0; i < currGen.length; i++){
            for (int j = 0; j < currGen[0].length; j++){
                for (int y = -1 + i; y <= 1 + i; y++){
                    for (int x = -1 + j; x<=1 + j; x++){
                        int x2 = x;
                        int y2 = y;
                        if (x == j && y == i)continue;
                        if(x < 0)x2 = currGen[0].length - 1;
                        if(x > currGen[0].length - 1)x2 = 0;
                        if(y < 0)y2 = currGen.length - 1;
                        if(y > currGen.length-1)y2 = 0;
                        if (currGen[y2][x2] == 'O')neighbours++;
                    }
                }
                if (currGen[i][j] == 'O'){
                    if (neighbours == 2 || neighbours == 3){
                        universe.getNextGeneration()[i][j] = 'O';
                        } else {
                            universe.getNextGeneration()[i][j] = ' ';
                            }
                    }else {
                            if (neighbours == 3) {
                            universe.getNextGeneration()[i][j] = 'O';
                                }else {
                                    universe.getNextGeneration()[i][j] = ' ';
                                }
                        }
                neighbours = 0;
            }
        }

        rewriteNextToCurrent(universe);
    }

    private static void rewriteNextToCurrent(Universe universe) {
        for (int i = 0; i < universe.getCurrentGeneration().length; i++) {
            for (int j = 0; j < universe.getCurrentGeneration()[0].length; j++) {
                universe.getCurrentGeneration()[j][i] = universe.getNextGeneration()[j][i];
            }
        }
    }
}
