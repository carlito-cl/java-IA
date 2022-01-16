import java.util.ArrayList;

public class Person {

    //personal details
    String name; //name
    String email; //personal email address
    Boolean isMale; //gender

    //family details
    Person father;
    Person mother;
    Person spouse;
    ArrayList<Person> children = new ArrayList<Person>();

    public Person(String name, String email, Boolean isMale) {
        this.name = name;
        this.email = email;
        this.isMale = isMale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public void getChildren() {

        System.out.println(children.toString());
    }

    public void setChildren(Person child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name: " + name + '\'' +
                ", Email Address: '" + email + '\'' +
                ", Gender: " + isMale +
                ", Name of Father: " + father +
                ", Name of Mother: " + mother +
                ", Name of Spouse: " + spouse +
                ", Children: " + children.toString() +
                '}';
    }

//    public static void main(String[] args) {
//
//        Person Alex = new Person("Alexander Leroux-Mccarroll", "alexanderlerouxmccarroll@gmail.com", true);
//        Person Charles = new Person("Charles Leroux", "charlesleroux2004@gmail.com", true);
//
//    }

}

