package Lab_3;



/**
 * Created by Magdalena Polak on 07.03.2016.
 */

public interface OwnIterator
{
    public void first();
    public void next();
    public boolean isDone();
    public Object current() throws IteratorOutOfBoundsException;

}
