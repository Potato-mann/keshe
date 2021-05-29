package edu.zust.se.keshe;


import edu.zust.se.keshe.dao.ContestDao;
import edu.zust.se.keshe.dto.ContestDto;
import edu.zust.se.keshe.service.ContestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ContestServiceTest {
    @Autowired
    ContestService contestService;
    @Test
    public void testShowAllContest(){
        List<ContestDto> contestDtoList=contestService.showAllContest();
        System.out.println(contestDtoList);
    }
    @Test
    public void testShowContestStatus(){
        System.out.println(contestService.showContestStatus(1002));
    }
}
