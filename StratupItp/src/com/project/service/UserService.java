package com.project.service;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.print.Doc;
import java.time.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.project.model.User;
import com.project.model.vehicleItem;
import com.project.model.vehicleServices;
import com.project.util.DatabaseConnection;


public class UserService {
	
	
 public static int addUser(User user){
	 int result=0;
	 //get connection 
	 try {
		Connection con = DatabaseConnection.getConnections();
	    PreparedStatement statement = con.prepareStatement("insert into userinfo(UserName,age,address) values (?,?,?)");
	
	    statement.setString(1, user.getUsername());
	    statement.setInt(2, user.getAge());
	    statement.setString(3, user.getAddress());
	    
	    result = statement.executeUpdate();
	    
	    
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return result;
	 
  }
 
 
  public static ArrayList<User> getAllUsers() throws SQLException {
	  
	  ArrayList<User> users = new  ArrayList<>();
	  Connection con = DatabaseConnection.getConnections();
	  String sql = "select UserName,age,address from userinfo";
	  
	  PreparedStatement statement = con.prepareStatement(sql);
	  
	  ResultSet result = statement.executeQuery();
	  
	  while(result.next()) {
		  String uname = result.getString(1);
		  int age   = result.getInt(2);
		  String address = result.getString(3);
		  
		  User user = new User(uname,age,address);
		  
		  users.add(user);
		  
	  }
	   return users;  
	   
	  
	  
  }
  public static int deleteUser(String Username) throws SQLException {
	  
	  Connection con = DatabaseConnection.getConnections();
	  PreparedStatement statement = con.prepareStatement("delete  from userinfo where UserName = ?");
	  
	  statement.setString(1,Username);
	  return(statement.executeUpdate());
	  
  }
  
	public static void pdfDownloads() throws DocumentException, MalformedURLException, IOException, SQLException {
	    ArrayList<User> list = new ArrayList<>();
	    list = UserService.getAllUsers();
		String path = "E:\\Sliit Projects\\Pdfs\\image01.jpg";
		
	    PdfPTable table2 = new PdfPTable(1);
	    
	    Image img = Image.getInstance(path);
	    PdfPCell cell8 = new PdfPCell(img);
	    table2.setWidthPercentage(30);
	    table2.addCell(cell8);
	    
		LocalDate date = LocalDate.now();
        Document document = new Document();
        PdfWriter.getInstance(document,
                new FileOutputStream("E:\\Sliit Projects\\UserInfo"+date+".pdf"));
        
        document.open();
        PdfPTable table = new PdfPTable(3); // 3 columns.

        PdfPCell cell1 = new PdfPCell(new Paragraph("Username"));
        PdfPCell cell2 = new PdfPCell(new Paragraph("age"));
        PdfPCell cell3 = new PdfPCell(new Paragraph("address"));
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        for(User user :list) {
        	  
        	  PdfPCell cell4 = new PdfPCell(new Paragraph(user.getUsername()));
              PdfPCell cell5 = new PdfPCell(new Paragraph(String.valueOf(user.getAge())));
              PdfPCell cell6 = new PdfPCell(new Paragraph(user.getAddress()));
              
              
              table.addCell(cell4);
              table.addCell(cell5);
              table.addCell(cell6);
        }
        document.add(new Paragraph("Users Report"+date));
        document.add(table2);
        document.add(new Paragraph("Rasa moters"));
        document.add(new Paragraph("123/3 ,New kandy road,kaduwela"));
        document.add(new Paragraph("0712324244"));
        document.add(new Paragraph("  "));
        
        document.add(table);
        
        document.add(new Paragraph("  "));
        document.add(new Paragraph("  "));
        document.add(new Paragraph("......................... "));
        document.add(new Paragraph("Manager signature "));
        System.out.println("finished");
        document.close();
		
	}
	
	
	public static ArrayList<vehicleServices> getAllServices() throws SQLException {
		ArrayList<vehicleServices> list = new ArrayList<>();
		Connection con;
		
		con = DatabaseConnection.getConnections1();
		String sql = "select serviceName from service where carId = 'CB123'";
		PreparedStatement std = con.prepareStatement(sql);
		
		ResultSet stq = std.executeQuery();
		
		
		while(stq.next()) {
			
			String name = stq.getString(1);
			
			
			vehicleServices items = new vehicleServices(name);
			list.add(items);
			
			
			
		}
	
		return list;
	
		
		
		
		
		
	}
	public static ArrayList<vehicleItem> getAllServicesItem(String name) throws SQLException {
		ArrayList<vehicleItem> list = new ArrayList<>();
		Connection con;
		
		con = DatabaseConnection.getConnections1();
		String sql = "select ItemName from service_item where serviceName = ?";
		PreparedStatement std = con.prepareStatement(sql);
		std.setString(1, name);
		ResultSet stq = std.executeQuery();
		
		
		while(stq.next()) {
			
			String names = stq.getString(1);
			
			
			vehicleItem items = new vehicleItem(names);
			list.add(items);
			
			
			
		}
	
		return list;
	
		
		
		
		
		
	}
  
 



 

}
