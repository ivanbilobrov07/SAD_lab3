//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinearList list = new LinearList();

        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        list.add("a");
        list.add("a test");

        System.out.println("Default Iterator");
        for(String element: list){
            System.out.println(element);
        }

        list.iteratorType = ListIteratorType.FILTER_BY_FIRST_LETTER;

        System.out.println();
        System.out.println("Iterator with filtering by first letter");
        for(String element: list){
            System.out.println(element);
        }

        list.iteratorType = ListIteratorType.FILTER_BY_LENGTH;

        System.out.println();
        System.out.println("Iterator with filtering by length");
        for(String element: list){
            System.out.println(element);
        }
    }
}