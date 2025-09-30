package com.kd.Backend.controller;

import java.util.List;
import java.util.Optional;

import com.kd.Backend.Repo.PlayerRepo;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kd.Backend.model.Player;
import com.kd.Backend.service.PlayerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/controller/player")
public class PlayerController {

    private final PlayerService playerService;

    private final PlayerRepo playerRepo;

    public PlayerController(PlayerService playerService, PlayerRepo playerRepo) {
        this.playerService = playerService;
        this.playerRepo = playerRepo;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation,
            @RequestParam(required = false) String club) {

        if (club != null && position != null) {
            return playerService.getPlayerByClubAndPosition(club, position);
        } else if (club != null) {
            return playerService.getPlayersFromClub(club);
        } else if (position != null) {
            return playerService.getPlayerByPosition(position);
        } else if (nation != null) {
            return playerService.getPlayerByNationality(nation);
        } else if (name != null) {
            return playerService.getPlayerByName(name);
        } else {
            return playerService.getAllPlayers();
        }
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable long id){
        return playerService.getPlayerById(id);
    }

    @PostMapping("/addplayer")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable long id, @RequestBody Player player) {
        Optional<Player> existingPlayer = playerRepo.findById(id);

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();

            // update all fields
            playerToUpdate.setName(player.getName());
            playerToUpdate.setNation(player.getNation());
            playerToUpdate.setPosition(player.getPosition());
            playerToUpdate.setClub(player.getClub());
            playerToUpdate.setAge(player.getAge());
            playerToUpdate.setAppearances(player.getAppearances());
            playerToUpdate.setGoals(player.getGoals());
            playerToUpdate.setAssists(player.getAssists());
            playerToUpdate.setYellowCards(player.getYellowCards());
            playerToUpdate.setRedCards(player.getRedCards());
            playerToUpdate.setMatchesPlayed(player.getMatchesPlayed());
            playerToUpdate.setPenalties(player.getPenalties());

            return new ResponseEntity<>(playerRepo.save(playerToUpdate), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/user-name/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable long id){
        playerService.deletePlayerById(id);
        return "Player deleted successfully.. By Id..";
    }

    @GetMapping("/positions")
    public ResponseEntity<List<String>> getAllPositions() {
        List<String> positions = playerService.getAllPositions();
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }

    @GetMapping("/controller/teams")
    public List<Player> getAllTeams() {
        return playerService.getAllPlayers(); // Make sure service and repo return List<Team>
    }

    

}
