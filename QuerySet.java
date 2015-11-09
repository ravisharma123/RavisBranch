package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * put all queries here and call from testQuery
 */
public class QuerySet {
  	//view all items' inventories
	public String view_inventory(Statement stmt) throws SQLException
	{
		ResultSet rs = stmt.executeQuery(
				  "SELECT item_id, item_name, quantity "
				+ "FROM item,inventory "
				+ "where item.item_id=inventory.iditem;");
		String result ="ID\tName\tQuantity\n";
		while(rs.next()){
			result+=rs.getInt("item_id")+"\t"+rs.getString("item_name")+"\t"+rs.getInt("quantity")+"\n";
        }
		return result;
	}
        
        public String login(Statement stmt,int id, String pw) throws SQLException 
        {
            ResultSet rs = stmt.executeQuery(
            "SELECT employee_ID FROM employee WHERE employee_ID="+id+" and password ='"+pw+"'"+";");
		
            if(!rs.next()){
                return "Invalid login information";
            }
            else return "You have succesfully logged in";
        }
          public String signUp(Statement stmt) throws SQLException
        {
             String firstName="Lihao";
             String lastName= "Lee";
             String password = "123lihao";
             String jobPosition ="Software Engineer";
             
             int rs = stmt.executeUpdate(
            "INSERT INTO employee(first_name,last_name,password,level) VALUES('"+firstName+"','"+lastName+"','"
             +password+"','"+jobPosition+"');"
             );
		
            if(rs==0){
                return "Please try signing up again";
            }
            else return "You have succesfully created an account";
        }
	
}
