/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.analysisparameters;

import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Suraj
 */
public class RSI {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/stockanalysis", "root", ""); conn = DriverManager.getConnection("jdbc:mysql://localhost/stockanalysis", "root", "");
            System.out.println("Successful");

            ResultSet rs = null;
            ResultSet rs2 = null;
            PreparedStatement ps = null;
            PreparedStatement ps2 = null;

            String query = "select * from stockdata";
            // System.out.println("sql");
            try {
                ps = conn.prepareStatement(query);

                rs = ps.executeQuery();

//       ps2 = conn.prepareStatement("select * from profitloss");
//       rs2 = ps2.executeQuery();
                Double temp1 = null, temp3 = null;
                int temp2;
                while (rs.next()) {
                    if (rs.getDouble("percentChange") < 0) {
                        String sql = "insert into profitloss (balanceId,id,loss) values (?,?,?)";
                        ps2 = conn.prepareStatement(sql);

                        ps2.setInt(1, rs.getInt("id"));
                        ps2.setInt(2, rs.getInt("id"));

                        ps2.setDouble(3, -1 * rs.getDouble("percentChange"));

                        ps2.execute();
//                      temp1 = -1 * (rs.getDouble("percentChange"));
//                      temp2 = rs.getInt("id");
//                     ps2 = conn.prepareStatement("insert into profitloss values("+temp2+", "+temp2+", 'null', "+temp1+")");
//                     ps2.execute();
                        // ps2.executeUpdate("insert into profitloss values("+temp2+", "+temp2+", 'null', "+temp1+")");

                        System.out.println("loss Successful");
                    } else {
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

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/stockanalysis", "root", "");
            System.out.println("Successful");

            ResultSet rs1 = null;
            ResultSet rs2 = null;

            PreparedStatement ps = null;
            PreparedStatement ps2 = null;
            PreparedStatement ps3 = null;

            String query = "select * from stockdata inner join profitloss on stockdata.id = profitloss.balanceId ";

            try {
                ps = conn.prepareStatement(query);
                //   ps2 =  conn.prepareStatement(query2);
                //rs2 = ps2.executeQuery();
                rs1 = ps.executeQuery();
                Double avgprofit = null, avgloss = null;
                avgprofit = 0.0;
                avgloss = 0.0;

                while (rs1.next()) {
                    if (rs1.getInt("id") <= 14) {
                        avgprofit = avgprofit + rs1.getDouble("profit");
                        //System.out.println(avgprofit);
                        avgloss = rs1.getDouble("loss") + avgloss;
                        //System.out.println(avgloss);
                        try {
                            String sql2 = "insert into rsi (id,date,price) values (?,?,?)";
                            ps3 = conn.prepareStatement(sql2);
                            rs2 = ps2.executeQuery();

                            ps3.setInt(1, rs1.getInt("id"));
//                        String query2 = "select * from stockdata";
//                        ps2 =  conn.prepareStatement(query2);
//                        rs2 = ps2.executeQuery();

                            ps3.setString(2, rs1.getString("date"));
                            ps3.setDouble(3, rs1.getDouble("ltp"));

                            ps3.execute();
                            System.out.println("Successful 1");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }

                    } else {
                        try {
                            System.out.println(avgprofit);
                            System.out.println(avgloss);
                            String sql3 = "insert into rsi (id,date,price,avgGain,avgLoss,rs,Rsi) values (?,?,?,?,?,?,?)";
                            ps3 = conn.prepareStatement(sql3);

                            Double rs = null, temprsi = null;
                            rs = (Double) (avgprofit / avgloss);
                            temprsi = 100 - (100 / (1 + rs));

                            ps3.setInt(1, rs1.getInt("id"));
                            ps3.setString(2, rs1.getString("date"));
                            ps3.setDouble(3, rs1.getDouble("ltp"));
                            ps3.setDouble(4, avgprofit);
                            ps3.setDouble(5, avgloss);
                            ps3.setDouble(6, rs);
                            ps3.setDouble(7, temprsi);

                            avgprofit = (Double) ((avgprofit * 13) + rs1.getDouble("profit")) / 14;
                            avgloss = (Double) ((avgloss * 13) + rs1.getDouble("loss")) / 14;

                            ps3.execute();
                            System.out.println("Successful 2");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    /*  ////Test inner join
      try{
          Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/stockanalysis", "root", "");
            System.out.println("Successful");
            
            
            
             ResultSet rs = null;
             ResultSet rs2 = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        
        String query = "select * from stockdata inner join profitloss on stockdata.id = profitloss.balanceId ";
       // System.out.println("sql");
       try{
           ps = conn.prepareStatement(query);
       
       rs = ps.executeQuery();
       
//       ps2 = conn.prepareStatement("select * from profitloss");
//       rs2 = ps2.executeQuery();
       while(rs.next()){
           System.out.println(rs.getDouble("loss"));
       }
      }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
      }
      }
       catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
      }*/

}
