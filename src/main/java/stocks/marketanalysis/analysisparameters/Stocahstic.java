/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.analysisparameters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Suraj
 */
public class Stocahstic {

    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/stockanalysis", "root", "");
            System.out.println("Successful");

            ResultSet rs1 = null;
            ResultSet rs2 = null;
            ResultSet rs3 = null;

            PreparedStatement ps = null;
            PreparedStatement ps2 = null;
            PreparedStatement ps3 = null;
            PreparedStatement ps4 = null;

            String query = "select *from stockdata";
            ps = conn.prepareStatement(query);
            ps2 = conn.prepareStatement(query);
            ps3 = conn.prepareStatement(query);

            //   ps2 =  conn.prepareStatement(query2);
            //rs2 = ps2.executeQuery();
            rs1 = ps.executeQuery();
            rs2 = ps2.executeQuery();
            rs3 = ps3.executeQuery();
            double[] high = new double[935];
            double[] low = new double[935];
            double[] current = new double[935];
            double[] temp = new double[935];
            int count = 0, count1=0;
            System.out.println("hello");
            while (rs1.next()) {
                high[count] = rs1.getDouble("high");
                low[count] = rs1.getDouble("low");
                current[count] = rs1.getDouble("ltp");
                count++;
            }
            int loop = 14;
            int inital = 0;
            double max, min;
            Double stochastic = 0.0;
            max = high[0];
            min = low[0];
            //for (int j = 0; j <= 935; j++) {
            for (int k = inital; k <= loop; k++) {
                for (int i = inital; i <= loop; i++) {
                    if (max < high[i]) {
                        max = high[i];
                        System.out.println(max);
                    }
                    if (min > low[i]) {
                        min = low[i];
                        System.out.println(min);
                    }

                }
                inital++;
                loop++;
                if (loop == 935) {
                    break;
                }
                
                while (rs3.next()) {
                    
                        // %K = (Current Close - Lowest Low)/(Highest High - Lowest Low) * 100
                        //while(count1<935){
                            temp[count1] = (double) ((rs3.getDouble("ltp") - min) / (max - min)) * 100;
                        
//                            stochastic =0.0;
//                            if (count1 < 4) {
//                                
//                                stochastic = stochastic + temp[count1];
//                                count1++;
//                                
//                            } else {
//                                for (int j = count1 - 3; j <= count1; j++) {
//                                    stochastic = stochastic + temp[j];
//                                }
//                            }
//                            count1++;
//                            
//                            break;
//                        }
                    
                    try {


                        System.out.println("insert");
                        String query1 = "insert into stochastic (id,date,high,low,highest,lowest,close,stochastic) values (?,?,?,?,?,?,?,?)";
                        ps4 = conn.prepareStatement(query1);
                        ps4.setInt(1, rs3.getInt("id"));
                        ps4.setString(2, rs3.getString("date"));
                        ps4.setDouble(3, rs3.getDouble("high"));
                        ps4.setDouble(4, rs3.getDouble("low"));
                        ps4.setDouble(5, max);
                        ps4.setDouble(6, min);
                        ps4.setDouble(7, rs3.getDouble("ltp"));
                        ps4.setDouble(8, (temp[count1]));
                        count1++;
                        ps4.execute();
                        break;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
