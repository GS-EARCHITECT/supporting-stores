package store_order_outwards_mgmt.services.mode0_sale_passthru;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import common.domain.model.StoreRegister;
import common.domain.model.StoreRegisterRepo;
import consignment_master_mgmt.model.dto.ConsignmentMaster_DTO;
import store_order_outwards_mgmt.model.repo.mode0_sale_passthru.cud.StoreOrderMode0SalePassthruCUD_Repo;
import store_order_outwards_mgmt.model.repo.mode0_sale_passthru.read.StoreOrderMode0SalePassthruRead_Repo;
import store_stock_movement_mgmt.issue.model.master.StoreIssueMaster;
import store_stock_movement_mgmt.recieve.model.dto.StoreMovementMasterPK;

@Service("storeOrderMode0SalePassthruServ")
public class StoreOrderMode0SalePassthru_Service implements I_StoreOrderMode0SalePassthru_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(StoreRegisterService.class);
	
	@Autowired
    private StoreOrderMode0SalePassthruCUD_Repo storeOrderMode0SalePassthruCUDRepo;
	
	@Autowired
    private StoreOrderMode0SalePassthruRead_Repo storeOrderMode0SalePassthruReadRepo;	
		
	@Autowired
	private Executor asyncExecutor;
		
	/* CREDIT & COUNTER SALE, MODE =0 
	 * 
	 */
	
	@Scheduled(fixedRate=3000)
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
    public CompletableFuture<Void> resource_Alloc() 
    {	    	
		CompletableFuture<CopyOnWriteArrayList<ConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		//logger.info("Sales Job Start");
		Optional<ArrayList<StoreRegister>> storeRegisters = null;
		storeRegisters = storeRegisterRepo.getAllRowsForMode0();
    	Integer item_seq_no_curr = 0;
    	Integer store_seq_no_curr = 0;
    	float needed_qty = (float)0;
    	float allocated_qty = (float)0;
    	float req_qty = (float)0;
    	float book_qty = (float)0;
    	float eqoh = (float)0;
    	float qoh = (float)0;
    	float eff = (float)0;
    	StoreIssueMaster sMaster = null;
    	    	
    	if(storeRegisters.isPresent())
    	{
    	for (int i = 0; i < storeRegisters.get().size(); i++) 
    	{    		
    		book_qty=0;
    		item_seq_no_curr = storeRegisters.get().get(i).getItem_seq_no();
    		store_seq_no_curr = storeRegisters.get().get(i).getStore_request_seq_no();
    		needed_qty = storeRegisters.get().get(i).getQty_requested()-storeRegisters.get().get(i).getQty_allocated();
    		req_qty = storeRegisters.get().get(i).getQty_requested();
    		allocated_qty = storeRegisters.get().get(i).getQty_allocated();
    		qoh = storeRegisterRepo.getItemQty(item_seq_no_curr);
    		eff = getEffectiveQoh(store_seq_no_curr, item_seq_no_curr);
    		eqoh = qoh-eff;    		
    		    			
    		if(needed_qty>0)
    		{	
    		if(eqoh>0)
    		{
    			if(needed_qty<=eqoh)
    			{
    			logger.info("Perfect Alloc & Deducting From Items :"+needed_qty);    			
    			storeRegisterRepo.updateItemMasterDeductQty(needed_qty, item_seq_no_curr);
    			storeRegisterRepo.updateStoreAlloc(needed_qty, store_seq_no_curr);
    			sMaster = createIssueRecord(store_seq_no_curr, item_seq_no_curr, needed_qty);
    			storeIssueRepo.save(sMaster);
    			
    			//book_qty = req_qty -(allocated_qty+needed_qty);
    			}
    			else 
    			{
    			storeRegisterRepo.updateItemMasterQtyToZero(item_seq_no_curr);
        		storeRegisterRepo.updateStoreAlloc(eqoh, store_seq_no_curr);
        		sMaster = createIssueRecord(store_seq_no_curr, item_seq_no_curr, needed_qty);
    			storeIssueRepo.save(sMaster);
        		book_qty = req_qty - (allocated_qty+eqoh);
        		if(checkIfBooked(store_seq_no_curr)==false)
        		{           			
        			logger.info("INSIDE SALE book qty :"+book_qty);
        			storeRegisterRepo.updateQtyBooked(book_qty, store_seq_no_curr);
        			storeRegisterRepo.updateBookStatus(store_seq_no_curr);
        		}
        		}    								
    		}
    		else
    		{
    		if(checkIfBooked(store_seq_no_curr)==false)
    		{
    			logger.info("OUTSIDE Needed :"+needed_qty);
    			logger.info("OUTSIDE SALE book qty :"+needed_qty);
    			storeRegisterRepo.updateQtyBooked(needed_qty, store_seq_no_curr);
    			storeRegisterRepo.updateBookStatus(store_seq_no_curr);
    		}
    		}
    		}
    		}
		}
    	 
    	    	
    	logger.info("Sales Job End");
        return;
    }

	
	
	
}