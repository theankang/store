package com.group5.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group5.store.dao.TeamDAO;
import com.group5.store.model.entity.Team;
import com.group5.store.service.TeamService;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
 
    @Autowired
    private TeamDAO teamDAO;
 
    public void addTeam(Team team) {
        teamDAO.addTeam(team);      
    }
 
    public void updateTeam(Team team) {
        teamDAO.updateTeam(team);
    }
 
    public Team getTeam(int id) {
        return teamDAO.getTeam(id);
    }
 
    public void deleteTeam(int id) {
        teamDAO.deleteTeam(id);
    }
 
    public List<Team> getTeams() {
        return teamDAO.getTeams();
    }
 
}
