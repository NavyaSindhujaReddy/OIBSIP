import java.util.*;
public class GuessNumber {
    public static int maxattempts=10;
    public static int min=1;
    public static int max=100;
    public static int rounds=5;
    public static void main(String args[])
    {
        System.out.println("!!**WELCOME TO GUESS NUMBER**!!");
        System.out.println("***INSTRUCTIONS***");
        System.out.println("You need to guess the number within minimum attempts to go to next round");
        System.out.println("There will be "+rounds+" in this game.");
        System.out.println("No of attempts in each round is "+maxattempts);
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        for(int i=1;i<=rounds;i++)
        {
            System.out.println("Round No :"+i);
            int number=r.nextInt(max)+min;
            int attempts=0;
            while(attempts<maxattempts)
            {
                System.out.print("Enter your Guess Number between "+min+" and "+max+" : ");
                int n=sc.nextInt();
                attempts+=1;
                if(n==number)
                {
                    int score=maxattempts-attempts;
                    System.out.println("Congrats!! You Won Round"+i+" in "+attempts+" attempts");
                    System.out.println("Your Score for Round"+i+" : "+score);
                    break;
                }
                else if(n<number)
                {
                    System.out.println("You have guessed LOW");
                }
                else
                {
                    System.out.println("You have guessed HIGH");
                }
            }
            if(attempts==maxattempts)
            {
                System.out.println("You Lost in Round"+i);
                System.out.println("The number is "+number);
                i--;
            }
        }
        sc.close();
    }
}
