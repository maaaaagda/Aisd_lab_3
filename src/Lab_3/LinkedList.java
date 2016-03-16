package Lab_3;

/**
 * Created by Magdalena Polak on 08.03.2016.
 */

import java.util.Iterator;

public class LinkedList extends AbstractList {
    private final Element _head = new Element(null);    // wartownik

    private int _size;    // dlugoœæ listy
    public LinkedList() {
        clear();
    }

    public void clear(){
        _head.setNext(null);
        _size=0;
    }

    public Iterator iterator() {
       return null;
   }
    public ValueIterator viterator()                    //zwraca iterator po wartosciach
    {
        return new ValueIterator();
    }
    public boolean delete(Object value) {               //usuwa obiekt
        if (_head.getNext() == null) {
            return false;
        }
        if (_head.getNext().getValue().equals(value)) {
            _head.setNext(_head.getNext().getNext());
            _size--;
            return true;
        }
        Element usuniety = _head.getNext();
        while (usuniety != null & usuniety.getNext() != null) {
            if (usuniety.getNext().getValue().equals(value)) {
                usuniety.setNext(usuniety.getNext().getNext());
                _size--;
                return true;
            }
            usuniety = usuniety.getNext();
        }

        return false;
    }


    public boolean insert(int index, Object value) throws IndexOutOfBoundsException {
        Element inserted =_head.getNext();
        Element e = new Element(value);
        if(index == 0 )
        {
            return false;
        }
        if (_head.getNext() == null) {
            return false;

        }
        if (indexOf(_head.getNext()) == index) {
            _head.setNext(e);
            _size++;
             return true;
        }
        if (index < 0 || index > _size) throw new IndexOutOfBoundsException();
        while (inserted != null & inserted.getNext() != null)
        {
            if (indexOf(inserted.getNext()) == index) {
                Element next = inserted._next;
                inserted._next = e;
                e._next = next;
                _size++;
                return true;
            }
          inserted = inserted.getNext();
        }
        return false;
    }


    void printList()
    {
        Element temp = _head.getNext();
        while (temp != null)
        {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
        System.out.println(" ");
    }
    public void add(Object value){

        if (_head.getNext()== null) {
            _head.setNext(new Element(value)); //jeœli lista jest pusta ustawiamy nastêpnik wartownika
          }

        else
        {
            Element last = _head.getNext();
           while (last.getNext() != null) {

               last = last.getNext();         //szukamy ostatniego elementu

            }
            ++_size;
            last.setNext(new Element(value)); //i ustawiamy jego nastêpnik na nowy wêze³ z podan¹ wartoœci¹ value
        }
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    public boolean isEmpty() {
        return _size == 0;
    }

    public int indexOf(Object obj) {
        int index = 0;
        Element current = _head.getNext();

        while (current != null) {
            if (current.equals(obj)) {
                return index;
            }
            index++;
            current = current.getNext();
        }

        return -1;
    }

    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Element element = getElementForwards(index);
        Object oldValue = element.getValue();
        element.setValue(value);
        return oldValue;
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        return getElementForwards(index).getValue();
    }
    public int size() {
        return _size;
    }


    // dojœcie do podanej pozycji w przód
    private Element getElementForwards(int index) {
        Element element = _head.getNext();

        for (int i = index; i > 0; --i)
            element = element.getNext();
        return element;
    }


    private void checkOutOfBounds(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
    }

    // pomocnicza klasa definiuj¹ca element listy
   public static final class Element {
        private Object _value;
        private Element _next;


        public void setValue(Object value) {
            _value = value;
            _next = null;
        }
        public Element(Object val){
            this(val, null);
        }
        /**
         * Konstruktor, który pozwala wstawiæ element na okreœlone miejsce
         * @param val obiekt, który chcemy umieœciæ na liœcie
         * @param n obiekt kolejny
         */
        public Element(Object val, Element n){
            _value = val;
            _next = n;
        }

         public Object getValue() {
            return _value;
        }

        public Element getNext() {
            return _next;
        }

        public void setNext(Element next) {
            _next = next;
        }
    }

        // iterator po wartoœciach elementów listy
        // bardziej efektywny od zwyk³ej pêtli po indeksach
        public class ValueIterator implements OwnIterator
        {
            private Element _current = _head;

            public void first() {
                _current = _head.getNext();
            }


            public boolean isDone() {
                return _current == null;
            }

            public void next() {
                _current = _current.getNext();
            }

            public Object current() throws IndexOutOfBoundsException {
                if (isDone())
                    throw new IndexOutOfBoundsException();
                return _current.getValue();
            }
        }
    }



