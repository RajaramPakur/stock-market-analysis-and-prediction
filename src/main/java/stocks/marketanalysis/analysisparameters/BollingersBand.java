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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Suraj
 */
public class BollingersBand {

    public static void main(String[] args) throws SQLException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/stockanalysis", "root", "");
            System.out.println("Successful");

            String str = "select *from stockdata";
            PreparedStatement ps = null;
            ResultSet rs1 = null;
            PreparedStatement ps1 = null;
            PreparedStatement ps3 = null;
            ResultSet rs2 = null;
            ps = conn.prepareStatement(str);
            rs1 = ps.executeQuery(str);

            ResultSet rs3 = null;
            ps3 = conn.prepareStatement(str);
            rs3 = ps3.executeQuery(str);
            ps1 = conn.prepareStatement(str);
            rs2 = ps1.executeQuery(str);
            double sma, cal, upper, middle, lower;
            double[] array = new double[935];
            int count1 = 0;

            List<Double> list = new ArrayList<Double>();

            while (rs1.next()) {
                array[count1] = rs1.getDouble("ltp");
                count1++;
            }

            int count2 = 0,x=0;
            for (int i = 0; i < array.length; i++) {
                sma = 0.0;
                if (count2 < 20) {
                    sma = sma + array[i];
                    count2++;
                    while (rs2.next()) {
                        System.out.println(rs2.getDouble("ltp"));
                        list.add(rs2.getDouble("ltp"));
                        break;
                    }
                } else {
                    for (int j = i - 20; j <= i; j++) {
                        sma = sma + array[j];
                        while (rs2.next()) {
                            list.add(rs2.getDouble("ltp"));
                            break;
                        }
                    }
                }
                cal = sma / 20;
                double std = stDev(list);
//                 Middle Band = 20-day simple moving average (SMA)
//                * Upper Band = 20-day SMA + (20-day standard deviation of price x 2) 
//                * Lower Band = 20-day SMA - (20-day standard deviation of price x 2)

                middle = cal;
                upper = cal + (std * 2);
                lower = cal - (std * 2);

                while (rs3.next()) {

                    try {
                        String sql3 = "insert into bollingerband (id,date,middleband,standardDeviation,upperband,lowerband) values (?,?,?,?,?,?)";
                        ps3 = conn.prepareStatement(sql3);
                        ps3.setInt(1, rs3.getInt("id"));
                        ps3.setString(2, rs3.getString("date"));
                        if (x < 21) {
                            middle=0;
                            std=0;
                            upper=0;
                            lower=0;
                            ps3.setDouble(3, middle);
                            ps3.setDouble(4, std);
                            ps3.setDouble(5, upper);
                            ps3.setDouble(6, lower);
                            x++;
                        }
                        else{
                            ps3.setDouble(3, middle);
                            ps3.setDouble(4, std);
                            ps3.setDouble(5, upper);
                            ps3.setDouble(6, lower);
                        }

                        ps3.execute();
                        break;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }

                System.out.println(std);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public static double stDev(List<Double> list) {
        double sum = 0.0;
        double mean = 0.0;
        double num = 0.0;
        double numi = 0.0;
        double deno = 0.0;

        for (double i : list) {
            sum += i;
            //System.out.println("hello"+i);
        }
        mean = sum / list.size();

        for (double i : list) {
            numi = Math.pow((i - mean), 2);
            num += numi;
        }

        System.out.println(num);
        return Math.sqrt(num / list.size());
    }

}
