package project;

import java.lang.reflect.Array;
import java.util.*;

public class tiktakto {

    static ArrayList<Integer> playerposs = new ArrayList<>();
    static ArrayList<Integer> cpuposs = new ArrayList<>();

    public static void main(String[] args) {

        char[][] gameboard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printgameboard(gameboard);
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Your Placement (1-9)");
            int playerpos = scan.nextInt();
            while(playerposs.contains(playerpos) || cpuposs.contains(playerpos)) {
                System.out.println("Postion Taken");
                playerpos = scan.nextInt();
            }
            placepiece(gameboard, playerpos, "Player");
            String result = checkwin();
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random ran = new Random();
            int cpupos = ran.nextInt(9) + 1;

            while(playerposs.contains(cpupos) || cpuposs.contains(cpupos)) {
                cpupos = ran.nextInt(9) + 1;
            }

            placepiece(gameboard, cpupos, "CPU");

            printgameboard(gameboard);

           result = checkwin();
           if(result.length() > 0) {
               System.out.println(result);
               break;
           }

        }
    }
            public static void printgameboard(char [][] gameboard) {
                for (char[] row : gameboard) {
                    for (char c : row) {
                        System.out.print(c);
                    }
                    System.out.println();

                }
            }

            public static void placepiece(char [][] gameboard, int pos, String user ){

        char sysbol = ' ';
            if(user.equals("Player")){
                    sysbol = 'X';
                    playerposs.add(pos);
                }
            else if(user.equals("CPU")){
                sysbol = '0';
                cpuposs.add(pos);
            }
                switch(pos){
                    case 1:
                        gameboard[0][0] = sysbol;
                        break;
                    case 2:
                        gameboard[0][2] = sysbol;
                        break;
                    case 3:
                        gameboard[0][4] = sysbol;
                        break;
                    case 4:
                        gameboard[2][0] = sysbol;
                        break;
                    case 5:
                        gameboard[2][2] = sysbol;
                        break;
                    case 6:
                        gameboard[2][4] = sysbol;
                        break;
                    case 7:
                        gameboard[4][0] = sysbol;
                        break;
                    case 8:
                        gameboard[4][2] = sysbol;
                        break;
                    case 9:
                        gameboard[4][4] = sysbol;
                        break;
                    default:
                        break;

                }
            }

            public static String checkwin(){
                List toprow = Arrays.asList(1, 2, 3);
                List midrow = Arrays.asList(4, 5, 6);
                List botrow = Arrays.asList(7, 8, 9);
                List lefcol = Arrays.asList(1, 4, 7);
                List midcol = Arrays.asList(2, 5, 8);
                List rigcol = Arrays.asList(3, 6, 9);
                List cross1 = Arrays.asList(3, 5, 7);
                List cross2 = Arrays.asList(1, 5, 9);

                List<List> winning = new ArrayList<>();
                winning.add(toprow);
                winning.add(midrow);
                winning.add(botrow);
                winning.add(lefcol);
                winning.add(midcol);
                winning.add(rigcol);
                winning.add(cross1);
                winning.add(cross2);

                    for(List l : winning){
                        if(playerposs.containsAll(l)) {
                            return "You WIN";
                        }
                        else if(cpuposs.containsAll(l)) {
                            return "Sorry CPU Win";
                        }
                        else if (playerposs.size() + cpuposs.size() == 9){
                            return "CAT";
                            }
                        }
                return "";
                    }
            }

