package org.example;

import javax.xml.transform.Result;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class App {
    public static void main(String[] args) {

        Map<PhoneNum,Person> phoneBook = new HashMap<>();

        PhoneNum[] phoneNum = {
                new PhoneNum("01775898096"),
                new PhoneNum("+18603723456"),
                new PhoneNum("+491675634567"),
                new PhoneNum("01758236540"),
                new PhoneNum("01575663457"),
                new PhoneNum("01289467398"),
                new PhoneNum("01775894901"),
                new PhoneNum("01756027483"),
                new PhoneNum("01556384785"),
                new PhoneNum("01476897045")
        };

        Person defaultPerson = new Person("NoName", "NoSuename", "NoEmail");
        Person person2 = new Person("Marta", "Lust", "m.lust@web.de");

        phoneBook.put(phoneNum[0], new Person("Tom", "Nagel", "t.nagel@gmail.com"));
        phoneBook.put(phoneNum[1], new Person("Peter", "Lock", "p.lock@gmail.com"));
        phoneBook.put(phoneNum[2],  person2);
        phoneBook.put(phoneNum[3], new Person("Andreas", "Zeipel", "a.zeipel@web.de"));
        phoneBook.put(phoneNum[4], new Person("Luan", "Hemmer", "l.hemmer@gmail.com"));
        phoneBook.put(phoneNum[5], new Person("Andreas", "Zeipel", "a.zeipel@web.de"));
        phoneBook.put(phoneNum[6], new Person("Magnus", "Neitel", "m.Neitel@gmail.com"));
        phoneBook.put(phoneNum[7], new Person("Teo", "Arend", "t.arend@gmail.com"));
        phoneBook.put(phoneNum[8], new Person("Klemens", "Vogel", "k.vogel@gmail.com"));
        phoneBook.putIfAbsent(phoneNum[9], new Person("Nills", "Vormund", "n.vormund@gmail.com"));

        System.out.println(phoneBook);
        System.out.println("=============================================================================");
        System.out.println("Size of PhoneBook is : " + phoneBook.size());

        System.out.println("Person0: " + phoneBook.get(phoneNum[0]));

        phoneBook.compute(phoneNum[2], (key, val) -> val.addSurname(person2, "Cola"));
        System.out.println("Petson2: " + phoneBook.get(phoneNum[2]));

        System.out.println("----------------------------------------------------------------------------");
        Set<PhoneNum> setOfNumbers = phoneBook.keySet();
        System.out.println("Ser of PhoneNumbers: " + setOfNumbers);

        System.out.println("-----------------------------------------------------------------------------");
        Collection<Person> valuesOfPerson = phoneBook.values();
        System.out.println("Values of Persons:" + valuesOfPerson);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        if (phoneBook.containsKey(phoneNum[9])) {
            phoneBook.remove(phoneNum[9]);
            System.out.println("Person9 is NULL then DEFAULT: " + phoneBook.getOrDefault(phoneNum[9], defaultPerson));
            phoneBook.put(phoneNum[9], defaultPerson);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("PhoneBook :");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        for(Map.Entry<PhoneNum, Person> item : phoneBook.entrySet())
        for(var item : phoneBook.entrySet()){
            System.out.printf("%15s %10s %10s %20s\n", item.getKey().getPhoneNum(),
                    item.getValue().getName(),
                    item.getValue().getSurname(),
                    item.getValue().getEmail()
                    );
        }

        System.out.println("USING FOREACH ***************************************************************************");
        phoneBook.forEach(new BiConsumer<PhoneNum, Person>() {
            @Override
            public void accept(PhoneNum phoneNum, Person person) {
                System.out.println(phoneNum + "==" + person);
            }

        });

        System.out.println("USING LAMBDA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        phoneBook.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
