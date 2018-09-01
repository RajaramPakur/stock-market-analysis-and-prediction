/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.analysisparameters;

import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Suraj
 */
public class ProfitLoss {
    public static void main(String[] args) throws SQLException {
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/stockanalysis", "root", "");
            System.out.println("Successful");
            
            
            
             ResultSet rs = null;
             ResultSet rs2 = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        
        String query = "select * from stockdata";
       // System.out.println("sql");
       try{
           ps = conn.prepareStatement(query);
       
       rs = ps.executeQuery();
       
//       ps2 = conn.prepareStatement("select * from profitloss");
//       rs2 = ps2.executeQuery();
       Double temp1 = null,temp3 = null;
       int temp2;
               while(rs.next()){
                   if(rs.getDouble("percentChange")<0){
                       String sql = "insert into profitloss (balanceId,id,loss) values (?,?,?)";
                       ps2 = conn.prepareStatement(sql);
                       
                       ps2.setInt(1, rs.getInt("id"));
                       ps2.setInt(2, rs.getInt("id"));
                     
                       ps2.setDouble(3, -1*rs.getDouble("percentChange"));
                      
                       ps2.execute();
//                      temp1 = -1 * (rs.getDouble("percentChange"));
//                      temp2 = rs.getInt("id");
//                     ps2 = conn.prepareStatement("insert into profitloss values("+temp2+", "+temp2+", 'null', "+temp1+")");
//                     ps2.execute();
                   // ps2.executeUpdate("insert into profitloss values("+temp2+", "+temp2+", 'null', "+temp1+")");
       
                       System.out.println("loss Successful");
                   }
                   else{
//                       temp3 = (rs.getDouble("percentChange"));
//                      temp2 = rs.getInt("id");
//                     ps2 = conn.prepareStatement("insert into profitloss values("+temp2+", "+temp2+", "+temp3+", 'null')");
//                     ps2.execute();

                        String sql2 = "insert into profitloss (balanceId,id,profit) values (?,?,?)";
                       ps2 = conn.prepareStatement(sql2);
                       
                       ps2.setInt(1, rs.getInt("id"));
                       ps2.setInt(2, rs.getInt("id"));
                       ps2.setDouble(3, rs.getDouble("percentChange"));
                    
                       ps2.execute();
                       //  ps2.executeUpdate("insert into profitloss values("+temp2+", "+temp2+", "+temp3+", 'null')"); 
                     
                         System.out.println("profit Successful");
                   }
                       
               }
           
       }
       catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
       }
       
       
       
       
        }
        
        
        
        catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
          
        }
    }
   
        
}
