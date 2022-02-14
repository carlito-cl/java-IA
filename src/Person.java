import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class Person implements Serializable {
    //personal details
    String name;
    LocalDate DoB;
    Boolean isMale;

    //family details
    Person father;
    Person mother;
    Person spouse;
    ArrayList<Person> children = new ArrayList<>();

    public Person() {
    }

    public Person(String name, LocalDate DoB, Boolean isMale) {
        this.name = name;
        this.DoB = DoB;
        this.isMale = isMale;
        personController.persons.add(this); //saves the newly created person to an arraylist stored in personController
    }

    public Person(String name, LocalDate doB, Boolean isMale, Person father, Person mother, Person spouse, ArrayList<Person> children) {
        this.name = name;
        this.DoB = doB;
        this.isMale = isMale;
        
        this.father = father;
//        if (this.father != null) {
//            this.father.children.add(this);
//        }

        this.mother = mother;
//        if (this.mother != null) {
//            this.mother.children.add(this);
//        }

        this.spouse = spouse;
//        if (this.spouse != null) {
//            this.spouse.spouse = this;
//        }

        this.children = children;
//        if (this.children != null) {
//            for (Person child: this.children) {
//                if (this.getMale()) {
//                    child.setFather(this); //automatically sets the newly created child's father or father or mothers to 'this' -- the person
//                } else {
//                    child.setMother(this);
//                }
//            }
//        }


        personController.persons.add(this); //saves the newly created person to an arraylist stored in personController
    }

    public String getName() {
        if (name == null) {
            return null;
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDoB() {
        if (DoB == null) {
            return null;
        }
        return DoB;
    }

    public void setDoB(int year, int month, int day) {
        DoB = LocalDate.of(year, month, day);
    }

    public Boolean getMale() {
        if (isMale == null) {
            return null;
        }
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
    }

    public Person getFather() {
        if (father == null) {
            return null;
        }
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
        father.addChild(this);
    }

    public Person getMother() {
        if (mother == null) {
            return null;
        }
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
        mother.addChild(this);
    }

    public Person getSpouse() {
        if (spouse == null) {
            return null;
        }
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
        spouse.spouse = this;
    }

   public ArrayList<Person> getChildren() {
        if (children == null) {
            return null;
        }
        return children;
    }

    public void addChild(Person child) {
        this.children.add(child);
        if (this.getMale()) {
            child.setFather(this); //automatically sets the newly created child's father or father or mothers to 'this' -- the person
        } else {
            child.setMother(this);
        }
    }

    public void addChild(String name, LocalDate DoB, Boolean isMale) {
        Person child = new Person(name, DoB, isMale);
        if (this.getMale()) {
            child.setFather(this); //automatically sets the newly created child's father or father or mothers to 'this' -- the person
        } else {
            child.setMother(this);
        }
        this.children.add(child);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", DoB=" + DoB +
                ", isMale=" + isMale +
                ", father=" + father +
                ", mother=" + mother +
                ", spouse=" + spouse +
                ", children=" + children +
                '}';
    }
}

