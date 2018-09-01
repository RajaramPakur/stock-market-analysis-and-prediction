/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks.marketanalysis.UserInterface;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author RajaramPakur
 */
@Entity
@Table(name = "alldata", catalog = "stockmarketdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Alldata.findAll", query = "SELECT a FROM Alldata a")
    , @NamedQuery(name = "Alldata.findById", query = "SELECT a FROM Alldata a WHERE a.id = :id")
    , @NamedQuery(name = "Alldata.findByClose", query = "SELECT a FROM Alldata a WHERE a.close = :close")
    , @NamedQuery(name = "Alldata.findByDate", query = "SELECT a FROM Alldata a WHERE a.date = :date")
    , @NamedQuery(name = "Alldata.findByHighest", query = "SELECT a FROM Alldata a WHERE a.highest = :highest")
    , @NamedQuery(name = "Alldata.findByLowest", query = "SELECT a FROM Alldata a WHERE a.lowest = :lowest")
    , @NamedQuery(name = "Alldata.findByLtp", query = "SELECT a FROM Alldata a WHERE a.ltp = :ltp")
    , @NamedQuery(name = "Alldata.findByOpen", query = "SELECT a FROM Alldata a WHERE a.open = :open")
    , @NamedQuery(name = "Alldata.findByPercentchange", query = "SELECT a FROM Alldata a WHERE a.percentchange = :percentchange")
    , @NamedQuery(name = "Alldata.findByVolume", query = "SELECT a FROM Alldata a WHERE a.volume = :volume")
    , @NamedQuery(name = "Alldata.findByProfit", query = "SELECT a FROM Alldata a WHERE a.profit = :profit")
    , @NamedQuery(name = "Alldata.findByLoss", query = "SELECT a FROM Alldata a WHERE a.loss = :loss")
    , @NamedQuery(name = "Alldata.findByUpwardPrice", query = "SELECT a FROM Alldata a WHERE a.upwardPrice = :upwardPrice")
    , @NamedQuery(name = "Alldata.findByDownwardPrice", query = "SELECT a FROM Alldata a WHERE a.downwardPrice = :downwardPrice")
    , @NamedQuery(name = "Alldata.findByRs", query = "SELECT a FROM Alldata a WHERE a.rs = :rs")
    , @NamedQuery(name = "Alldata.findByRsi", query = "SELECT a FROM Alldata a WHERE a.rsi = :rsi")
    , @NamedQuery(name = "Alldata.findByEma12", query = "SELECT a FROM Alldata a WHERE a.ema12 = :ema12")
    , @NamedQuery(name = "Alldata.findByEma26", query = "SELECT a FROM Alldata a WHERE a.ema26 = :ema26")
    , @NamedQuery(name = "Alldata.findByMacd", query = "SELECT a FROM Alldata a WHERE a.macd = :macd")
    , @NamedQuery(name = "Alldata.findBySma20", query = "SELECT a FROM Alldata a WHERE a.sma20 = :sma20")
    , @NamedQuery(name = "Alldata.findBySd20", query = "SELECT a FROM Alldata a WHERE a.sd20 = :sd20")
    , @NamedQuery(name = "Alldata.findByUpperband", query = "SELECT a FROM Alldata a WHERE a.upperband = :upperband")
    , @NamedQuery(name = "Alldata.findByLowerband", query = "SELECT a FROM Alldata a WHERE a.lowerband = :lowerband")
    , @NamedQuery(name = "Alldata.findByBandwidth", query = "SELECT a FROM Alldata a WHERE a.bandwidth = :bandwidth")
    , @NamedQuery(name = "Alldata.findByHighestHigh", query = "SELECT a FROM Alldata a WHERE a.highestHigh = :highestHigh")
    , @NamedQuery(name = "Alldata.findByLowestLow", query = "SELECT a FROM Alldata a WHERE a.lowestLow = :lowestLow")
    , @NamedQuery(name = "Alldata.findByCurrentClose", query = "SELECT a FROM Alldata a WHERE a.currentClose = :currentClose")
    , @NamedQuery(name = "Alldata.findByStochastic14", query = "SELECT a FROM Alldata a WHERE a.stochastic14 = :stochastic14")})
public class Alldata implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "close")
    private double close;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "highest")
    private double highest;
    @Basic(optional = false)
    @Column(name = "lowest")
    private double lowest;
    @Basic(optional = false)
    @Column(name = "ltp")
    private double ltp;
    @Basic(optional = false)
    @Column(name = "open")
    private double open;
    @Basic(optional = false)
    @Column(name = "percentchange")
    private double percentchange;
    @Basic(optional = false)
    @Column(name = "volume")
    private double volume;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "profit")
    private Double profit;
    @Column(name = "loss")
    private Double loss;
    @Column(name = "upward_price")
    private Double upwardPrice;
    @Column(name = "downward_price")
    private Double downwardPrice;
    @Column(name = "RS")
    private Double rs;
    @Column(name = "RSI")
    private Double rsi;
    @Column(name = "EMA_12")
    private Double ema12;
    @Column(name = "EMA_26")
    private Double ema26;
    @Column(name = "MACD")
    private Double macd;
    @Column(name = "SMA_20")
    private Double sma20;
    @Column(name = "SD_20")
    private Double sd20;
    @Column(name = "upperband")
    private Double upperband;
    @Column(name = "lowerband")
    private Double lowerband;
    @Column(name = "bandwidth")
    private Double bandwidth;
    @Column(name = "highest_high")
    private Double highestHigh;
    @Column(name = "lowest_low")
    private Double lowestLow;
    @Column(name = "current_close")
    private Double currentClose;
    @Column(name = "stochastic_14")
    private Double stochastic14;

    public Alldata() {
    }

    public Alldata(Integer id) {
        this.id = id;
    }

    public Alldata(Integer id, double close, Date date, double highest, double lowest, double ltp, double open, double percentchange, double volume) {
        this.id = id;
        this.close = close;
        this.date = date;
        this.highest = highest;
        this.lowest = lowest;
        this.ltp = ltp;
        this.open = open;
        this.percentchange = percentchange;
        this.volume = volume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        double oldClose = this.close;
        this.close = close;
        changeSupport.firePropertyChange("close", oldClose, close);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public double getHighest() {
        return highest;
    }

    public void setHighest(double highest) {
        double oldHighest = this.highest;
        this.highest = highest;
        changeSupport.firePropertyChange("highest", oldHighest, highest);
    }

    public double getLowest() {
        return lowest;
    }

    public void setLowest(double lowest) {
        double oldLowest = this.lowest;
        this.lowest = lowest;
        changeSupport.firePropertyChange("lowest", oldLowest, lowest);
    }

    public double getLtp() {
        return ltp;
    }

    public void setLtp(double ltp) {
        double oldLtp = this.ltp;
        this.ltp = ltp;
        changeSupport.firePropertyChange("ltp", oldLtp, ltp);
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        double oldOpen = this.open;
        this.open = open;
        changeSupport.firePropertyChange("open", oldOpen, open);
    }

    public double getPercentchange() {
        return percentchange;
    }

    public void setPercentchange(double percentchange) {
        double oldPercentchange = this.percentchange;
        this.percentchange = percentchange;
        changeSupport.firePropertyChange("percentchange", oldPercentchange, percentchange);
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        double oldVolume = this.volume;
        this.volume = volume;
        changeSupport.firePropertyChange("volume", oldVolume, volume);
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        Double oldProfit = this.profit;
        this.profit = profit;
        changeSupport.firePropertyChange("profit", oldProfit, profit);
    }

    public Double getLoss() {
        return loss;
    }

    public void setLoss(Double loss) {
        Double oldLoss = this.loss;
        this.loss = loss;
        changeSupport.firePropertyChange("loss", oldLoss, loss);
    }

    public Double getUpwardPrice() {
        return upwardPrice;
    }

    public void setUpwardPrice(Double upwardPrice) {
        Double oldUpwardPrice = this.upwardPrice;
        this.upwardPrice = upwardPrice;
        changeSupport.firePropertyChange("upwardPrice", oldUpwardPrice, upwardPrice);
    }

    public Double getDownwardPrice() {
        return downwardPrice;
    }

    public void setDownwardPrice(Double downwardPrice) {
        Double oldDownwardPrice = this.downwardPrice;
        this.downwardPrice = downwardPrice;
        changeSupport.firePropertyChange("downwardPrice", oldDownwardPrice, downwardPrice);
    }

    public Double getRs() {
        return rs;
    }

    public void setRs(Double rs) {
        Double oldRs = this.rs;
        this.rs = rs;
        changeSupport.firePropertyChange("rs", oldRs, rs);
    }

    public Double getRsi() {
        return rsi;
    }

    public void setRsi(Double rsi) {
        Double oldRsi = this.rsi;
        this.rsi = rsi;
        changeSupport.firePropertyChange("rsi", oldRsi, rsi);
    }

    public Double getEma12() {
        return ema12;
    }

    public void setEma12(Double ema12) {
        Double oldEma12 = this.ema12;
        this.ema12 = ema12;
        changeSupport.firePropertyChange("ema12", oldEma12, ema12);
    }

    public Double getEma26() {
        return ema26;
    }

    public void setEma26(Double ema26) {
        Double oldEma26 = this.ema26;
        this.ema26 = ema26;
        changeSupport.firePropertyChange("ema26", oldEma26, ema26);
    }

    public Double getMacd() {
        return macd;
    }

    public void setMacd(Double macd) {
        Double oldMacd = this.macd;
        this.macd = macd;
        changeSupport.firePropertyChange("macd", oldMacd, macd);
    }

    public Double getSma20() {
        return sma20;
    }

    public void setSma20(Double sma20) {
        Double oldSma20 = this.sma20;
        this.sma20 = sma20;
        changeSupport.firePropertyChange("sma20", oldSma20, sma20);
    }

    public Double getSd20() {
        return sd20;
    }

    public void setSd20(Double sd20) {
        Double oldSd20 = this.sd20;
        this.sd20 = sd20;
        changeSupport.firePropertyChange("sd20", oldSd20, sd20);
    }

    public Double getUpperband() {
        return upperband;
    }

    public void setUpperband(Double upperband) {
        Double oldUpperband = this.upperband;
        this.upperband = upperband;
        changeSupport.firePropertyChange("upperband", oldUpperband, upperband);
    }

    public Double getLowerband() {
        return lowerband;
    }

    public void setLowerband(Double lowerband) {
        Double oldLowerband = this.lowerband;
        this.lowerband = lowerband;
        changeSupport.firePropertyChange("lowerband", oldLowerband, lowerband);
    }

    public Double getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Double bandwidth) {
        Double oldBandwidth = this.bandwidth;
        this.bandwidth = bandwidth;
        changeSupport.firePropertyChange("bandwidth", oldBandwidth, bandwidth);
    }

    public Double getHighestHigh() {
        return highestHigh;
    }

    public void setHighestHigh(Double highestHigh) {
        Double oldHighestHigh = this.highestHigh;
        this.highestHigh = highestHigh;
        changeSupport.firePropertyChange("highestHigh", oldHighestHigh, highestHigh);
    }

    public Double getLowestLow() {
        return lowestLow;
    }

    public void setLowestLow(Double lowestLow) {
        Double oldLowestLow = this.lowestLow;
        this.lowestLow = lowestLow;
        changeSupport.firePropertyChange("lowestLow", oldLowestLow, lowestLow);
    }

    public Double getCurrentClose() {
        return currentClose;
    }

    public void setCurrentClose(Double currentClose) {
        Double oldCurrentClose = this.currentClose;
        this.currentClose = currentClose;
        changeSupport.firePropertyChange("currentClose", oldCurrentClose, currentClose);
    }

    public Double getStochastic14() {
        return stochastic14;
    }

    public void setStochastic14(Double stochastic14) {
        Double oldStochastic14 = this.stochastic14;
        this.stochastic14 = stochastic14;
        changeSupport.firePropertyChange("stochastic14", oldStochastic14, stochastic14);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alldata)) {
            return false;
        }
        Alldata other = (Alldata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stocks.marketanalysis.userinterface.Alldata[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
