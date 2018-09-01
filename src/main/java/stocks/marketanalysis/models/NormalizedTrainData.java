package stocks.marketanalysis.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "normalizedtraindata")
public class NormalizedTrainData implements Serializable {
	
	@Id
	@GeneratedValue
	private long id;
        @Column
        private String date;
        @Column
        private double movingavg;
	@Column
	private double bollingerband;
	@Column
	private double rsi;
	@Column
	private double stochastic;
	@Column
	private double peratio;
        @Column
        private double targetvalue;

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

    public double getMovingavg() {
        return movingavg;
    }

    public void setMovingavg(double movingavg) {
        this.movingavg = movingavg;
    }

    public double getBollingerband() {
        return bollingerband;
    }

    public void setBollingerband(double bollingerband) {
        this.bollingerband = bollingerband;
    }

    public double getRsi() {
        return rsi;
    }

    public void setRsi(double rsi) {
        this.rsi = rsi;
    }

    public double getStochastic() {
        return stochastic;
    }

    public void setStochastic(double stochastic) {
        this.stochastic = stochastic;
    }

    public double getPeratio() {
        return peratio;
    }

    public void setPeratio(double peratio) {
        this.peratio = peratio;
    }

    public double getTargetvalue() {
        return targetvalue;
    }

    public void setTargetvalue(double targetvalue) {
        this.targetvalue = targetvalue;
    }
	

}
