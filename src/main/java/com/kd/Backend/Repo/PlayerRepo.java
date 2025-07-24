package com.kd.Backend.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kd.Backend.model.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player, String> {
    void deleteByName(String playerName);

    Optional<Player> findByName(String playerName);

}
