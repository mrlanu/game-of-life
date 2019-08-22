package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int S = scanner.nextInt();

        Random random = new Random(S);

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if(random.nextBoolean()){
                    System.out.print("O");
                }else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
