package by.htp.cinema.service;

import by.htp.cinema.dao.DBOrderOperationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oxothuk1401 on 04.04.2017.
 */
@Service
public class SeeTimeTableService {
    @Autowired
    private DBOrderOperationDAO dbOrderOperationDAO;

    public List<String> seeTimeTable() {

        List<String> listTimeTable = dbOrderOperationDAO.seeTimeTable();
        System.out.println(listTimeTable + "Service");
        if(listTimeTable==null){
            listTimeTable.add("Today there are no sessions");
            return listTimeTable;
        }
        return listTimeTable;
    }
}

