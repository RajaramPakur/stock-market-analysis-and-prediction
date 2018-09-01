/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Prakash Tyata
 */
@Entity
@Table(name = "bollingerband")
public class BollingerBand implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String date;
    @Column
    private double middlebandValue;
    @Column
    private double upperbandValue;
    @Column
    private double lowerbandValue;
    @Column
    private double standardDeviation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMiddlebandValue() {
        return middlebandValue;
    }

    public void setMiddlebandValue(double middlebandValue) {
        this.middlebandValue = middlebandValue;
    }

    public double getUpperbandValue() {
        return upperbandValue;
    }

    public void setUpperbandValue(double upperbandValue) {
        this.upperbandValue = upperbandValue;
    }

    public double getLowerbandValue() {
        return lowerbandValue;
    }

    public void setLowerbandValue(double lowerbandValue) {
        this.lowerbandValue = lowerbandValue;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }
    
    
    
    
    
    
}
