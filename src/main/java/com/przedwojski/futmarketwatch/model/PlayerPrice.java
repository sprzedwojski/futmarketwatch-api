package com.przedwojski.futmarketwatch.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerPrice {

    private Player player;
    private Price price;

    public PlayerPrice(Player player, Price price) {
        this.player = player;
        this.price = price;
    }
}
