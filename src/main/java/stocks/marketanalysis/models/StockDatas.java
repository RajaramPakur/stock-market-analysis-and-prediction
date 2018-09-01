package stocks.marketanalysis.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "stockdatas")
public class StockDatas {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
	
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false, columnDefinition = "date")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(nullable = false)
	private double open;
	@Column(nullable = false)
	private double close;
	@Column(nullable = false)
	private double highest;
	@Column(nullable = false)
	private double lowest;
	@Column(nullable = false)
	private double volume;
	@Column(nullable = false)
	private double percentchange;
	@Column(nullable = false)
	private double ltp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
            int oldId = this.id;
		this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
            Date oldDate = this.date;
		this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
            double oldOpen = this.open;
		this.open = open;
        changeSupport.firePropertyChange("open", oldOpen, open);
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
            double oldClose = this.close;
		this.close = close;
        changeSupport.firePropertyChange("close", oldClose, close);
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
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
            double oldVolume = this.volume;
		this.volume = volume;
        changeSupport.firePropertyChange("volume", oldVolume, volume);
	}
	public double getPercentchange() {
		return percentchange;
	}
	public void setPercentchange(double percentchange) {
            double oldPercentchange = this.percentchange;
		this.percentchange = percentchange;
        changeSupport.firePropertyChange("percentchange", oldPercentchange, percentchange);
	}
	public double getLtp() {
		return ltp;
	}
	public void setLtp(double ltp) {
            double oldLtp = this.ltp;
		this.ltp = ltp;
        changeSupport.firePropertyChange("ltp", oldLtp, ltp);
	}

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
	
	
	

}
