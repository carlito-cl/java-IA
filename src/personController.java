import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.jar.Attributes.Name;

public class personController {
    static ArrayList<Person> persons = new ArrayList<>();

    public static void save() throws IOException {
        System.out.println("Saving Data...");
        File personCSVFile = new File("person.csv");
        FileWriter fw = new FileWriter(personCSVFile);
        PrintWriter out = new PrintWriter(fw); //write mode
        out.println("Name, Date of Birth, Gender, Father, Mother, Spouse, Children");

        for(Person p : persons) { //loop to save each element of a person
            out.print(p.getName()+ ", ");
            out.print(p.getDoB()+ ", ");
            if (p.getMale()) {
                out.print("Male, ");
            } else {
                out.print("Female, ");
            }
            if (p.getFather() != null) {
                out.print(p.getFather().name + ", ");
            } else {
                out.print("null, ");
            }
            if (p.getMother() != null) {
                out.print(p.getMother().name + ", ");
            } else {
                out.print("null, ");
            }
            if (p.getSpouse() != null) {
                out.print(p.getSpouse().name + ", ");
            } else {
                out.print("null, ");
            }
            out.print("[");
            if (p.getChildren() != null) {
                if (p.getChildren().size() > 0) {
                    for (Person i : p.getChildren()) {
                        out.print(i.getName());
                        if (p.getChildren().size() - 1 > 0) {
                            out.print(", ");
                        }
                    }
                }
            }
            out.print("]");
            out.println();
        }
            
            
            
        
        out.close();
        System.out.println("Back-up completed."); //shows that a file has been saved

        FileOutputStream personFOS = new FileOutputStream("person.ser");
        ObjectOutputStream personOOS = new ObjectOutputStream(personFOS);
        personOOS.writeObject(persons);
        personOOS.close();
        personFOS.close();
        System.out.println("Data file saved."); //shows that a file has been saved
    }
    public static void load() throws IOException {
        System.out.println("Loading data...");
        File personFile = new File("person.ser");
        if (!personFile.exists())
        {
            personFile.createNewFile();
            System.out.println("Subjects file not found. Creating it.");
            //addSubject();
        }
        try {
            FileInputStream personFIS = new FileInputStream("subjects.ser");
            ObjectInputStream personOIS = new ObjectInputStream(personFIS); //read mode
            persons = (ArrayList<Person>) personOIS.readObject();
            personOIS.close();
            personFIS.close();
        } catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Data file saved!"); // optional
    }

    public static void personMenu() throws IOException {
        boolean continues = true;
        char decision;

        do {
            System.out.println("\n\t== MENU ==");
            System.out.println("[ O ] Select operations");
            System.out.println("[ A ] Add a member");
            System.out.println("[ E ] Edit a member");
            System.out.println("[ L ] List names");
            System.out.println("[ S ] Search names");
            System.out.println("[ C ] Sort names");
            System.out.println("[ F ] Filter names");
            // System.out.println("[ P ] Print profile"); -- make this an action only for the search function
            // System.out.println("[ R ] Reserve names"); -- make this an action only for the operations function
            System.out.println("[ G ] Go back");

            System.out.println();

            decision = IBIO.inputChar("\tEnter one letter for your option: ");
            decision = Character.toLowerCase(decision);

            System.out.println();
            System.out.println();

            switch (decision) {
                case 'o':
                    continues = false;
                    operationsMenu();
                    break;

                case 'a':                    
                    continues = false;
                    addMember();
                    break;

                case 'e':
                    continues = false;
                    System.out.println("Edit... edit... edit...");//action
                    break;

                case 'l':
                    continues = false;
                    System.out.println("You're not on the list");
                    break;

                case 's':
                    continues = false;
                    System.out.println("S... as in *S*hut the f*ck up?");
                    break;

                case 'c':
                    continues = false;
                    System.out.println("Crap");
                    break;

                case 'f':
                    continues = false;
                    System.out.println("Does it work? I don't fucking know!");
                    break;

                case 'g':
                    continues = false;
                    Session.mainMenu();
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (decision != 'l' && decision != 'e' && decision != 'r' && decision != 'g' && continues);
    }

    public static void operationsMenu() throws IOException {
        boolean continues = true;
        char decision;

        do {

            System.out.println("\n\t== MENU ==");
            System.out.println("[ D ] Return cousin degree");
            System.out.println("[ P ] Return relative position");
            System.out.println("[ N ] Reserve child name");
            System.out.println("[ G ] Go back");

            System.out.println();

            decision = IBIO.inputChar("\t Give one letter for your option: ");
            decision = Character.toLowerCase(decision);

            System.out.println();
            System.out.println();

            switch (decision) {
                case 'd':
                    continues = false;
                    System.out.println("Returning cousin degree");
                    break;
                case 'p':
                    continues = false;
                    System.out.println("Return relative position");
                    break;
                case 'n':
                    continues = false;
                    System.out.println("Reserve child name");
                case 'g':
                    continues = false;
                    personMenu();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (decision != 'd' && decision != 'p' && decision != 'n' && decision != 'g' && continues);
    }
    public static void addMember() throws IOException {
        //--------------------------------------------------------------------------------------------------------------
        //Creating new person
        Person p = new Person();

        System.out.println("\n\t == ENTER DETAILS == ");

        boolean isCapitalised = false;
        boolean hasSpace = false;

        String name;

        do {
            System.out.println();
            System.out.println("Your full name must be capitalised and have a space in between, example: John Doe.");

            name = IBIO.inputString("Enter name: ");
            int spacePosition = 0;

            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) == ' ') { //Checking for a space in the name entered
                    hasSpace = true;
                    spacePosition = i;
                    break;
                }
            }

            for (int i = 65; i < 96; i++) {
                if (name.charAt(0) == i) { //Checking if the char at index 0 is capitalised
                    for (int j = 65; j < 96; j++) {
                        if (name.charAt(spacePosition+1) == j) { //Checking if the capital after the first space is capitalised
                            isCapitalised = true;
                        }
                    }
                }
            }
        } while (!isCapitalised || !hasSpace); //Note for self -> works well
        p.setName(name);

        System.out.println();
        System.out.println("Enter birthday details bellow; and make sure all information are valid.");

        int year;
        int month;
        int day;

        boolean yearValid = false;

        do {
            year = IBIO.inputInt("Enter year: ");

            if (year <= LocalDate.now().getYear()) { // Create an entire system of checks
                if (year <= (LocalDate.now().getYear() - 100)) { // Checks if person is 100 years old or older
                    int inputCheck = IBIO.inputInt("Person appears to be 100 years old or older, re-enter birth year to confirm: ");
                    if (inputCheck == year) {
                        yearValid = true;
                    } else {
                        System.out.println("Validation didn't match. Try again.");
                    }
                }
            }
        } while (!yearValid); //fix

        boolean monthValid = false;

        do {
            month = IBIO.inputInt("Enter month: ");

            if (year == LocalDate.now().getYear()) { // Checks if year has been set to this year
                if (month <= (LocalDate.now().getMonthValue()) && month >= 01) {
                    monthValid = true;
                } else {
                    System.out.println("Validation didn't match. Try again.");
                }
            }

            if (month <= 12 && month >= 01) {
                monthValid = true;
            } else {
                System.out.println("Validation didn't match. Try again.");
            }
        } while (!monthValid);

        boolean dayValid = false;

        do {
            day = IBIO.inputInt("Enter day: ");

            if (year == LocalDate.now().getYear() && month == LocalDate.now().getMonthValue()) {
                if (day <= LocalDate.now().getDayOfMonth() && day >= 0) {
                    dayValid = true;
                } else {
                    System.out.println("Validation didn't match. Try again.");
                }
            }

            if (!dayValid){
                break;
            }

            switch (month) { //Adjusts the range check depending on the month of the year by merging cases
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day <= 31 && day >= 0) {
                        dayValid = true;
                    } else {
                        System.out.println("Validation didn't match. Try again.");
                    }
                    break;
                case 2:
                    if (year % 4 == 0) { // Checks for leap year
                        if (day <= 29 && day >= 0) {
                            dayValid = true;
                        } else {
                            System.out.println("Validation didn't match. Try again.");
                        }
                    } else {
                        if (day <= 28 && day >= 0) {
                            dayValid = true;
                        } else {
                            System.out.println("Validation didn't match. Try again.");
                        }
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day <= 30 && day >= 0) {
                        dayValid = true;
                    } else {
                        System.out.println("Validation didn't match. Try again.");
                    }
                    break;
            }
        } while (!dayValid);

        p.setDoB(year, month, day);

        char decisionG = IBIO.inputChar("Enter 'm' for male or 'f' for female: ");
        decisionG = Character.toLowerCase(decisionG);

        do {
            if (decisionG == 'm') {
                p.setMale(true);
            } else if (decisionG == 'f') {
                p.setMale(false);
            } else {
                System.out.println("Invalid choice.");
            }
        } while (decisionG != 'm' && decisionG != 'f');



        //Make this a two part process

        //--------------------------------------------------------------------------------------------------------------
        //Save or discard
        char decisionDS;

        do {
            System.out.println("\n\t == DISCARD OR SAVE ==");
            System.out.println("[ 1 ] Discard");
            System.out.println("[ 2 ] Save");

            System.out.println();

            decisionDS = IBIO.inputChar("\tEnter one letter for your option: ");
            decisionDS = Character.toLowerCase(decisionDS);

            switch (decisionDS) {
                case '1':
                    p = null;
                    break;
                case '2':
                    persons.add(p);
                    save();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        } while (decisionDS != '1'  && decisionDS != '2');

        personMenu();
    }
    public static void editMembers() throws IOException {}
    public static void listNames() throws IOException {}
    public static Person searchName(String name) throws IOException {
        name = name.toLowerCase();
        String sname;
        for (Person p : persons) {
            sname = p.getName().toLowerCase();
            if (sname.startsWith(name)) {
                return p;
            }
        }
        return null;
    }
    public static ArrayList<Person> searchNames(ArrayList<Person> children) {
        ArrayList<Person> results = new ArrayList<Person>();

        for (Person c : children) {
            for (Person p : persons)
            {
                String name = c.name.toLowerCase();
                String sname = p.getName().toLowerCase();

                if (sname.startsWith(name))
                {
                    results.add(p);
                } else {
                    System.out.println(c.name + " was not found in the system.");
                }
            }
        }

        if (results.size() > 0)
        {
            compactList(results);
            return results;
        }
        return null;
    }
    public static void compactList(ArrayList<Person> list) {    // only name and id, for quick search purposes
        for (Person p : list)
        {
            System.out.println(p.getName());
        }
    }
    public static void sortNames() throws IOException {}
    public static void filterNames() throws IOException {}

    public static void main(String[] args) throws IOException {
        Person Bernard = new Person("Bernard Leroux", LocalDate.of(1938, 06, 05), true);
        Person Anne = new Person("Anne Leroux-McCarroll", LocalDate.of(1944, 01, 03), false);
        Person Stephen = new Person("Stephen Leroux", LocalDate.of(1965, 8, 30), true, Bernard, Anne, null, null);
        Person Agnès = new Person("Agnès Leroux", LocalDate.of(1969, 02, 24), false, null, null, Stephen, null);
        Person Alex = new Person("Alexander Leroux-McCarroll", LocalDate.of(1972, 02, 19), true, Bernard, Anne, null, null);
        Person Elodie = new Person("Elodie Palasse-Leroux",LocalDate.of(1972, 02, 26), false, null, null, Alex, null);
        Person Kathy = new Person("Kathy Leroux", LocalDate.of(1978, 4, 13), false, Bernard, Anne, null, null);
        Person Jeremy = new Person("Jeremy Fournier", LocalDate.of(1978, 11, 22), false, null, null, Kathy, null);
        Person Maxime = new Person("Maxime Leroux", LocalDate.of(1992, 7, 06), true, Stephen, Agnès, null, null);
        Person PierreAlex = new Person("Pierre-Alex", LocalDate.of(1994, 5, 19), true, Stephen, Agnès, null, null);
        Person Stanislas = new Person("Stanislas Leroux", LocalDate.of(2000, 6, 03), true, Stephen, Agnès, null, null);
        Person Charles = new Person("Charles Leroux", LocalDate.of(2004, 11, 25), true, Alex, Elodie, null, null);
        Person Adrien = new Person("Adrien Fournier-Leroux", LocalDate.of(2010, 2, 18), true, Kathy, Elodie, null, null);

        System.out.println(Charles.hashCode());

        save();
        personMenu();
    }
}