package dbUtils;

import java.io.Serializable;
import java.util.Date;

public class AeTable implements Serializable {
	int PotNo;
	Date DDate;
	float AverageVoltage;
	String Status;

	public AeTable() {
		super();
	}

	public AeTable(int potNo, Date ddDate, float AverageVoltage, String status) {
		super();
		this.PotNo = potNo;
		this.DDate = ddDate;
		this.AverageVoltage = AverageVoltage;
		this.Status = status;
	}

	public int getPotNo() {
		return PotNo;
	}

	public void setPotNo(int potNo) {
		PotNo = potNo;
	}

	public Date getDDate() {
		return DDate;
	}

	public void setDDate(Date ddDate) {
		this.DDate = ddDate;
	}

	public float getAverageVoltage() {
		return AverageVoltage;
	}

	public void setAverageVoltage(float avgV) {
		AverageVoltage = avgV;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "AeTable [PotNo=" + PotNo + ", DDate=" + DDate + ", AverageVoltage=" + AverageVoltage + ", Status=" + Status + "]";
	}

}
