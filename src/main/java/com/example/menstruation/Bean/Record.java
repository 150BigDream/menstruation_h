package com.example.menstruation.Bean;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "record")
public class Record implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "drinkwater")
    private Integer drinkWater;
    @Column(name = "exercise")
    private Integer exercise;
    @Column(name = "earlytobed")
    private Integer earlyToBed;
    @Column(name = "eatbreakfast")
    private Integer eatBreakfast;
    @Column(name = "reading")
    private Integer reading;
    @Column(name = "pain")
    private Integer pain;
    @Column(name = "flow")
    private Integer flow;
    @Column(name = "userid1")
    private Integer userid;
    @Column(name = "time")
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDrinkWater() {
        return drinkWater;
    }

    public void setDrinkWater(Integer drinkWater) {
        this.drinkWater = drinkWater;
    }

    public Integer getExercise() {
        return exercise;
    }

    public void setExercise(Integer exercise) {
        this.exercise = exercise;
    }

    public Integer getEarlyToBed() {
        return earlyToBed;
    }

    public void setEarlyToBed(Integer earlyToBed) {
        this.earlyToBed = earlyToBed;
    }

    public Integer getEatBreakfast() {
        return eatBreakfast;
    }

    public void setEatBreakfast(Integer eatBreakfast) {
        this.eatBreakfast = eatBreakfast;
    }

    public Integer getReading() {
        return reading;
    }

    public void setReading(Integer reading) {
        this.reading = reading;
    }

    public Integer getPain() {
        return pain;
    }

    public void setPain(Integer pain) {
        this.pain = pain;
    }

    public Integer getFlow() {
        return flow;
    }

    public void setFlow(Integer flow) {
        this.flow = flow;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
