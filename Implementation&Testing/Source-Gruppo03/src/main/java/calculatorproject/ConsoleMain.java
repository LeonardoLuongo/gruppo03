package calculatorproject;

import java.util.Scanner;

public class ConsoleMain
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String input = "";
        do
        {
            // TODO:
            /*  To give a better user experience we can write the operations the calculator can perform,
            *   add some separators...
            */
            System.out.println("Inserisci un'operazione o un numero dell'insieme complesso.");

            input = sc.nextLine();

            System.out.println("\n");

            try {
                calculator.fetchInput(input);
            }
            catch (RuntimeException e)
            {
                System.out.println("Exception Handled: ");
                e.printStackTrace();
            }

            System.out.println(calculator.toString());

        }while(!input.equalsIgnoreCase("exit"));

    }
}
