package jdbc_04_CRUD;

import java.sql.*;
import java.io.*;

public class InsertData {

    public static final String loadDriver = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/AdvanceJava";
    public static final String username = "root";
    public static final String password = "8235618645";

    public static final String GETALLDATA = "SELECT * FROM crud";
    public static final String GETDATABYID = "SELECT * FROM crud WHERE id=?";
    public static final String INSERTDATA = "INSERT INTO crud VALUES(?,?,?,?)";
    public static final String UPDATEDATA = "UPDATE crud SET name=?,course=?,age=? WHERE id=?";
    public static final String DELETEDATA = "DELETE FROM crud WHERE id=?";

    public static void main(String[] args) {

        try {
            Class.forName(loadDriver);

            Connection con = DriverManager.getConnection(url, username, password);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            PreparedStatement ps1 = con.prepareStatement(GETALLDATA);
            PreparedStatement ps2 = con.prepareStatement(GETDATABYID);
            PreparedStatement ps3 = con.prepareStatement(INSERTDATA);
            PreparedStatement ps4 = con.prepareStatement(UPDATEDATA);
            PreparedStatement ps5 = con.prepareStatement(DELETEDATA);

            while (true) {

                System.out.println("\n------ CRUD Operations ------");
                System.out.println("1. Display All Data");
                System.out.println("2. Display Data by ID");
                System.out.println("3. Insert Data");
                System.out.println("4. Update Data");
                System.out.println("5. Delete Data");
                System.out.println("6. Exit");

                System.out.print("Enter Choice: ");
                String choice = br.readLine();

                switch (choice) {

                case "1":
                  //  ExecuteQuery-select command hai
                    ResultSet rs1 = ps1.executeQuery();

                    while (rs1.next()) {
                        System.out.println(
                                rs1.getInt(1) + "\t" +
                                rs1.getString(2) + "\t" +
                                rs1.getString(3) + "\t" +
                                rs1.getInt(4));
                    }
                    break;

                case "2":

                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(br.readLine());

                    ps2.setInt(1, id);

                    ResultSet rs2 = ps2.executeQuery();

                    if (rs2.next()) {
                        System.out.println(
                                rs2.getInt(1) + "\t" +
                                rs2.getString(2) + "\t" +
                                rs2.getString(3) + "\t" +
                                rs2.getInt(4));
                    } else {
                        System.out.println("Record Not Found");
                    }
                    break;

                case "3":

                    System.out.print("Enter ID: ");
                    int id1 = Integer.parseInt(br.readLine());

                    System.out.print("Enter Name: ");
                    String name = br.readLine();

                    System.out.print("Enter Course: ");
                    String course = br.readLine();

                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(br.readLine());

                    ps3.setInt(1, id1);
                    ps3.setString(2, name);
                    ps3.setString(3, course);
                    ps3.setInt(4, age);

                    int k = ps3.executeUpdate();

                    if (k > 0)
                        System.out.println("Record Inserted Successfully");
                    else
                        System.out.println("Record Not Inserted");

                    break;

                case "4":

                    System.out.print("Enter ID to Update: ");
                    int uid = Integer.parseInt(br.readLine());

                    System.out.print("Enter New Name: ");
                    String uname = br.readLine();

                    System.out.print("Enter New Course: ");
                    String ucourse = br.readLine();

                    System.out.print("Enter New Age: ");
                    int uage = Integer.parseInt(br.readLine());

                    ps4.setString(1, uname);
                    ps4.setString(2, ucourse);
                    ps4.setInt(3, uage);
                    ps4.setInt(4, uid);

                    int u = ps4.executeUpdate();

                    if (u > 0)
                        System.out.println("Record Updated Successfully");
                    else
                        System.out.println("Update Failed");

                    break;

                case "5":

                    System.out.print("Enter ID to Delete: ");
                    int did = Integer.parseInt(br.readLine());

                    ps5.setInt(1, did);

                    int d = ps5.executeUpdate();

                    if (d > 0)
                        System.out.println("Record Deleted Successfully");
                    else
                        System.out.println("Delete Failed");

                    break;

                case "6":
                    System.out.println("Exiting Program...");
                    con.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}