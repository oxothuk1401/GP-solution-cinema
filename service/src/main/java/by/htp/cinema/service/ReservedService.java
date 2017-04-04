package by.htp.cinema.service;
import by.htp.cinema.dao.DBOrderOperationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservedService {
    @Autowired
    private DBOrderOperationDAO dbOrderOperationDAO;

    public String reserved(String time, String place) {
        String result = dbOrderOperationDAO.reserved(time, place);
        return result;
    }
}
