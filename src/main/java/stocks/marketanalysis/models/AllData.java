/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author RajaramPakur
 */
@Entity
@Table(name = "alldata")
public class AllData implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    @Id
    @GeneratedValue
    private int id;
    @Column
    private double close;
   @Column(nullable = false, columnDefinition = "date")
   @Temporal(TemporalType.DATE)
    private Date date;
   @Column
   private double highest;
   @Column
   private double lowest;
   @Column
   private double ltp;
   @Column
   private double open;
   @Column
   private double percentchange;
   @Column
   private double volume;
   @Column
   private double profit;
   @Column
   private double loss;
   @Column
   private double upward_price;
   @Column
   private double downward_price;
   @Column
   private double RS;
   @Column
   private double RSI;
   @Column
   private double EMA_12;
   @Column
   private double EMA_26;
   @Column
   private double MACD;
   @Column
   private double SMA_20;
   @Column
   private double SD_20;
   @Column
   private double upperband;
   @Column
   private double lowerband;
   @Column
   private double bandwidth;
   @Column
   private double highest_high;
   @Column
   private double lowest_low;
   @Column
   private double current_close;
   @Column
   private double stochastic_14;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    /**
     * @return the close
     */
    public double getClose() {
        return close;
    }

    /**
     * @param close the close to set
     */
    public void setClose(double close) {
        double oldClose = this.close;
        this.close = close;
        changeSupport.firePropertyChange("close", oldClose, close);
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    /**
     * @return the highest
     */
    public double getHighest() {
        return highest;
    }

    /**
     * @param highest the highest to set
     */
    public void setHighest(double highest) {
        double oldHighest = this.highest;
        this.highest = highest;
        changeSupport.firePropertyChange("highest", oldHighest, highest);
    }

    /**
     * @return the lowest
     */
    public double getLowest() {
        return lowest;
    }

    /**
     * @param lowest the lowest to set
     */
    public void setLowest(double lowest) {
        double oldLowest = this.lowest;
        this.lowest = lowest;
        changeSupport.firePropertyChange("lowest", oldLowest, lowest);
    }

    /**
     * @return the ltp
     */
    public double getLtp() {
        return ltp;
    }

    /**
     * @param ltp the ltp to set
     */
    public void setLtp(double ltp) {
        double oldLtp = this.ltp;
        this.ltp = ltp;
        changeSupport.firePropertyChange("ltp", oldLtp, ltp);
    }

    /**
     * @return the open
     */
    public double getOpen() {
        return open;
    }

    /**
     * @param open the open to set
     */
    public void setOpen(double open) {
        double oldOpen = this.open;
        this.open = open;
        changeSupport.firePropertyChange("open", oldOpen, open);
    }

    /**
     * @return the percentchange
     */
    public double getPercentchange() {
        return percentchange;
    }

    /**
     * @param percentchange the percentchange to set
     */
    public void setPercentchange(double percentchange) {
        double oldPercentchange = this.percentchange;
        this.percentchange = percentchange;
        changeSupport.firePropertyChange("percentchange", oldPercentchange, percentchange);
    }

    /**
     * @return the volume
     */
    public double getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(double volume) {
        double oldVolume = this.volume;
        this.volume = volume;
        changeSupport.firePropertyChange("volume", oldVolume, volume);
    }

    /**
     * @return the profit
     */
    public double getProfit() {
        return profit;
    }

    /**
     * @param profit the profit to set
     */
    public void setProfit(double profit) {
        double oldProfit = this.profit;
        this.profit = profit;
        changeSupport.firePropertyChange("profit", oldProfit, profit);
    }

    /**
     * @return the loss
     */
    public double getLoss() {
        return loss;
    }

    /**
     * @param loss the loss to set
     */
    public void setLoss(double loss) {
        double oldLoss = this.loss;
        this.loss = loss;
        changeSupport.firePropertyChange("loss", oldLoss, loss);
    }

    /**
     * @return the upward_price
     */
    public double getUpward_price() {
        return upward_price;
    }

    /**
     * @param upward_price the upward_price to set
     */
    public void setUpward_price(double upward_price) {
        double oldUpward_price = this.upward_price;
        this.upward_price = upward_price;
        changeSupport.firePropertyChange("upward_price", oldUpward_price, upward_price);
    }

    /**
     * @return the downward_price
     */
    public double getDownward_price() {
        return downward_price;
    }

    /**
     * @param downward_price the downward_price to set
     */
    public void setDownward_price(double downward_price) {
        double oldDownward_price = this.downward_price;
        this.downward_price = downward_price;
        changeSupport.firePropertyChange("downward_price", oldDownward_price, downward_price);
    }

    /**
     * @return the RS
     */
    public double getRS() {
        return RS;
    }

    /**
     * @param RS the RS to set
     */
    public void setRS(double RS) {
        double oldRS = this.RS;
        this.RS = RS;
        changeSupport.firePropertyChange("RS", oldRS, RS);
    }

    /**
     * @return the RSI
     */
    public double getRSI() {
        return RSI;
    }

    /**
     * @param RSI the RSI to set
     */
    public void setRSI(double RSI) {
        double oldRSI = this.RSI;
        this.RSI = RSI;
        changeSupport.firePropertyChange("RSI", oldRSI, RSI);
    }

    /**
     * @return the EMA_12
     */
    public double getEMA_12() {
        return EMA_12;
    }

    /**
     * @param EMA_12 the EMA_12 to set
     */
    public void setEMA_12(double EMA_12) {
        double oldEMA_12 = this.EMA_12;
        this.EMA_12 = EMA_12;
        changeSupport.firePropertyChange("EMA_12", oldEMA_12, EMA_12);
    }

    /**
     * @return the EMA_26
     */
    public double getEMA_26() {
        return EMA_26;
    }

    /**
     * @param EMA_26 the EMA_26 to set
     */
    public void setEMA_26(double EMA_26) {
        double oldEMA_26 = this.EMA_26;
        this.EMA_26 = EMA_26;
        changeSupport.firePropertyChange("EMA_26", oldEMA_26, EMA_26);
    }

    /**
     * @return the MACD
     */
    public double getMACD() {
        return MACD;
    }

    /**
     * @param MACD the MACD to set
     */
    public void setMACD(double MACD) {
        double oldMACD = this.MACD;
        this.MACD = MACD;
        changeSupport.firePropertyChange("MACD", oldMACD, MACD);
    }

    /**
     * @return the SMA_20
     */
    public double getSMA_20() {
        return SMA_20;
    }

    /**
     * @param SMA_20 the SMA_20 to set
     */
    public void setSMA_20(double SMA_20) {
        double oldSMA_20 = this.SMA_20;
        this.SMA_20 = SMA_20;
        changeSupport.firePropertyChange("SMA_20", oldSMA_20, SMA_20);
    }

    /**
     * @return the SD_20
     */
    public double getSD_20() {
        return SD_20;
    }

    /**
     * @param SD_20 the SD_20 to set
     */
    public void setSD_20(double SD_20) {
        double oldSD_20 = this.SD_20;
        this.SD_20 = SD_20;
        changeSupport.firePropertyChange("SD_20", oldSD_20, SD_20);
    }

    /**
     * @return the upperband
     */
    public double getUpperband() {
        return upperband;
    }

    /**
     * @param upperband the upperband to set
     */
    public void setUpperband(double upperband) {
        double oldUpperband = this.upperband;
        this.upperband = upperband;
        changeSupport.firePropertyChange("upperband", oldUpperband, upperband);
    }

    /**
     * @return the lowerband
     */
    public double getLowerband() {
        return lowerband;
    }

    /**
     * @param lowerband the lowerband to set
     */
    public void setLowerband(double lowerband) {
        double oldLowerband = this.lowerband;
        this.lowerband = lowerband;
        changeSupport.firePropertyChange("lowerband", oldLowerband, lowerband);
    }

    /**
     * @return the bandwidth
     */
    public double getBandwidth() {
        return bandwidth;
    }

    /**
     * @param bandwidth the bandwidth to set
     */
    public void setBandwidth(double bandwidth) {
        double oldBandwidth = this.bandwidth;
        this.bandwidth = bandwidth;
        changeSupport.firePropertyChange("bandwidth", oldBandwidth, bandwidth);
    }

    /**
     * @return the highest_high
     */
    public double getHighest_high() {
        return highest_high;
    }

    /**
     * @param highest_high the highest_high to set
     */
    public void setHighest_high(double highest_high) {
        double oldHighest_high = this.highest_high;
        this.highest_high = highest_high;
        changeSupport.firePropertyChange("highest_high", oldHighest_high, highest_high);
    }

    /**
     * @return the lowest_low
     */
    public double getLowest_low() {
        return lowest_low;
    }

    /**
     * @param lowest_low the lowest_low to set
     */
    public void setLowest_low(double lowest_low) {
        double oldLowest_low = this.lowest_low;
        this.lowest_low = lowest_low;
        changeSupport.firePropertyChange("lowest_low", oldLowest_low, lowest_low);
    }

    /**
     * @return the current_close
     */
    public double getCurrent_close() {
        return current_close;
    }

    /**
     * @param current_close the current_close to set
     */
    public void setCurrent_close(double current_close) {
        double oldCurrent_close = this.current_close;
        this.current_close = current_close;
        changeSupport.firePropertyChange("current_close", oldCurrent_close, current_close);
    }

    /**
     * @return the stochastic_14
     */
    public double getStochastic_14() {
        return stochastic_14;
    }

    /**
     * @param stochastic_14 the stochastic_14 to set
     */
    public void setStochastic_14(double stochastic_14) {
        double oldStochastic_14 = this.stochastic_14;
        this.stochastic_14 = stochastic_14;
        changeSupport.firePropertyChange("stochastic_14", oldStochastic_14, stochastic_14);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
   
   
}
