/*
 * Copyright (c) 2022-2022.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Viewer {


    public static void main(String[] args) {

        Application app = new Application();

        while (true) {
            app.askForPath();

            app.displayContents(app.getContents(app.getPath()));



        }

    }



}


class Application{

    private final String applicationVersion = "1.1";
    private File givenFile ;
    private final Scanner inputScanner;
    private Scanner fileScanner;
    private   String path;

    Application(){
            inputScanner = new Scanner(System.in);


     }

    public void askForPath(){

        System.out.println("Enter the path of the file you want to view, or type 'q' to quit.");
        boolean validPath = false;


        while (validPath == false ) {
             String input = inputScanner.nextLine();






                if (input.trim().equalsIgnoreCase("q")) {
                    quit();

                } else if (new File(input).exists()) {

                    path = input.trim();
                    givenFile = new File(path);
                    validPath = true;




                }else if(input.trim().equalsIgnoreCase("version")|| input.trim().equalsIgnoreCase("v")) {
                    System.out.println("Version: " + applicationVersion);
                }

                else {
                    System.out.println("Invalid path . Try again.");
                    path = input.trim();
                }

            }







    }







    public ArrayList<String> getContents(String path) {
         File fIleBuffer = new File(path);

        try {
            fileScanner = new Scanner(fIleBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> contents = new ArrayList<String>();

         while (fileScanner.hasNextLine()) {
             contents.add(fileScanner.nextLine());
         }
         return contents;





    }



    public void displayContents(ArrayList<String> contents) {
        System.out.println("________________________________________________________");
        System.out.println(" ");

      System.out.println(contents);
        System.out.println(" ");
        System.out.println("________________________________________________________");



    }

    public void quit(){
         System.out.println("Quitting.");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Bye!");
         System.exit(0);

    }


    public String getPath() {
        return path;
    }


}


/*VERSION : 1.1 - Added support for version information, cleaned up mess.



 */