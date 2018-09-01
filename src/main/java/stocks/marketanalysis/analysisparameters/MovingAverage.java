/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.analysisparameters;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Suraj
 */
public class MovingAverage {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/stockanalysis", "root", "");
            System.out.println("Successful");

            ResultSet rs1 = null;
            ResultSet rs2 = null;

            PreparedStatement ps = null;
            PreparedStatement ps2 = null;
            PreparedStatement ps3 = null;
            String query = "select * from stockdata ";
//       String query = "select * from stockdata inner join profitloss on stockdata.id = profitloss.balanceId ";

            try {
                ps = conn.prepareStatement(query);
                ps2 = conn.prepareStatement(query);

                //   ps2 =  conn.prepareStatement(query2);
                //rs2 = ps2.executeQuery();
                rs1 = ps.executeQuery();
                rs2 = ps2.executeQuery();
                Double sma = null, ema = null;
                sma = 0.0;
                ema = 0.0;
                Double sma1;
                Double time = 10.0;
                Double multiplier;
                int x=0;

                double[] array = new double[935];
                int count1 = 0;
                while (rs2.next()) {
                    array[count1] = rs2.getDouble("ltp");
                    count1++;
                }

                int count2 = 0;
                for (int i = 0; i < array.length; i++) {
                    sma = 0.0;
                    if (count2 < 11) {
                        sma = sma + array[i];
                        count2++;
                    } else {
                        for (int j = i - 10; j <= i; j++) {
                            sma = sma + array[j];
                        }
                    }
                    multiplier = (2 / (time + 1));
                    //EMA: {Close - EMA(previous day)} x multiplier + EMA(previous day)
                    if (ema == 0) {
                        ema = sma/10;
                    }
                    System.out.println(ema);
                    
                    while (rs1.next()) {
                        ema = ((rs1.getDouble("ltp") - ema) * multiplier) + ema;
                        try {
                            //System.out.println("insert");
                            String sql3 = "insert into movingavg (id,date,price,sma,multiplier,ema) values (?,?,?,?,?,?)";
                            ps3 = conn.prepareStatement(sql3);
                            ps3.setInt(1, rs1.getInt("id"));
                            ps3.setString(2, rs1.getString("date"));
                            ps3.setDouble(3, rs1.getDouble("ltp"));
                            if (x < 11) {
                                sma = 0.0;
                                multiplier = 0.0;
                                ema = 0.0;
                                ps3.setDouble(4, (sma / 10));
                                ps3.setDouble(5, multiplier);
                                ps3.setDouble(6, ema);
                                x++;
                            } else {
                                ps3.setDouble(4, (sma / 10));
                                ps3.setDouble(5, multiplier);
                                ps3.setDouble(6, ema);
                            }

                            ps3.execute();
                            break;
                            // rs1.next();
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
}
