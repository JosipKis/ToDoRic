package unizd.inoIT.todo.model;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "datum_stvaranja")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datumStvaranjaZadatka;

    @Column(name = "role")
    private String role;

    @Column(name = "low_urgency")
    private String lowUrgency;

    @Column(name = "mid_urgency")
    private String midUrgency;

    @Column(name = "high_urgency")
    private String highUrgency;

    @Column(name = "critical_urgency")
    private String criticalUrgency;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDatumStvaranjaZadatka() {
        return datumStvaranjaZadatka;
    }

    public void setDatumStvaranjaZadatka(Date datumStvaranjaZadatka) {
        this.datumStvaranjaZadatka = datumStvaranjaZadatka;
    }

    public String getLowUrgency() {
        return lowUrgency;
    }

    public void setLowUrgency(String lowUrgency) {
        this.lowUrgency = lowUrgency;
    }

    public String getMidUrgency() {
        return midUrgency;
    }

    public void setMidUrgency(String midUrgency) {
        this.midUrgency = midUrgency;
    }

    public String getHighUrgency() {
        return highUrgency;
    }

    public void setHighUrgency(String highUrgency) {
        this.highUrgency = highUrgency;
    }

    public String getCriticalUrgency() {
        return criticalUrgency;
    }

    public void setCriticalUrgency(String criticalUrgency) {
        this.criticalUrgency = criticalUrgency;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", datumStvaranjaZadatka=" + datumStvaranjaZadatka +
                ", lowUrgency='" + lowUrgency + '\'' +
                ", midUrgency='" + midUrgency + '\'' +
                ", highUrgency='" + highUrgency + '\'' +
                ", criticalUrgency='" + criticalUrgency + '\'' +
                '}';
    }
}