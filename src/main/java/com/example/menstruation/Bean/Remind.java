package com.example.menstruation.Bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "remind")
public class Remind implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
    @Column(name = "userid")
    private Integer userid;
    @Column(name = "start")
    private Integer start;
    @Column(name = "end")
    private Integer end;

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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
