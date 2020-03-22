package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Message {

    @Id
    private int mid;
    private String text;
    private Date date;

}
