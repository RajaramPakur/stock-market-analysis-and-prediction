package stocks.marketanalysis.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companytbl")
public class CompanyTbl implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "swiftcode")
	private String swiftcode;
	@Column(name = "tblname")
	private String tblname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSwiftcode() {
		return swiftcode;
	}
	public void setSwiftcode(String swiftcode) {
		this.swiftcode = swiftcode;
	}
	public String getTblname() {
		return tblname;
	}
	public void setTblname(String tblname) {
		this.tblname = tblname;
	}
	
	
}
