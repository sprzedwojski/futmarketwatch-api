package com.przedwojski.futmarketwatch.controllers;

import com.przedwojski.futmarketwatch.model.Player;
import com.przedwojski.futmarketwatch.model.PlayerPrice;
import com.przedwojski.futmarketwatch.model.Price;
import com.przedwojski.futmarketwatch.repository.PlayerRepository;
import com.przedwojski.futmarketwatch.services.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PlayerController {

    private PlayerRepository playerRepository;
    private PricesService pricesService;

    @Autowired
    public PlayerController(PlayerRepository playerRepository, PricesService pricesService) {
        this.playerRepository = playerRepository;
        this.pricesService = pricesService;
    }

    @RequestMapping("/players/{id}")
    public PlayerPrice getPlayer(@PathVariable String id) {
        Player player = playerRepository.findOne(Long.parseLong(id));
        Price price = pricesService.getPlayerPrice(player.getBaseId().toString());
        return new PlayerPrice(player, price);
    }

    @RequestMapping("/players")
    public List<Player> searchPlayer(@RequestParam(value = "name") String name) {
        return playerRepository.findByNameContainingIgnoreCase(name);
    }

    @RequestMapping("/players/{id}/prices")
    public Price getPrice(@PathVariable String id) {
        Player player = playerRepository.findOne(Long.parseLong(id));
        return pricesService.getPlayerPrice(player.getBaseId().toString());
    }

}
