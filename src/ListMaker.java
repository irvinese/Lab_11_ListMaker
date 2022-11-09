import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        boolean done = false;
        do {
            while(true) {
                Scanner in = new Scanner(System.in);
                String prompt = ("Which letter will it be: A-add an item to list, D-Delete an item from the list, P-Print the list, Q-Quit the program" + "\n" + list);
                String menu = "[AaDdPpQq]";
                String userInput = SafeInput.getRegExString(in, prompt, menu);
                userInput = userInput.toUpperCase();
                switch (userInput) {
                    case "A":
                        list.add(add(list));
                        break;
                    case "D":
                        list.remove(delete(list));
                        break;
                    case "P":
                        print(list);
                        break;
                    case "Q":
                        boolean retVal = true;
                        String response = "";
                        boolean gotAVal = false;

                        do
                        {
                            String warning = "Are you sure you want to exit out of the list";
                            System.out.print("\n" + warning + " [Y/N] ");
                            Scanner scanner = new Scanner(System.in);
                            response = scanner.nextLine();
                            if(response.equalsIgnoreCase("Y"))
                            {
                                System.exit(0);
                            }
                            else if(response.equalsIgnoreCase("N"))
                            {
                                break;
                            }
                            else
                            {
                                System.out.println("You must answere [Y/N]! " + response );
                            }

                        }while(!gotAVal);
                        break;
                    default:
                        System.out.println("Please enter a valid letter of A, D, P, or Q; not: " + prompt);
                    }

                }

        } while (!done);

    }

    private static String add(ArrayList<String> list) {
        Scanner pipe = new Scanner(System.in);
        String answer = SafeInput.getNonZeroLenString(pipe, "What will you add to the list");
        return answer;
    }

    private static String delete(ArrayList<String> list) {
        Scanner pipe = new Scanner(System.in);
        String rid = SafeInput.getNonZeroLenString(pipe, "What will you delete from the list");
        return rid;
    }
    private static void print(ArrayList<String> list){
        System.out.println("****************************");
        for (String value: list){
            System.out.println(value);
        }
        System.out.println("****************************");
    }


    }
