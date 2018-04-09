package spring.dto; 


public class StatisticForUser {
	
private int number;

private String title;

private int quantity;

int  vote_id;


public void setNumber(int number) {
this.number = number;
} 
public int getNumber() {
return number;
}

public void setTitle(String title) {
this.title=title;
}
public String getTitle() {
return title;

}
public void setQuantity(int  quantity) {
this.quantity = quantity;
} 
public int getQuantity() {
return quantity;
}
public StatisticForUser() {
}
public String toString() {
return String.valueOf(number)   + "   " +     title  + "    "  + String.valueOf(quantity);
}

}
