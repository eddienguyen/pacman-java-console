import java.util.Scanner;

public class Pacman {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map map = new Map();

        while (true){
            map.update();

            if (map.isWin()){
                System.out.println("YOU WON!!!");
                break;
            }
            if (map.isLose()){
                System.out.println("YOU LOSE!!!");
                break;
            }
            System.out.println("Your next move ?");
            map.playerMove(sc.nextLine());
            map.enemyMovement();


        }

    }
}
