import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List with different iteration types
 */
public class LinearList implements Iterable<String> {
    /**
     * Elements of the list
     */
    private List<String> elements;
    /**
     * Type of the iteration
     */
    public ListIteratorType iteratorType;
    /**
     * Min element length to pass the filtering by length
     */
    public Integer minElementsLength = 2;
    /**
     * First letter of the element to pass the filtering by first letter
     */
    public Character appropriateFirstLetter = 'a';

    /**
     * Constructor
     */
    public LinearList() {
        this.elements = new ArrayList<String>();
        this.iteratorType = ListIteratorType.DEFAULT;
    }

    /**
     * Add an element to a list
     *
     * @param element element to add
     */
    public void add(String element){
        elements.add(element);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<String> iterator() {
        if(this.iteratorType == ListIteratorType.FILTER_BY_LENGTH){
            return new LengsFilteringIterator(elements);
        }
        else if(this.iteratorType == ListIteratorType.FILTER_BY_FIRST_LETTER){
            return new FirstLetterFilteringIterator(elements);
        }
        else{
            return new DefaultIterator(elements);
        }
    }

    /**
     * Default iterator
     */
    private class DefaultIterator implements Iterator<String>{
        private List<String> elements;
        private Integer position;

        public DefaultIterator(List<String> elements){
            this.elements = elements;
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            return position < elements.size();
        }

        @Override
        public String next() {
            if(hasNext()){
                return elements.get(position++);
            }
            return null;
        }
    }

    /**
     * Iterator with filtering by first letter
     */
    private class FirstLetterFilteringIterator implements Iterator<String>{
        private List<String> elements;
        private Integer position;

        public FirstLetterFilteringIterator(List<String> elements){
            this.elements = elements;
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            while (position < elements.size()){
                if(elements.get(position).startsWith(appropriateFirstLetter.toString())){
                    return true;
                }
                position++;
            }
            return false;
        }

        @Override
        public String next() {
            if(hasNext()){
                return elements.get(position++);
            }
            return null;
        }
    }

    /**
     * Iterator with filtering by length
     */
    private class LengsFilteringIterator implements Iterator<String>{
        private List<String> elements;
        private Integer position;

        public LengsFilteringIterator(List<String> elements){
            this.elements = elements;
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
                while (position < elements.size()){
                    if(elements.get(position).length() >= minElementsLength){
                        return true;
                    }
                    position++;
                }
                return false;
        }

        @Override
        public String next() {
            if(hasNext()){
                return elements.get(position++);
            }
            return null;
        }
    }
}
