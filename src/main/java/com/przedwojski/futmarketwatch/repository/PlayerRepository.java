package com.przedwojski.futmarketwatch.repository;

import com.przedwojski.futmarketwatch.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findByNameContainingIgnoreCase(String name);
}
