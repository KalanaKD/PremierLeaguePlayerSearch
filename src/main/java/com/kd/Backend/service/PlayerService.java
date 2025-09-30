package com.kd.Backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kd.Backend.Repo.PlayerRepo;
import com.kd.Backend.model.Player;

import jakarta.transaction.Transactional;

@Component
public class PlayerService {
    private PlayerRepo playerRepo;

    @Autowired
    public void PlyerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public List<Player> getAllPlayers(){
        return playerRepo.findAll();
    }

    public List<Player> getPlayersFromClub(String club){
        return playerRepo.findAll().stream()
            .filter(player -> player.getClub() != null && player.getClub().toLowerCase().contains(club.toLowerCase()))
            .collect(Collectors.toList());
    }
    
    public List<Player> getPlayerByName(String name){
        return playerRepo.findAll().stream()
            .filter(player -> player.getName().toLowerCase().contains(name.toLowerCase()))
            .collect(Collectors.toList());
    }
    public List<Player> getPlayerByPosition(String pos){
        return playerRepo.findAll().stream()
            .filter(player->player.getPosition().toLowerCase().contains(pos.toLowerCase()))
            .collect(Collectors.toList());
    }
    public List<Player> getPlayerByNationality(String nation){
        return playerRepo.findAll().stream()
            .filter(player -> player.getNation().toLowerCase().contains(nation.toLowerCase()))
            .collect(Collectors.toList());
    }

    public List<Player> getPlayerByClubAndPosition(String club, String pos){
        return playerRepo.findAll().stream()
            .filter(player -> club.equals(player.getClub()) && pos.equals(player.getPosition()))
            .collect(Collectors.toList());
    }

    public Player addPlayer(Player player){
        playerRepo.save(player);
        return player ;
    }
    public Player updatePlayer(Player updatedPlayer){
        Optional<Player> existingPlayer = playerRepo.findById(updatedPlayer.getId());

        if(existingPlayer.isPresent()){
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setNation(updatedPlayer.getNation());
            playerToUpdate.setPosition(updatedPlayer.getPosition());
            playerToUpdate.setClub(updatedPlayer.getClub());
            playerToUpdate.setAge(updatedPlayer.getAge());
            playerToUpdate.setAppearances(updatedPlayer.getAppearances());
            playerToUpdate.setGoals(updatedPlayer.getGoals());
            playerToUpdate.setAssists(updatedPlayer.getAssists());
            playerToUpdate.setYellowCards(updatedPlayer.getYellowCards());
            playerToUpdate.setRedCards(updatedPlayer.getRedCards());
            playerToUpdate.setMatchesPlayed(updatedPlayer.getMatchesPlayed());
            playerToUpdate.setPenalties(updatedPlayer.getPenalties());

            playerRepo.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    @Transactional
    public void deletePlayer(String name){
        playerRepo.deleteByName(name);
    }
    public List<String> getAllPositions() {
        return playerRepo.findDistinctPositions();
    }

    @Transactional
    public Player getPlayerById(long id) {
        return playerRepo.findById(id).orElse(null);
    }

    public void deletePlayerById(long id) {
        playerRepo.deleteById(id);
    }
}
