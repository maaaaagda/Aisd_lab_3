package Lab_3;

/**
 * Created by Magdalena Polak on 09.03.2016.
 */
public class Student
{
    String imie;
    String nazwisko;
    int indeks;
    double ocena;
    public Student( String imie, String nazwisko, int indeks, double ocena)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.indeks = indeks;
        this.ocena = ocena;
    }
    public String toString()
    {
        return imie +" "+ nazwisko+" " + indeks+" " + ocena;
    }
}