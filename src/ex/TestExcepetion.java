package ex;

/**
 * TestExcepetion.java
 * <p>
 * Created by jake
 * Created on 11/23/17
 * <p>
 * <p>
 * Throw exception if application properties are not correct.
 */


public class TestExcepetion extends RuntimeException {

    public TestExcepetion (String msg) {
        super(msg);
    }
}
