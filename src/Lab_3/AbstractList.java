package Lab_3; /**
 * Created by Magdalena Polak on 07.03.2016.
 */




import Lab_3.OwnIterator;


// zestaw metod u³atwiaj¹cych implementacjê list
public abstract class AbstractList implements List
{
    // wydruk wszystkich elementów listy
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append('[');
        if (!isEmpty()) {
            OwnIterator i = (OwnIterator) iterator();
            for (i.first(); !i.isDone(); i.next())
                buffer.append(i.current()).append(", ");
            buffer.setLength(buffer.length() - 2);
        }
        buffer.append(']');
        return buffer.toString();
    }

    // ^ - bitowa ró¿nica symetryczna
    public int hashCode() {
        int hashCode = 0;
        OwnIterator i = (OwnIterator) iterator();
        for (i.first(); !i.isDone(); i.next())
            hashCode ^= i.current().hashCode();
        return hashCode;
    }

    public boolean equals(Object object) {
        return object instanceof List ? equals((List) object) : false;
    }

    public boolean equals(List other) {
        if (other == null || size() != other.size())
            return false;
        else { OwnIterator i = (OwnIterator) iterator();
            OwnIterator j = (OwnIterator) other.iterator();
            for(i.first(),j.first();!i.isDone() && !j.isDone() &&
                    i.current().equals(j.current()); i.next(), j.next());
            return i.isDone() && j.isDone();
        }
    }

}
