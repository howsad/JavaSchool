package sbt.java.marry;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (man ^ person.man && (spouse == null || !spouse.equals(person))) {
            divorce();
            person.divorce();
            person.spouse = this;
            spouse = person;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets spouse = null if spouse is not null
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (spouse != null) {
            spouse.spouse = null;
            spouse = null;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Person john = new Person(true, "John");
        Person bob = new Person(true, "Bob");
        Person mary = new Person(false, "Mary");
        Person alice = new Person(false, "Alice");
        System.out.println("Test 1:\nMarry John and Bob returns: " + john.marry(bob) + ". (both are male)");
        System.out.println("John's spouse: " + john.spouse);
        System.out.println("Bob's spouse: " + bob.spouse);
        System.out.println("\nTest 2:\nMarry Mary and Alice returns: " + mary.marry(alice) + ". (both are female)");
        System.out.println("Mary's spouse: " + mary.spouse);
        System.out.println("Alice's spouse: " + alice.spouse);
        System.out.println("\nTest 3:\nDivorce John (a single person) returns: " + john.divorce());
        System.out.println("John's spouse: " + john.spouse);
        System.out.println("\nTest 4:\nMarry John and Mary returns: " + john.marry(mary));
        System.out.println("John's spouse: " + john.spouse.name);
        System.out.println("Mary's spouse: " + mary.spouse.name);
        System.out.println("\nTest 5:\nDivorce John returns: " + john.divorce());
        System.out.println("John's spouse: " + john.spouse);
        System.out.println("Mary's spouse: " + mary.spouse);
        System.out.println("\nTest 6:\nMarry Mary and John (the other way around) returns: " + mary.marry(john));
        System.out.println("John's spouse: " + john.spouse.name);
        System.out.println("Mary's spouse: " + mary.spouse.name);
        System.out.println("\nTest 7:\nMarry John and Alice returns: " + john.marry(alice));
        System.out.println("John's spouse: " + john.spouse.name);
        System.out.println("Mary's spouse: " + mary.spouse);
        System.out.println("Alice's spouse: " + alice.spouse.name);
        System.out.println("\nTest 8:\nMarry John and Bob when John is already marries returns: " + john.marry(bob));
        System.out.println("John's spouse: " + john.spouse.name);
        System.out.println("Bob's spouse: " + bob.spouse);
        System.out.println("Alice's spouse: " + alice.spouse.name);
        System.out.println("\nTest 9:\nMarry Bob and Mary returns: " + bob.marry(mary));
        System.out.println("Bob's spouse: " + bob.spouse.name);
        System.out.println("Mary's spouse: " + mary.spouse.name);
        System.out.println("Marry Mary and Alice when both are married returns: " + mary.marry(alice));
        System.out.println("Alice's spouse: " + alice.spouse.name);
        System.out.println("Mary's spouse: " + mary.spouse.name);
        System.out.println("\nTest 10:\nMarry Bob and Mary (again) returns: " + bob.marry(mary));
        System.out.println("Bob's spouse: " + bob.spouse.name);
        System.out.println("Mary's spouse: " + mary.spouse.name);
        System.out.println("\nTest 11:\nMarry Bob and Alice returns: " + bob.marry(alice));
        System.out.println("Bob's spouse: " + bob.spouse.name);
        System.out.println("Alice's spouse: " + alice.spouse.name);
        System.out.println("John's spouse: " + john.spouse);
        System.out.println("Mary's spouse: " + mary.spouse);
    }
}
