import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Random;
import java.util.Scanner;

/**
 * Description: CS180 Fall 2017 Project 1 - Skeleton Code
 *
 * @author Sam Yap, syap
 * @author Joshua Chambers, chambe41
 * @version 7/27/17.
 */

public class MurderMystery {

    private final static String round1Banner = "========== Round 1 ==========";
    private final static String round2Banner = "========== Round 2 ==========";
    private final static String round3Banner = "========== Round 3 ==========";
    private final static String string1 = "Things found at crime scene:";
    static String[] objects= new String[5];
    static String[] people=new String[5];


    public static void main(String[] args) {

        objects[0]="Stethoscope";
        people[0]="Doctor";
        objects[1]="Dirty mop";
        people[1]="Janitor";
        objects[2]="High-quality pen";
        people[2]="Journalist";
        objects[3]="Rolex watch";
        people[3]="Rich Person";
        objects[4]="Lecture material";
        people[4]="Professor";

        String[] notes = new String[6];
        notes[0] = "pharmacy";
        notes[1] = "closet";
        notes[2] = "newspaper";
        notes[3] = "doller";
        notes[4] = "college";

        int seed = 49238;
        Random r = new Random(seed);
        Scanner s = new Scanner(System.in);
        String noChoice="n";
        do{

            //int Doctor=0; int Janitor=1; int Journalist=2; int RichPerson=3; int Professor=4;
            System.out.println(round1Banner);
            int killer=r.nextInt(5);
            int player1=r.nextInt(5);
            while(killer==player1){
                player1=r.nextInt(5);
            }
            int player2=r.nextInt(5);
            while(killer==player2 || player1==player2){
                player2=r.nextInt(5);
            }
            int player3=r.nextInt(5);
            while(killer==player3 || player2==player3 || player1==player3){
                player3=r.nextInt(5);
            }
            int player4=r.nextInt(5);
            while(killer==player4 || player2==player3 || player1==player4 || player3==player4){
                player4=r.nextInt(5);
            }

            System.out.println(string1);



            //******** PART 1 **********//

            int a=1;
            for(int i=0;i<objects.length;i++){
                if (i!=player1){
                    System.out.println(a+"."+" "+objects[i]);
                    a++;
                }
            }
            boolean part1=true;
            System.out.println("Who do you no longer suspect?");
            for(int i=0;i<people.length;i++){
                System.out.println(i+" -"+" "+people[i]);
            }
            int firstChoice=s.nextInt();
            if (firstChoice==(player1)){
                System.out.println("Cleared: "+people[player1]);
            }else if(firstChoice==-1){
                return;
            }else{
                System.out.println("The murderer sneaks up on you and kills you when you are alone... \nYou lost!");

                int testLoop=0;
                while (testLoop==0) {
                    System.out.println("Do you want to play again? ");
                    s.nextLine();
                    noChoice = s.nextLine();
                    if (noChoice.equals("y") || noChoice.equals("n")) {
                        testLoop = 1;
                    } else {
                        System.out.println("Please enter y/n!");
                    }
                }
                if (noChoice.equals("y") && noChoice.length() == 1){
                    continue;
                }else {return;}
            }

            //******END OF PART 1***********//

            System.out.println(round2Banner);
            System.out.println("All suspects claim that the items found at the crime scene do not belong to any of them...");

            boolean Doctor1=r.nextBoolean();
            boolean Doctor2=r.nextBoolean();
            boolean Doctor3=r.nextBoolean();

            boolean Janitor1=r.nextBoolean();
            boolean Janitor2=r.nextBoolean();
            boolean Janitor3=r.nextBoolean();

            boolean Journalist1=r.nextBoolean();
            boolean Journalist2=r.nextBoolean();
            boolean Journalist3=r.nextBoolean();

            boolean RichPerson1=r.nextBoolean();
            boolean RichPerson2=r.nextBoolean();
            boolean RichPerson3=r.nextBoolean();

            boolean Professor1=r.nextBoolean();
            boolean Professor2=r.nextBoolean();
            boolean Professor3=r.nextBoolean();

            boolean checkProfessor1=true;
            boolean checkProfessor2=true;

            boolean checkJanitor1=true;
            boolean checkJanitor2=true;

            boolean checkJournalist1=true;
            boolean checkJournalist2=true;

            boolean checkRichPerson1=true;
            boolean checkRichPerson2=true;

            boolean checkDoctor1=true;
            boolean checkDoctor2=true;

            boolean fourKiller =r.nextBoolean();

            String yesChoice="y";
            do{
                System.out.println("Who would like to question?");
                for(int i=0;i<people.length;i++){
                    System.out.println(i+" -"+" "+people[i]);
                }
                firstChoice=s.nextInt();
                if(firstChoice==player1){
                    System.out.println("This person has already been eliminated! Please choose someone else!");
                    continue;
                }else if (firstChoice==-1){return;}

                String[] Output={"Did you know the victim?",
                        "Did you suspect something sinister was going on?",
                        "Were you awake during the time of the murder?","Do you own a " + objects[firstChoice],
                        "Can you show us the "+objects[firstChoice]+" right now?"};

                System.out.println("What would you like to ask?");
                for (int i = 0; i < 5; i++) {
                    System.out.println(i + " - " + Output[i]);
                }
                int theQuestions=s.nextInt();

                if (theQuestions==-1){return;}

                if(firstChoice==0){
                    if(theQuestions==0){
                        System.out.println("Answer: "+Doctor1);
                    }else if(theQuestions==1){
                        System.out.println("Answer: "+Doctor2);
                    }else if(theQuestions==2) {
                        System.out.println("Answer: "+Doctor3);
                    }else if(theQuestions==3) {
                        if(fourKiller){
                            if (0==killer){
                                checkDoctor1=false;
                                System.out.println("Answer: "+checkDoctor1);
                            }else{
                                System.out.println("Answer: "+checkDoctor1);
                            }
                        }else{
                            if (0==player4){
                                checkDoctor1=false;
                                System.out.println("Answer: "+checkDoctor1);
                            }else{
                                System.out.println("Answer: "+checkDoctor1);
                            }
                        }
                    }else if(theQuestions==4) {
                        if(fourKiller){
                            if (0==player4){
                                checkDoctor2=false;
                                System.out.println("Answer: "+checkDoctor2);
                            }else{
                                System.out.println("Answer: "+checkDoctor2);
                            }
                        }else {
                            if (0 == killer) {
                                checkDoctor2 = false;
                                System.out.println("Answer: " + checkDoctor2);
                            } else {
                                System.out.println("Answer: " + checkDoctor2);
                            }
                        }
                    }
                }

                if(firstChoice==1){
                    if(theQuestions==0){
                        System.out.println("Answer: "+Janitor1);
                    }else if(theQuestions==1){
                        System.out.println("Answer: "+Janitor2);
                    }else if(theQuestions==2) {
                        System.out.println("Answer: "+Janitor3);
                    }else if(theQuestions==3) {
                        if(fourKiller){
                            if (1==killer){
                                checkJanitor1=false;
                                System.out.println("Answer: "+checkJanitor1);
                            }else{
                                System.out.println("Answer: "+checkJanitor1);
                            }
                        }else {
                            if (1 == player4) {
                                checkJanitor1 = false;
                                System.out.println("Answer: " + checkJanitor1);
                            } else {
                                System.out.println("Answer: " + checkJanitor1);
                            }
                        }
                    }else if(theQuestions==4) {
                        if(fourKiller){
                            if (1==player4){
                                checkJanitor2=false;
                                System.out.println("Answer: "+checkJanitor2);
                            }else{
                                System.out.println("Answer: "+checkJanitor2);
                            }
                        }else {
                            if (1 == killer) {
                                checkJanitor2 = false;
                                System.out.println("Answer: " + checkJanitor2);
                            } else {
                                System.out.println("Answer: " + checkJanitor2);
                            }
                        }
                    }
                }

                if(firstChoice==2) {
                    if (theQuestions == 0) {
                        System.out.println("Answer: "+Journalist1);
                    } else if (theQuestions == 1) {
                        System.out.println("Answer: "+Journalist2);
                    } else if (theQuestions == 2) {
                        System.out.println("Answer: "+Journalist3);
                    } else if (theQuestions == 3) {
                        if(fourKiller){
                            if (2==killer){
                                checkJournalist1=false;
                                System.out.println("Answer: "+checkJournalist1);
                            }else{
                                System.out.println("Answer: "+checkJournalist1);
                            }
                        }else {
                            if (2 == player4) {
                                checkJournalist1 = false;
                                System.out.println("Answer: " + checkJournalist1);
                            } else {
                                System.out.println("Answer: " + checkJournalist1);
                            }
                        }
                    } else if (theQuestions == 4) {
                        if(fourKiller){
                            if (2==player4){
                                checkJournalist2=false;
                                System.out.println("Answer: "+checkJournalist2);
                            }else{
                                System.out.println("Answer: "+checkJournalist2);
                            }
                        }else {
                            if (2 == killer) {
                                checkJournalist2 = false;
                                System.out.println("Answer: " + checkJournalist2);
                            } else {
                                System.out.println("Answer: " + checkJournalist2);
                            }
                        }
                    }
                }

                if(firstChoice==3) {
                    if (theQuestions == 0) {
                        System.out.println("Answer: "+RichPerson1);
                    } else if (theQuestions == 1) {
                        System.out.println("Answer: "+RichPerson2);
                    } else if (theQuestions == 2) {
                        System.out.println("Answer: "+RichPerson3);
                    } else if (theQuestions == 3) {
                        if(fourKiller){
                            if (3==killer){
                                checkRichPerson1=false;
                                System.out.println("Answer: "+checkRichPerson1);
                            }else{
                                System.out.println("Answer: "+checkRichPerson1);
                            }
                        }else {
                            if (3 == player4) {
                                checkRichPerson1 = false;
                                System.out.println("Answer: " + checkRichPerson1);
                            } else {
                                System.out.println("Answer: " + checkRichPerson1);
                            }
                        }
                    } else if (theQuestions == 4) {
                        if(fourKiller){
                            if (3==player4){
                                checkRichPerson2=false;
                                System.out.println("Answer: "+checkRichPerson2);
                            }else{
                                System.out.println("Answer: "+checkRichPerson2);
                            }
                        }else {
                            if (3 == killer) {
                                checkRichPerson2 = false;
                                System.out.println("Answer: " + checkRichPerson2);
                            } else {
                                System.out.println("Answer: " + checkRichPerson2);
                            }
                        }
                    }
                }

                if(firstChoice==4) {
                    if (theQuestions == 0) {
                        System.out.println("Answer: "+Professor1);
                    } else if (theQuestions == 1) {
                        System.out.println("Answer: "+Professor2);
                    } else if (theQuestions == 2) {
                        System.out.println("Answer: "+Professor3);
                    } else if (theQuestions == 3) {
                        if(fourKiller){
                            if (4==killer){
                                checkProfessor1=false;
                                System.out.println("Answer: "+checkProfessor1);
                            }else{
                                System.out.println("Answer: "+checkProfessor1);
                            }
                        }else {
                            if (4 == player4) {
                                checkProfessor1 = false;
                                System.out.println("Answer: " + checkProfessor1);
                            } else {
                                System.out.println("Answer: " + checkProfessor1);
                            }
                        }
                    } else if (theQuestions == 4) {
                        if(fourKiller){
                            if (4==player4){
                                checkProfessor2=false;
                                System.out.println("Answer: "+checkProfessor2);
                            }else{
                                System.out.println("Answer: "+checkProfessor2);
                            }
                        }else {
                            if (4 == killer) {
                                checkProfessor2 = false;
                                System.out.println("Answer: " + checkProfessor2);
                            } else {
                                System.out.println("Answer: " + checkProfessor2);
                            }
                        }
                    }
                }

                int theLoop=0;
                while(theLoop==0) {
                    System.out.println("Would you like to keep questioning? (y/n)");
                    s.nextLine();
                    yesChoice = s.nextLine();
                    if (yesChoice.equals("y") || yesChoice.equals("n")) {
                        theLoop = 1;
                    } else {
                        System.out.println("Please enter y/n!");
                    }
                }
            }while(yesChoice.equals("y"));

            System.out.println("Cleared: "+people[player1]);

            System.out.println("Who do you no longer suspect?");
            for(int i=0;i<people.length;i++){
                System.out.println(i+" -"+" "+people[i]);
            }
            firstChoice=s.nextInt();
            if (firstChoice==(player2)) {
                System.out.println("Cleared: " +people[player1]+" "+people[player2]);
            }else if(firstChoice==(player3)){
                System.out.println("Cleared: " +people[player1]+" "+people[player3]);
            }else if(firstChoice==-1){
                return;
            }else{
                System.out.println("The murderer sneaks up on you and kills you when you are alone... \nYou lost!");

                int theloop=0;
                while (theloop==0) {
                    System.out.println("Do you want to play again? ");
                    s.nextLine();
                    noChoice = s.nextLine();
                    if (noChoice.equals("y") || noChoice.equals("n")) {
                        theloop = 1;
                    } else {
                        System.out.println("Please enter y/n!");
                    }
                }
                if (noChoice.equals("y")){
                    continue;
                }else {return;}
            }

            System.out.println("Who do you no longer suspect?");
            for(int i=0;i<people.length;i++){
                System.out.println(i+" -"+" "+people[i]);
            }
            firstChoice=s.nextInt();
            if (firstChoice==(player2)) {
                System.out.println("Cleared: " +people[player1]+" "+people[player3]+" "+people[player2]);
            }else if(firstChoice==(player3)){
                System.out.println("Cleared: " +people[player1]+" "+people[player2]+" "+people[player3]);
            }else if(firstChoice==-1){
                return;
            }else{
                System.out.println("The murderer sneaks up on you and kills you when you are alone... \nYou lost!");

                int testLoop=0;
                while (testLoop==0) {
                    System.out.println("Do you want to play again? ");
                    s.nextLine();
                    noChoice = s.nextLine();
                    if (noChoice.equals("y") || noChoice.equals("n")) {
                        testLoop = 1;
                    } else {
                        System.out.println("Please enter y/n!");
                    }
                }
                if (noChoice.equals("y")){
                    continue;
                }else {return;}
            }

            //****************PART 3******************//
            System.out.println("Showing puzzle...");
            System.out.println("The victim wrote a note before the murder, it was found ripped to pieces in a trash bin nearby.");
            System.out.println("The pieces read: ");

            String originalString = notes[killer];
            String scrambledString = " ";
            while (originalString.length() > 0){
                int index = r.nextInt(originalString.length());
                Character c = originalString.charAt(index);
                for(int i = 0; i < originalString.length(); i++){
                    if(originalString.charAt(i) == c)
                    {
                        scrambledString += c; // add character to new string
                        originalString = originalString.substring(0, i) + originalString.substring(i+1); // remove the character
                        i--;
                    }
                }
            }
            System.out.println(scrambledString);

            System.out.println("Who do you think the killer is?");
            for (int i = 0; i < 5; i++) {
                System.out.print(i + ". ");
                System.out.print(people[i] + "\n");
            }
            int scrambleChoice = s.nextInt();
            if(scrambleChoice == -1){
                return;
            }
            if(scrambleChoice == killer){
                System.out.println("Congratulations");
                System.out.println("You win!");
                System.out.println("Would you like to play again? (y/n)");
                noChoice = s.nextLine();
                if(noChoice.equals(-1)){
                    return;
                }
                //Alive = false;
            }else{
                System.out.println("The murderer sneaks up on you and kills you when you are alone...");
                System.out.println("You lost!");
                System.out.println("Would you like to play again? (y/n)");
                noChoice = s.nextLine();
                if(noChoice.equals(-1)){
                    return;
                }else if(noChoice.equals("n")){
                    System.out.println("Thank you for playing Murder Mystery!");
                }
                // Alive = false;
            }




            System.out.println("Do you want to play again? ");
            s.nextLine();
            noChoice=s.nextLine();

        }while(noChoice.equals("y"));
    }
}