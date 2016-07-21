package Dao;

import java.util.List;

import domain.ClearFee;

public interface ClearFeeInterface {
	public void addClearFee(ClearFee clf);
	public void deleteClearFee(String[] repairNoList);
	public ClearFee findClearFeeByNo(int repairNo);
	public void updateClearFee(ClearFee clf);
	public List<ClearFee> findClearFee(ClearFee u);
}
