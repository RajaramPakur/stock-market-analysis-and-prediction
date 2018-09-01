package stocks.marketanalysis.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "normalizedtestdata")
public class NormalizedTestData implements Serializable {
	
	@Id
	@GeneratedValue
	private long id;
	@Column
	private double rsiNor;
	@Column
	private double bbNor;
	@Column
	private double maNor;
	@Column
	private double peNor;
	@Column
	private double stoNor;
        
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getRsiNor() {
		return rsiNor;
	}
	public void setRsiNor(double rsiNor) {
		this.rsiNor = rsiNor;
	}
	public double getBbNor() {
		return bbNor;
	}
	public void setBbNor(double bbNor) {
		this.bbNor = bbNor;
	}
	public double getMaNor() {
		return maNor;
	}
	public void setMaNor(double maNor) {
		this.maNor = maNor;
	}
	public double getPeNor() {
		return peNor;
	}
	public void setPeNor(double peNor) {
		this.peNor = peNor;
	}
	public double getStoNor() {
		return stoNor;
	}
	public void setStoNor(double stoNor) {
		this.stoNor = stoNor;
	}
	
	

}
