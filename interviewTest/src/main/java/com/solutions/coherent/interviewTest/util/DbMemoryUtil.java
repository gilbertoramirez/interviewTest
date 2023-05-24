package com.solutions.coherent.interviewTest.util;

import com.solutions.coherent.interviewTest.configuration.DBMemory;
import com.solutions.coherent.interviewTest.model.Reservation;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import static com.solutions.coherent.interviewTest.configuration.ShutdownHook.dbMemory;

public class DbMemoryUtil {

    public static void getRecords(DBMemory dbMemory){
        String DATA_BASE_FILE = "database.dat";
        Path path = Paths.get(DATA_BASE_FILE);

        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo ya existe.");

            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DATA_BASE_FILE))) {
                while (true) {
                    Reservation record = (Reservation) objectInputStream.readObject();
                    dbMemory.addItem(record);
                }
            } catch (EOFException e) {
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setRecords(){
        String DATA_BASE_FILE = "database.dat";
        Set<Reservation> records = dbMemory.getList();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(DATA_BASE_FILE))) {
            for (Reservation record : records) {
                objectOutputStream.writeObject(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
