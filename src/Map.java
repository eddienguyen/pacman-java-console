import java.util.Random;

public class Map {
    public static final int MAP_WIDTH = 5;
    public static final int MAP_HEIGHT = 5;
    public static final String LEFT = " < ";
    public static final String RIGHT = " > ";
    public static final String UP = " ^ ";
    public static final String DOWN = " V ";
    public String direction;

    public int playerX = 2;
    public int playerY = 2;

    public int e1X = 0;
    public int e1Y = 0;

    Random rd = new Random();

    public boolean a[][] = new boolean[MAP_WIDTH][MAP_HEIGHT];

    public Map() {
        direction = LEFT;

//        for (int y = 0; y < MAP_HEIGHT; y++) {
//            for (int x = 0; x < MAP_WIDTH; x++) {
//                a[x][y] = false;
//            }
//        }
    }

    public void update() {

        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                if (x == playerX && y == playerY) {
                    a[x][y] = true;
                    switch (direction) {
                        case UP:
                            System.out.print(UP);
                            break;
                        case DOWN:
                            System.out.print(DOWN);
                            break;
                        case LEFT:
                            System.out.print(LEFT);
                            break;
                        case RIGHT:
                            System.out.print(RIGHT);
                            break;
                    }
                } else if (x == e1X && y == e1Y) {
                    System.out.print(" E ");
                } else if (a[x][y] == true) {
                    System.out.print(" . ");
                } else {
                    System.out.print(" + ");
                }
            }
            System.out.println();
        }
    }

    public void generateObjectPositions() {

    }

    public void playerMove(String s) {
        switch (s) {
            case "w":
                if (playerY == 0) {
                    playerY = 0;
                } else {
                    playerY--;
                }
                direction = UP;
                break;
            case "s":
                if (playerY == MAP_HEIGHT - 1) {
                    playerY = MAP_HEIGHT - 1;
                } else {
                    playerY++;
                }
                direction = DOWN;
                break;
            case "a":
                if (playerX == 0) {
                    playerX = 0;
                } else {
                    playerX--;
                }
                direction = LEFT;
                break;
            case "d":
                if (playerX == MAP_WIDTH - 1) {
                    playerX = MAP_WIDTH - 1;
                } else {
                    playerX++;
                }
                direction = RIGHT;
                break;
        }
    }

    public boolean isWin() {
        int count = 0;
        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                if (a[x][y] == true) {
                    count++;
                }
            }
        }
        if (count == (a.length * a[0].length)) {
            return true;
        } else {
            return false;
        }
    }

    public void enemyMovement() {
        int randomIndex = rd.nextInt(4);
        switch (randomIndex) {
            case 0:
                if (e1Y == 0) {
                    e1Y = 0;
                } else {
                    e1Y--;
                }
                break;
            case 1:
                if (e1Y == MAP_HEIGHT - 1) {
                    e1Y = MAP_HEIGHT - 1;
                } else {
                    e1Y++;
                }
                break;
            case 2:
                if (e1X == 0) {
                    e1X = 0;
                } else {
                    e1X--;
                }
                break;
            case 3:
                if (e1X == MAP_WIDTH - 1) {
                    e1X = MAP_WIDTH - 1;
                } else {
                    e1X++;
                }
                break;
        }
    }

    public boolean isLose() {
        return (playerX == e1X && playerY == e1Y);
    }
}
