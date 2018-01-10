package folder.database; 
import javax.persistence.*;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "student")
public class Student {

 @Id
 @Column(name= "ID")
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;


@Column(name= "first_name")
private String firstName;

@Column(name= "second_name")
private String secondName;

public Student() {
}

public void setFirstName(String firstName ) {
this.firstName = firstName;
} 
public String getFirstName() {
return firstName;
}
public void setSecondName(String secondName ) {
this.secondName = secondName;
} 
public String getSecondName() {
return secondName;
}

public String toString() {
 return firstName     + " " +
  secondName;
}
}

