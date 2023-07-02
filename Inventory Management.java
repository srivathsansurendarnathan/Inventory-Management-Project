package InventoryMangement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
public static void main(String[] args) {
// Step 1: Load the driver
Scanner sc=new Scanner(System.in);
try {
Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
// Step 2: Establish Connection
Connection con = null;
try {
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement","root","2250");
}catch(SQLException e) {
e.printStackTrace();
}
if(con!=null) {
System.out.println("Connection Established");
}
else {
System.out.println("Check the Connection");
}
int choice;
do {
   Scanner sc1=new Scanner(System.in);
System.out.println("1.Admin");
System.out.println("2.Agent");
System.out.println("3.Exit");
choice=sc1.nextInt();
switch(choice)
{
case 1:
System.out.println("Enter a username:");
String username=sc1.next();
System.out.println("Enter a password:");
String password=sc1.next();
String sql="select * from login";
try
{
PreparedStatement ps=con.prepareStatement(sql);
ResultSet rs=ps.executeQuery();
boolean isValidUser=false;
while(rs.next())
{
            if(username.equals(rs.getString("username"))&& password.equals(rs.getString("password")))
            {
            isValidUser=true;
System.out.println("login successfully");
System.out.println("1.Add Product");
System.out.println("2.View Product");
System.out.println("3.Logout");

int adminchoice=sc1.nextInt();
switch(adminchoice)
{
case 1:
System.out.println("Enter the Productid:");
String productId=sc1.next();
System.out.println("Enter the ProductName:");
String productName=sc1.next();
System.out.println("Enter a Minimum quanatity:");
String minsellingQuantity=sc1.next();
System.out.println("Enter a Price");
int price=sc1.nextInt();
System.out.println("Enter a Quantity");
int quantity=sc1.nextInt();
String sql1="insert into productdetails value(?,?,?,?,?)";
try
{
PreparedStatement ps1=con.prepareStatement(sql1);
ps1.setString(1,productId);
ps1.setString(2,productName);
ps1.setString(3,minsellingQuantity);
ps1.setLong(4,price);
ps1.setLong(5,quantity);
ps1.executeUpdate();
}
catch (SQLException e) {
e.printStackTrace();
}
System.out.println("values are added");
break;
case 2:
    System.out.println("Display Inventory Details");
    String view="select * from productdetails";
    try
    {
    PreparedStatement view1=con.prepareStatement(view);
    ResultSet rs1 = view1.executeQuery();

       while(rs1.next())
       {
       System.out.println(rs1.getString("ProductId"));
       System.out.println(rs1.getString("ProductName"));
       System.out.println(rs1.getString("MinimumSellingQuantity"));
       System.out.println(rs1.getString("Price"));
       System.out.println(rs1.getString("Quantity"));
       }
      } catch (SQLException e) {
       e.printStackTrace();
      }
     break;
      case 3:
    break;
}}}
            if(!isValidUser) {
            System.out.println("check it once");}}
catch (SQLException e) {
       e.printStackTrace();
      }
break;
case 2:
 
System.out.println("Enter a username:");
String username1=sc.next();
System.out.println("Enter a password:");
String password1=sc.next();
String sql1="select * from login";
try {
PreparedStatement ps=con.prepareStatement(sql1);
ResultSet rs1=ps.executeQuery();
boolean isValidAgent =false;
while(rs1.next()) {
if(username1.equals(rs1.getString("username"))&& password1.equals(rs1.getString("password"))) {
isValidAgent =true;  
  System.out.println("login successfully");
  System.out.println("1.Buy/sell");
System.out.println("2.Logout");
int agentchoice=sc.nextInt();
switch(agentchoice){
case 1:
System.out.println("Enter the action(buy/sell)");
String action=sc.next();
if(action.equalsIgnoreCase("buy")) {
// System.out.println("Add product");
System.out.println("Enter the productid:");
String buyproductId=sc.next();
System.out.println("Enter the productName:");
String buyproductName=sc.next();
System.out.println("Enter a minimum quanatity:");
String buyminsellingQuantity=sc.next();
System.out.println("Enter a price");
int buyprice=sc.nextInt();
System.out.println("Enter a quantity");
int buyquantity=sc.nextInt();
String sql11="insert into productdetails value(?,?,?,?,?)";
try {
PreparedStatement ps1=con.prepareStatement(sql1);
ps1.setString(1,buyproductId);
ps1.setString(2,buyproductName);
ps1.setString(3,buyminsellingQuantity);
ps1.setLong(4,buyprice);
ps1.setLong(5,buyquantity);
ps1.executeUpdate();}
     catch (SQLException e) {
 e.printStackTrace();
 }
System.out.println("values are added");}
else if(action.equalsIgnoreCase("sell")) {
Scanner sc11111=new Scanner(System.in);
System.out.println("Enter the Price");
int sellprice=sc11111.nextInt();
System.out.println("Enter the Quantity");
int sellQuantity=sc11111.nextInt();
int total=sellprice*sellQuantity;
System.out.println("Total:" + total);}
break;
case 2:
             break;}}}
        if (!isValidAgent) {
    System.out.println("Invalid username or password");}
} catch (SQLException e) {
e.printStackTrace();
}
break;
case 3:
break;
}
}while(choice!=3);

}
}
