package by.htp.cinema.dao;

import org.springframework.stereotype.Repository;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Repository
public class DBOrderOperationDAO implements OrderOperationDAO {

    @Override
    public String reserved(String time, String place) {
        String free = "free";
        String booked = "booked";
        FileWriter fw = null;
        FileReader fr = null;

        BufferedWriter bw = null;
        BufferedReader br = null;

        PrintWriter pw = null;

        File catalog = new File("d:\\gitHub\\Reservation-cinema-tickets\\reservation.txt");
        File editedCatalog = new File("d:\\gitHub\\Reservation-cinema-tickets\\reservation.txt");
        try {
            fr = new FileReader(catalog);
            br = new BufferedReader(fr);
            ArrayList<String> fileLines = new ArrayList<>();
            String search = null;
            boolean ok = false;
            long id = 0;
            while ((search = br.readLine()) != null) {
                String[] str = search.split(" ");
                if (str[2].equals(time) & str[3].equals(place) & str[4].equals(free)) {
                    fileLines.add(str[0] + " ");
                    fileLines.add(str[1] + " ");
                    fileLines.add(str[2] + " ");
                    fileLines.add(str[3] + " ");
                    fileLines.add(booked + "\n");
                    ok = true;
                    id = Long.parseLong(str[0]);
                    continue;
                }
                fileLines.add(search + "\n");
            }
            if (ok == false) {
                return "Place # " + place + " on the " + time + " is sealed";
            }
            fw = new FileWriter(editedCatalog);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            for (String str : fileLines) {
                pw.write(str);
            }
            return "You have successfully sealed the place # " + place + " on the " + time + " your order ID = " + id;
        } catch (IOException e) {
            System.out.println("ex2");
        } finally {
            try {
                pw.close();
                br.close();
            } catch (Exception e) {
                System.out.println("ex3");
            }
        }
        return null;
    }

    @Override
    public List<String> seeTimeTable() {
        Scanner in = null;
        List<String> listTimeTable = null;
        try {
            in = new Scanner(new File("d:\\gitHub\\Reservation-cinema-tickets\\timetable.txt"));
            listTimeTable = new ArrayList<>();
            while (in.hasNextLine()) {
                String lines = in.nextLine();
                listTimeTable.add(lines);
            }
            System.out.println(1);
            return listTimeTable;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(2);
        return listTimeTable;
    }

    @Override
    public String orderInfo(long id) {
        System.out.println(id);
        FileReader fr = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        File catalog = new File("d:\\gitHub\\Reservation-cinema-tickets\\reservation.txt");
        try {
            fr = new FileReader(catalog);
            br = new BufferedReader(fr);
            String search = null;
            boolean ok = false;
            while ((search = br.readLine()) != null) {
                String[] str = search.split(" ");
                if (Long.parseLong(str[0])==(id) & str[4].equals("booked")) {
                    ok = true;
                    return "Your reservation for the movie " + str[1] +", at " + str[2]+ ", place number "+str[3]+".";
                }
            }
            if (ok == false) {
                return "ID not found";
            }

        } catch (IOException e) {
            System.out.println("ex2");
        } finally {
            try {
                pw.close();
                br.close();
            } catch (Exception e) {
                System.out.println("ex3");
            }
        }
        return null;
    }

    @Override
    public String cansel(long id) {
        String free = "free";
        String booked = "booked";
        FileWriter fw = null;
        FileReader fr = null;

        BufferedWriter bw = null;
        BufferedReader br = null;

        PrintWriter pw = null;

        File catalog = new File("d:\\gitHub\\Reservation-cinema-tickets\\reservation.txt");
        File editedCatalog = new File("d:\\gitHub\\Reservation-cinema-tickets\\reservation.txt");
        try {
            fr = new FileReader(catalog);
            br = new BufferedReader(fr);
            ArrayList<String> fileLines = new ArrayList<>();
            String search = null;
            boolean ok = false;
            while ((search = br.readLine()) != null) {
                String[] str = search.split(" ");
                if (Long.parseLong(str[0])==(id) & str[4].equals(booked)) {
                    fileLines.add(str[0] + " ");
                    fileLines.add(str[1] + " ");
                    fileLines.add(str[2] + " ");
                    fileLines.add(str[3] + " ");
                    fileLines.add(free + "\n");
                    ok = true;
                    id = Long.parseLong(str[0]);
                    continue;
                }
                fileLines.add(search + "\n");
            }
            if (ok == false) {
                return "Cancellation is not completed";
            }
            fw = new FileWriter(editedCatalog);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            for (String str : fileLines) {
                pw.write(str);
            }
            return "Cancellation of booking ID # "+id+ " completed successfully";
        } catch (IOException e) {
            System.out.println("ex2");
        } finally {
            try {
                pw.close();
                br.close();
            } catch (Exception e) {
                System.out.println("ex3");
            }
        }
        return null;
    }
}