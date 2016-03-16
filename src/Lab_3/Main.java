package Lab_3;

import java.util.*;
import java.util.Iterator;

/**
 * Created by Magdalena Polak on 09.03.2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        LinkedList l = new LinkedList();
        Student s  = new Student("Anna ", "Kowalska", 712, 9);
        Student s1 = new Student ("Piotr", "Nowak", 171, 8);
        Student s2 = new Student ("Brian", "Jaczynski", 173, 7);
        Student s3 = new Student ("Mariola", "Wojcik", 174, 6);
        Student s4 = new Student ("Tomasz", "Nikt", 175, 56);
        l.add(s);
        l.add(s1);
        l.add(s2);
        l.add(s3);
        l.printList();


        System.out.println( l.delete(s3));
        System.out.println(l.insert(2, s4));
        System.out.println("\nTest iteratora:");


        LinkedList.ValueIterator it= l.viterator();
            it.first();
            while(!it.isDone())
            { Student ss=(Student)it.current();
                System.out.printf("%-10s", ss.imie);
                System.out.printf("%-10s", ss.nazwisko);
                System.out.printf("%10d", ss.indeks);
                System.out.printf("%10.2f", ss.ocena);
                System.out.println();
                it.next();
            }



    }
}
