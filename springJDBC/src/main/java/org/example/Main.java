package org.example;

import java.io.*;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //create a file
        File myTXTFile = getFile();

        //write to the file taking input from console
        writeToFile(myTXTFile);
        //read the file and print to console
        readFromFile(myTXTFile);
//
//      delete file
//        deleteFile(myTXTFile);

    }

    private static void deleteFile(File myTXTFile) {
        System.out.println();
        boolean isFileDeleted = myTXTFile.delete();
        System.out.println("File deleted: " + isFileDeleted);
    }

    private static void readFromFile(File file) {
        try (
                FileReader fileReader = new FileReader(file.getName())) {
            char letter = (char) fileReader.read(); //reads from file one by one, outputs int
            while (fileReader.ready()) {
                System.out.print(letter); //output char one by one
                letter = (char) fileReader.read();
            }
            System.out.print(letter);

        } catch (IOException e) {
            System.out.println("Some error occurred in reading file.");
        }
    }

    private static void writeToFile(File file) {
        try (FileWriter myWriter = new FileWriter(file.getName());
             InputStreamReader isr = new InputStreamReader(System.in);
        ) {
            System.out.println("Enter some letters");
            char letter = (char) isr.read(); //reads from user inputs chars one by one
            while (isr.ready()) {
                myWriter.write(letter);
                letter = (char) isr.read();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static File getFile() {
        File myTXTFile = new File("myNewTxtFile.txt");
        boolean isFileCreated = false;
        try {
            isFileCreated = myTXTFile.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        if (isFileCreated) {
            System.out.println("File created: " + myTXTFile.getName());
        } else {
            System.out.println("File already exists");
        }
        return myTXTFile;
    }

    public void connectToPostGresandDoCrud() throws SQLException {
        //connection start
        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "postgres";
        String pwd = "1245";
        int sid = 6;
        String sqlQuery = "insert into student values (?, ?,?)";


        Connection con = DriverManager.getConnection(url, user, pwd);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Connection Success");
        //connection done

        // create statement
        PreparedStatement st = con.prepareStatement(sqlQuery);
        st.setInt(1, sid);
        st.setString(2, "prags");
        st.setInt(3, sid);

        boolean status = st.execute();
        // exec statement
        System.out.println(status);

        con.close();
        System.out.println("Connection close");

    }
}