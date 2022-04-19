package project;

import java.util.Random;
import java.util.Scanner;

public class tiktakto {
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
            int pos = scan.nextInt();
            placepiece(gameboard, pos, "Player");

            Random ran = new Random();
            int cpupos = ran.nextInt(9) + 1;
            placepiece(gameboard, cpupos, "CPU");

            printgameboard(gameboard);

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
                }
            else if(user.equals("CPU")){
                sysbol = '0';
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
        }
