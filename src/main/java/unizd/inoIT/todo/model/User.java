package unizd.inoIT.todo.model;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {

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

    @Column(name = "completed_cntr")
    private int completedCntr;

    @Column(name = "deleted_cntr")
    private int deletedCntr;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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

    public int getCompletedCntr() {
        return completedCntr;
    }

    public void setCompletedCntr(int completedCntr) {
        this.completedCntr = completedCntr;
    }

    public int getDeletedCntr() {
        return deletedCntr;
    }

    public void setDeletedCntr(int deletedCntr) {
        this.deletedCntr = deletedCntr;
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