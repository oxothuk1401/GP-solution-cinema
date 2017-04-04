package by.htp.cinema.dao;

import java.io.FileNotFoundException;
import java.util.List;


public interface OrderOperationDAO<T> {

    String reserved(String time, String palce) throws FileNotFoundException;

    List<String> seeTimeTable();

    String orderInfo(long id);

    String cansel(long id);
}
