package unizd.inoIT.todo.model;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "naziv_zadatka")
    private String nazivZadatka;

    @Column(name = "opis_zadatka")
    private String opisZadatka;

    @Column(name = "datum_stvaranja")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datumStvaranjaZadatka;

    @Column(name = "datum_roka")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datumRokaZadatka;

    @Column(name = "razina_nuznosti")
    private String urgency;

    @Column(name = "user_id")
    private String userName;

    @Column(name = "status")
    private String status;

    @Column(name = "completed_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date completedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivZadatka() {
        return nazivZadatka;
    }

    public void setNazivZadatka(String nazivZadatka) {
        this.nazivZadatka = nazivZadatka;
    }

    public String getOpisZadatka() {
        return opisZadatka;
    }

    public void setOpisZadatka(String opisZadatka) {
        this.opisZadatka = opisZadatka;
    }

    public Date getDatumStvaranjaZadatka() {
        return datumStvaranjaZadatka;
    }

    public void setDatumStvaranjaZadatka(Date datumStvaranjaZadatka) {
        this.datumStvaranjaZadatka = datumStvaranjaZadatka;
    }

    public Date getDatumRokaZadatka() {
        return datumRokaZadatka;
    }

    public void setDatumRokaZadatka(Date datumRokaZadatka) {
        this.datumRokaZadatka = datumRokaZadatka;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String oznakaBojom) {
        this.urgency = oznakaBojom;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userId) {
        this.userName = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", nazivZadatka='" + nazivZadatka + '\'' +
                ", opisZadatka='" + opisZadatka + '\'' +
                ", datumStvaranjaZadatka=" + datumStvaranjaZadatka +
                ", datumRokaZadatka=" + datumRokaZadatka +
                ", urgency='" + urgency + '\'' +
                '}';
    }
}