package by.htp.cinema.service;

import by.htp.cinema.dao.DBOrderOperationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by oxothuk1401 on 04.04.2017.
 */

@Service
public class CanselReservation {
    @Autowired
    private DBOrderOperationDAO dbOrderOperationDAO;

    public String canselReservation(long id) {

        String cancel = dbOrderOperationDAO.cansel(id);

        return cancel;
    }
}