package com.company;

import java.util.ArrayList;
import java.util.Random;
/**
 * Created by raz on 3/23/15.
 */



public class Gameboard {


    public class Ship {
        public String name;
        public String acronym;
        public int health;

        public Ship(String name, String acronym, int health){
            this.name = name;
            this.health = health;
            this.acronym = acronym;
        }

    }
    // To Change game time
    private int totalHealth = 22;
    private int AirCraft = 5;
    private int BattleShip = 4;
    private int Sub = 3;
    private int Destroyer1 = 3;
    private int Destroyer2 = 3;
    private int PTBoat1 = 2;
    private int PTBoat2 = 2;



    String grid[][];
    String grid2[][];
    ArrayList<Ship> ships;



    public Gameboard(){

        // add ships
        ships = new ArrayList<Ship>();
        ships.add(new Ship("Aircraft Carrier", "A1", 5));
        ships.add(new Ship("Battleship","B2", 4));
        ships.add(new Ship("Sub","S3", 3));
        ships.add(new Ship("Destroyer", "D4", 3));
        ships.add(new Ship("Destroyer", "D5", 3));
        ships.add(new Ship("PT Boat", "P6", 2));
        ships.add(new Ship("PT Boat", "P7", 2));




        grid  = new String[10][10];
        grid2  = new String[10][10];
        // first initialize game board to be empty
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                grid[i][j] = "o";
            }
        }
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                grid2[i][j] = "o";
            }
        }

        Random rand = new Random();
        for (Ship ship: ships){
            addShip(ship.acronym, ship.health, rand);
        }
    }

    public void displayBoard(){
        String[] rows = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        System.out.print("     ");
        for (int i = 0; i < 10; i++){
            System.out.printf("%3s  ", i + 1);
        }
        System.out.println();

        for (int i = 0; i < 10; i++){
            System.out.printf("%3s  ", rows[i]);
            for (int j = 0; j < 10; j++){
                System.out.printf("%3s  ", grid[i][j]);
            }
            System.out.println();
        }

    }

    public void addShip(String name, int size, Random rand) {
        boolean positionGood = false;
        String orientation   = "";
        int column= 0;
        int row = 0;
        while (!positionGood) {
            row = rand.nextInt(10);
            column = rand.nextInt(10);
            orientation = "horizontal";
            if (rand.nextInt(10) < 5) {
                orientation = "vertical";
            }
            positionGood = checkPosition(row, column, orientation, size);
        }
        if (orientation.equals("horizontal")){
            for (int  i =  column; i < column + size; i++){
                grid[row][i] = name;
            }
        }
        else{
            for (int  i =  row; i < row + size; i++){
                grid[i][column] = name;
            }


        }
    }

    public boolean checkPosition(int row, int column, String direction, int size){
        if (direction.equals("vertical")){
            if (row + size < 10){
                for (int i = row; i < row + size; i++){
                    if (!(grid[i][column].equals("o"))){
                        return false;
                    }

                }
                return true;
            }
            else {
                return false;
            }
        }
        else{
            if (column + size < 10){
                for (int i = column; i < column + size; i++){
                    if (!(grid[row][i].equals("o"))) {
                        return false;
                    }
                }
                return true;
            }
            else{
                return false;
            }
        }

    }


    public boolean isWin()
    {
        // should return true if the person won
        // the game; false otherwise
        if(totalHealth == 0)
        {
            System.out.println("Congrats You Won!");
            System.exit(0);
        }
        return false;

    }

    public void drawPlayerBoard(){

        // This will be based on the displayBoard method above
        // it should hid the location of ships
        // and show misses and hits
        // add ships
        String[] rows = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        System.out.print("     ");
        for (int i = 0; i < 10; i++){
            System.out.printf("%3s  ", i + 1);
        }
        System.out.println();

        for (int i = 0; i < 10; i++){
            System.out.printf("%3s  ", rows[i]);
            for (int j = 0; j < 10; j++){
                System.out.printf("%3s  ", grid2[i][j]);
            }
            System.out.println();
        }
    }

    public void move(String shoot){


        int j = shoot.codePointAt(0)-65;
        int i = shoot.codePointAt(1)-49;
        if(grid2[j][i] == "/" || grid2[j][i] == "x")
        {
            System.out.println("You Already made a move here");
            System.out.println("Please make a different move");

        }
        if(grid[j][i]!= "o" && grid2[j][i] != "x")
        {
            System.out.println("HIT");
            grid2[j][i] = grid[j][i];
            grid2[j][i]="x";
            totalHealth = totalHealth - 1;

            if(grid[j][i] == "A1")
            {
                if(AirCraft == 1)
                {
                    System.out.println("You Sunk a Aircraft Carrier");
                }
                AirCraft = AirCraft - 1;
            }
            if(grid[j][i] == "B2")
            {
                if(BattleShip == 1)
                {
                    System.out.println("You Sunk a Battleship");
                }
                BattleShip = BattleShip - 1;
            }
            if(grid[j][i] == "S3")
            {
                if(Sub == 1) {
                    System.out.println("You Sunk a Submarine");
                }
                Sub = Sub - 1;
            }
            if(grid[j][i] == "D4")
            {
                if(Destroyer1 == 1)
                {
                    System.out.println("You Sunk a Destroyer");
                }
                Destroyer1 = Destroyer1 - 1;

            }
            if(grid[j][i] == "D5")
            {
                if(Destroyer2 == 1)
                {
                    System.out.println("You Sunk a Destroyer");
                }
                Destroyer2 = Destroyer2 - 1;
            }
            if(grid[j][i] == "P6")
            {
                if(PTBoat1 == 1)
                {
                    System.out.println("You Sunk a PT Boat");
                }
                PTBoat1 = PTBoat1 - 1;
            }
            if(grid[j][i] == "P7")
            {
                if(PTBoat2 == 1)
                {
                    System.out.println("You Sunk a Pt Boat");
                }
                PTBoat2 = PTBoat2 - 1;
            }

        }
        else if(grid[j][i] == "o" && grid2[j][i] != "/" )
        {
            System.out.println("Miss");
            grid2[j][i] = grid[j][i];
            grid2[j][i] = "/";
        }



    }

    public boolean play()
    {
        // while not a win play the game
        if(totalHealth == 0)
        {
            System.exit(0);
        }
        return true;
    }

}
