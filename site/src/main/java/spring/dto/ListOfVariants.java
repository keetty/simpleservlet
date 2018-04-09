package spring.dto; 

import java.util.*;

public class ListOfVariants {

private String title;


private int number;

public void setTitle(String title) {
this.title=title;
}
public String getTitle() {
return title;

}
 public void setNumber(int number) {
this.number=number;
}
public int getNumber() {
return number;

}

public ListOfVariants() {
}
public String toString() {

return String.valueOf(number) + "     "    +title;
}
}
