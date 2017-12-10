package com.przedwojski.futmarketwatch.model;

import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
@Table(name = "players")
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "base_id")
    private Long baseId;
    private String name;
    private Long rating;

    public Player() {
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", baseId=" + baseId +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Long getBaseId() {
        return baseId;
    }

    public String getName() {
        return name;
    }

    public Long getRating() {
        return rating;
    }
}
