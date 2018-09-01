package stocks.marketanalysis.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stockanalysis")
public class StockAnalysis implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	@Column
	private double rsi;
	@Column
	private double macd;
	@Column
	private double bb;
	@Column
	private double stochastic;
	@Column
	private double analystsentiment;
	@Column
	private double ma;
	
	@OneToOne
	@JoinColumn(name = "stockdata_id")
	private StockData stockdata_id;
	
	public StockData getStockdata_id() {
		return stockdata_id;
	}
	public void setStockdata_id(StockData stockdata_id) {
		this.stockdata_id = stockdata_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getRsi() {
		return rsi;
	}
	public void setRsi(double rsi) {
		this.rsi = rsi;
	}
	public double getMacd() {
		return macd;
	}
	public void setMacd(double macd) {
		this.macd = macd;
	}
	public double getBb() {
		return bb;
	}
	public void setBb(double bb) {
		this.bb = bb;
	}
	public double getStochastic() {
		return stochastic;
	}
	public void setStochastic(double stochastic) {
		this.stochastic = stochastic;
	}
	public double getAnalystsentiment() {
		return analystsentiment;
	}
	public void setAnalystsentiment(double analystsentiment) {
		this.analystsentiment = analystsentiment;
	}
	public double getMa() {
		return ma;
	}
	public void setMa(double ma) {
		this.ma = ma;
	}
	
	
	
}
