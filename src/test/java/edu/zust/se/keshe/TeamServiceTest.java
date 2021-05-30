package edu.zust.se.keshe;

import edu.zust.se.keshe.dto.TeamDto;
import edu.zust.se.keshe.service.TeamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeamServiceTest {
    @Autowired
    TeamService teamService;
    @Test
    public void testShowMyTeam(){
        List<TeamDto> teamDtoList=teamService.showMyTeam(1180199152);
        for(TeamDto teamDto :teamDtoList){
            System.out.println(teamDto);
        }
    }
    @Test
    public void testShowStudentInTeam(){
        System.out.println(teamService.showStudentInTeam(17));
    }
}
