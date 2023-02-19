import java.io.Console;
import java.sql.*;
import java.util.*;

public class login {

  public static void main(String[] args) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/employeeDB",
        "root",
        "root@3854"
      );
      Statement stmt = con.createStatement();
      String userid;
      String username, password;
      String name1 = null, password1 = null;
      String userid1 = null;
      Scanner sc = new Scanner(System.in);
      Console cnsl = System.console();

      System.out.println(
        " Welcome to Employee Management System \n1 To Login \n2 to Create New Account "
      );
      System.out.println(" Enter Choice ");

      int choice = sc.nextInt();

      if (choice == 1) {
        int x = 1, flag = 0;
        while (x > 0) {
          System.out.println(" Enter User ID ");
          userid = sc.next();

          System.out.print("\nEnter username:");
          username = cnsl.readLine();

          System.out.print("Enter Password: ");
          char ch[] = cnsl.readPassword();
          password = new String(ch);

          ResultSet rs = stmt.executeQuery("SELECT * FROM login");

          while (rs.next()) {
            userid1 = rs.getString(1);

            name1 = rs.getString("username");

            password1 = rs.getString("password");

            if (username.equals(name1) && password.equals(password1)) {
              flag++;
              break;
            }
          }
          if (flag == 0) {
            System.out.println("\n  Name doesn't exist ");
            break;
          } else {
            System.out.println(
              "\n----------------------------------------------------------"
            );
            System.out.println("\n Login Successful");
            int l = 0;
            while (l == 0) {
              login Login1 = new login();
              System.out.println("\n 1. Enter  Employee data ");
              System.out.println("\n 2. update  Employee data ");
              System.out.println("\n 3. delete  Employee data");
              System.out.println("\n 4. view  Employee data ");
              System.out.println("\n 5.  exit");
              System.out.print("\nenter choice: ");
              int choice1;
              choice1 = sc.nextInt();
              switch (choice1) {
                case 1:
                  Login1.add();
                  break;
                case 2:
                  Login1.update();
                  break;
                case 3:
                  Login1.delete();
                  break;
                case 4:
                  Login1.view();

                  return;
                default:
                  System.out.println("enter correct choice");
              }
            }
          }
        }
      } else if (choice == 2) {
        System.out.println(" Enter User ID ");
        userid = sc.next();

        System.out.print("\nEnter username:");
        username = cnsl.readLine();

        System.out.print("Create Password: ");
        password = cnsl.readLine();

        String sql =
          "INSERT INTO login VALUES('" +
          userid +
          "','" +
          username +
          "','" +
          password +
          "');";
        stmt.executeUpdate(sql);
        System.out.println("login created Successfully..");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void add() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/employeeDB",
        "root",
        "root@3854"
      );
      Statement stmt = con.createStatement();

      String create_Employee_database_q =
        "create database if not exists employeeDB";
      String create_Employee_data_table_q =
        "create table if not exists Employee_data (Emp_id  int ,Name varchar(50),Gender varchar(20), mobile_no int(10), email varchar(50), address varchar(255), city varchar(50), age int )";
      String Select_db = "use employeeDB";

      stmt.executeUpdate(create_Employee_database_q);
      stmt.executeUpdate(Select_db);
      stmt.executeUpdate(create_Employee_data_table_q);

      Scanner sc = new Scanner(System.in);
      Console cnsl = System.console();

      System.out.print("Enter Emp id :");
      int Emp_id = sc.nextInt();

      System.out.print("\nEnter name:");
      String name = cnsl.readLine();

      System.out.println("\n Enter Gender");
      String Gender = cnsl.readLine();

      System.out.print("Enter mobile no:");
      int mobile_no = sc.nextInt();

      System.out.print("Enter email:");
      String email = cnsl.readLine();

      System.out.print("Enter address:");
      String address = cnsl.readLine();

      System.out.print("Enter city:");
      String city = cnsl.readLine();

      System.out.print("Enter age:");
      int age = sc.nextInt();

      String sql =
        "INSERT INTO Employee_data VALUES('" +
        Emp_id +
        "','" +
        name +
        "','" +
        Gender +
        "','" +
        mobile_no +
        "','" +
        email +
        "','" +
        address +
        "','" +
        city +
        "','" +
        age +
        "' )";
      stmt.executeUpdate(sql);
      System.out.println("Data added Successfully..");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void update() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/employeeDB",
        "root",
        "root@3854"
      );

      Statement update_stmt = con.createStatement();
      Scanner us = new Scanner(System.in);

      System.out.println("\n1. Enter Emp_id no to update ");
      int Emp_id = us.nextInt();
      int choice;

      String check_c = "Y";
      while (check_c != "N" || check_c != "n") {
        System.out.println("\nA. Update Name  ");
        System.out.print("\nB Update Gender");
        System.out.println("\nC. Update mobile no ");
        System.out.println("\nD. Update email ");
        System.out.println("\nE. Update address ");
        System.out.println("\nF. Update city ");
        System.out.println("\nG. Update age ");
        System.out.println("\nH. Exit ");
        System.out.print("\nEnter choice: ");
        choice = us.nextInt();
      }

      int choice1;
      choice1 = us.nextInt();
      switch (choice1) {
        case 1:
          System.out.print("\nEnter new username: ");
          String name = us.next();
          String update_name_q =
            "update Employee_data set name = '" +
            name +
            "' where Emp_id = '" +
            Emp_id +
            "'";
          update_stmt.executeUpdate(update_name_q);
          System.out.println("\nName updated successfully..");
          break;
        case 2:
          System.out.println("\n Enter new Gender ");
          String Gender = us.next();
          String update_Gender_q =
            "update _Employee_data set Gender = '" +
            Gender +
            "' where Emp_id = '" +
            Emp_id +
            "' ";
          update_stmt.executeUpdate(update_Gender_q);
          System.out.println("\nGender updated successfully..");
          break;
        case 3:
          System.out.print("\nEnter new mobile no: ");
          int mobile_no = us.nextInt();
          String update_mobile_no_q =
            "update Employee_data set mobile_no = '" +
            mobile_no +
            "' where Emp_id = '" +
            Emp_id +
            "'";
          update_stmt.executeUpdate(update_mobile_no_q);
          System.out.println("\nMobile no updated successfully..");
          break;
        case 4:
          System.out.print("\nEnter new email: ");
          String email = us.next();
          String update_email_q =
            "update Employee_data set email = '" +
            email +
            "' where Emp_id = '" +
            Emp_id +
            "'";
          update_stmt.executeUpdate(update_email_q);
          System.out.println("\nEmail updated successfully..");
          break;
        case 5:
          System.out.print("\nEnter new address: ");
          String address = us.next();
          String update_address_q =
            "update Employee_data set address = '" +
            address +
            "' where Emp_id = '" +
            Emp_id +
            "'";
          update_stmt.executeUpdate(update_address_q);
          System.out.println("\nAddress updated successfully..");
          break;
        case 6:
          System.out.print("\nEnter new city: ");
          String city = us.next();
          String update_city_q =
            "update Employee_data set city = '" +
            city +
            "' where Emp_id = '" +
            Emp_id +
            "'";
          update_stmt.executeUpdate(update_city_q);
          System.out.println("\nCity updated successfully..");
          break;
        case 7:
          System.out.print("\nEnter new age: ");
          int age = us.nextInt();
          String update_age_q =
            "update Employee_data set age = '" +
            age +
            "' where Emp_id = '" +
            Emp_id +
            "'";
          update_stmt.executeUpdate(update_age_q);
          System.out.println("\nAge updated successfully..");

          break;
        case 8:
          System.exit(0);
          break;
        default:
          System.out.println("\nInvalid choice..");
          break;
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void view() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/employeeDB",
        "root",
        "root@3854"
      );

      Scanner us = new Scanner(System.in);
      Statement view_stmt = con.createStatement();
      int Emp_id;
      System.out.print("\nEnter Emp id : ");
      Emp_id = us.nextInt();
      String view_q =
        "select * from Employee_data where Emp_id = '" + Emp_id + "'";
      ResultSet rs = view_stmt.executeQuery(view_q);
      while (rs.next()) {
        System.out.println("\nEmp id: " + rs.getInt(1));
        System.out.println("\nName: " + rs.getString(2));
        System.out.println("\nGender: " + rs.getString(3));
        System.out.println("\nMobile no: " + rs.getInt(4));
        System.out.println("\nEmail: " + rs.getString(5));
        System.out.println("\nAddress: " + rs.getString(6));
        System.out.println("\nCity: " + rs.getString(7));
        System.out.println("\nAge: " + rs.getInt(8));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  void delete() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/employeeDB",
        "root",
        "root@3854"
      );

      Scanner us = new Scanner(System.in);
      Statement delete_stmt = con.createStatement();
      int Emp_id;
      System.out.print("\nEnter Emp id : ");
      Emp_id = us.nextInt();
      String delete_q =
        "delete from Employee_data where Emp_id = '" + Emp_id + "'";
      delete_stmt.executeUpdate(delete_q);
      System.out.println("\nData deleted successfully..");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
