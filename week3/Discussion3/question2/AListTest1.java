

public class AListTest1 {

    public static void main(String[] args) {
        //jh61b.junit.TestRunner.runTests("all", AListTest.class);
        AList a = new AList();
        a.insertBack(0);
        a.insertBack(1);
        a.insertBack(2);
        //a.insert(a, 5, 2);
        for(int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }
}