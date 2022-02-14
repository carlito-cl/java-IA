import java.io.IOException;

public class Session {

    public static void printLogo() {
        System.out.println(" ");
        System.out.println("  ------        --      --------    --          ----------  ----------    ------                      ------    --        ");
        System.out.println("--      --    --  --    --      --  --              --          --      --      --                  --      --  --        ");
        System.out.println("--          --      --  --      --  --              --          --      --      --                  --          --        ");
        System.out.println("--          ----------  --------    --              --          --      --      --    ----------    --          --        ");
        System.out.println("--          --      --  --  --      --              --          --      --      --    ----------    --          --        ");
        System.out.println("--      --  --      --  --    --    --              --          --      --      --                  --      --  --        ");
        System.out.println("  ------    --      --  --      --  ----------  ----------      --        ------                      ------    ----------");
        System.out.println(" ");
    }
    
    public static void mainMenu() throws IOException {
        boolean continues = true;
        char decision;

        do {
            // display the main menu
            System.out.println("\n\t== MENU ==");
            System.out.println("[ P ] Manage Persons");
            System.out.println("[ F ] Manage Families");
            System.out.println("[ Q ] Quit");
            
            System.out.println();

            decision = IBIO.inputChar("\tEnter one letter for your option: ");
            decision = Character.toLowerCase(decision);

            System.out.println();
            System.out.println();

            switch (decision) {
                case 'p':
                    personController.main(null);
                    break;
                case 'f':
                    familyController.main(null);
                    break;
                case 'q':
                    System.out.println("Quitting...");
                    continues = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            } //end switch
        } while (decision != 'p' && decision != 'f' && decision != 'q' && continues == true);
    }
    
    public static void main(String[] args) throws IOException {
        printLogo();
        mainMenu();
    }
    
}
