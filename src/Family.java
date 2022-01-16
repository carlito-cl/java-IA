import java.util.ArrayList;

public class Family {
    String familyName;
    ArrayList<Person> familyMembers; //List of members of that family by blood

    public Family(String familyName) {
        this.familyName = familyName;
    }

    public void getFamilyMembers() {
        System.out.println(this.familyMembers);
    }

    public void setFamilyMembers(Person familyMember) {
        this.familyMembers.add(familyMember);
    }
}
