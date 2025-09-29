package com.kd.Backend.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kd.Backend.model.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player, String> {
    void deleteByName(String playerName);

    Optional<Player> findByName(String playerName);

    Optional<Player> findById(long id);

    @Query("SELECT p FROM Player p WHERE p.club = :club")
    List<String> findDistinctPositions();

    void deleteById(long id);

}
