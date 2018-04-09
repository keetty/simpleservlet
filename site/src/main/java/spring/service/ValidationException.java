package spring.service; 


public class ValidationException extends Exception {
private String message;
private Throwable e;
public ValidationException() {
}
public ValidationException(String message) {
super(message);
}
public ValidationException(String message, Throwable e ) {
super(message, e);
}
public ValidationException(Throwable e) {
super(e);
}
} 