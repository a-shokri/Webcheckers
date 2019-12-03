package com.webcheckers.model;

import javax.persistence.*;

@Entity
@Table(name = "Square")
public class Square {
    @Id
    @GeneratedValue
    @Column(name = "id")
    long id;

    
    @Column(name = "x")
    int x;
    
    @Column(name = "y")
    int y;
    
    @Column(name = "color")
    int color;
    
    @Column(name = "board_id")
    int board_id;
    
    public void setId(long id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public long getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getColor() {
        return color;
    }

    public int getBoard_id() {
        return board_id;
    }
}
