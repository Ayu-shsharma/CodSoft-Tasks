import java.util.Scanner;
import java.util.Random;
public class NumberGame {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String play = "yes";
        while( play.equals("yes")){
        System.out.println("Number Guessing Game ");
        Random rand=new Random();
        int randomNum=rand.nextInt(101);
        System.out.print("Enter no of try you want to take : ");
        int tries = sc.nextInt();
        int n = 1;
        while(n<=tries){
            System.out.println("Enter number between 1 and 100");
            int guess = sc.nextInt();
            n++;
            if(guess == randomNum){
                System.out.println("Correct, You Won ");
                System.out.println(" Tries taken :  " +n);
                break;
            }
            if(n >tries){
                System.out.println("Tries Exceed , You lost ");
                System.out.println("Number is " +randomNum);
            }
            else if(guess > randomNum){
                System.out.println("Smaller no ");
            }
            else{
                System.out.println("Greater no ");
            }
        } 
        System.out.println("Would you like to play agin ? Yes or No");
        play = sc.next().toLowerCase();
        }        
    sc.close();
    }
}
