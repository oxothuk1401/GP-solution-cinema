package by.htp.cinema.service;

import by.htp.cinema.dao.DBOrderOperationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by oxothuk1401 on 04.04.2017.
 */

@Service
public class ShowOrderInfoService {
    @Autowired
    private DBOrderOperationDAO dbOrderOperationDAO;

    public String showOrderInfo(long id) {

        String orderInfo = dbOrderOperationDAO.orderInfo(id);

        return orderInfo;
    }
}