package stocks.marketanalysis.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accuracyTest")
public class AccuracyTest implements Serializable {
	
	@Id
	@GeneratedValue
	private long id;
	@Column
	private double testOp;
	@Column
	private double accuracyValue;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getTestOp() {
		return testOp;
	}
	public void setTestOp(double testOp) {
		this.testOp = testOp;
	}
	public double getAccuracyValue() {
		return accuracyValue;
	}
	public void setAccuracyValue(double accuracyValue) {
		this.accuracyValue = accuracyValue;
	}
	
	

}
