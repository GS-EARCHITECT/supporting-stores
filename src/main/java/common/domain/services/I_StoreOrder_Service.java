package common.domain.services;

import java.util.concurrent.CompletableFuture;
import store_stock_movement_mgmt.issue.model.master.StoreIssueMaster;

public interface I_StoreOrder_Service
{
	public CompletableFuture<Float> getEffectiveQoh(Long eff_storeSeqNo, Long eff_resourceSeqNo, Long eff_locationSeqNo);
	public CompletableFuture<Boolean> checkIfAllocated(Long storeSeqNo, Long resourceSeqNo);
	public CompletableFuture<Boolean> checkIfBooked(Long storeSeqNo);
	public CompletableFuture<StoreIssueMaster> createIssueRecord(Long storeSeqNo, Long itemseqNo, float qtyIssue);
}