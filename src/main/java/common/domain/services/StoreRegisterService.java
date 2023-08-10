package common.domain.services;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

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
import store_stock_movement_mgmt.issue.model.master.StoreIssueMaster;
import store_stock_movement_mgmt.issue.model.repo.read.StoreIssueRepo;
import store_stock_movement_mgmt.recieve.model.dto.StoreMovementMasterPK;

@Service("storeOrderServ")
public class StoreOrder_Service implements I_StoreOrder_Service
{

//	private static final Logger logger = LoggerFactory.getLogger(StoreRegisterService.class);
	
	@Autowired
    private StoreRegisterRepo storeRegisterRepo;
		
	@Autowired(required=true)
    private StoreIssueRepo storeIssueRepo;
	
	
	private CompletableFuture<Float> getEffectiveQoh(Integer eff_storeSeqNo, Integer eff_itemSeqNo) 
    {
		float eff_totReqQty = 0;
		float eff_totAllocQty = 0;
		
		eff_totReqQty = storeRegisterRepo.getTotalQtyRequestedForItem(eff_storeSeqNo, eff_itemSeqNo);
		eff_totAllocQty = storeRegisterRepo.getTotalQtyAllocForItem(eff_storeSeqNo, eff_itemSeqNo);
		logger.info("SALE seq no :"+eff_storeSeqNo);
		logger.info("SALE req total :"+eff_totReqQty);
		logger.info("SALE alloc total :"+eff_totAllocQty);
	    
		return (eff_totReqQty - eff_totAllocQty);	
		}
	
	private boolean checkIfAllocated(Integer storeSeqNo, Integer itemSeqNo) 
    {
		float totReqQty = 0;
		float totAllocQty = 0;				
		boolean retStatus = false; 
				
			totReqQty = storeRegisterRepo.getTotalQtyRequestedForItem(storeSeqNo, itemSeqNo);
			totAllocQty = storeRegisterRepo.getTotalQtyAllocForItem(storeSeqNo, itemSeqNo);
			
			if(totReqQty - totAllocQty>0)
				{	
				retStatus = true;
			}	
		    	
		return retStatus;
    	}
	
	private boolean checkIfBooked(Integer storeSeqNo) 
    {
		Optional<Character> status;
		boolean retStatus=false;
		
			status = storeRegisterRepo.getIsbookedStatus(storeSeqNo);
	    	
			if(status.isPresent() && status.get()!=null)
			{	
	    	if(Character.toUpperCase(status.get())=='Y')
	    	{
	    		retStatus= true;
	    	}
	    	else 
	    	{
	    		retStatus=  false;	    	
        	}
			}    			
		
		return retStatus; 
		}

	private StoreIssueMaster createIssueRecord(Integer storeSeqNo, Integer itemseqNo, float qtyIssue)
	{
		StoreIssueMaster storeIssueMaster = new StoreIssueMaster();
		StoreMovementMasterPK smPK = new StoreMovementMasterPK();
		Timestamp reqDate = new Timestamp(System.currentTimeMillis());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String reqDate2 =	formatter.format(reqDate.toLocalDateTime());		
		Timestamp reqDate3 = Timestamp.valueOf(reqDate2);		
		smPK.setRequest_on(reqDate3);
		smPK.setStore_request_seq_no(storeSeqNo);
		smPK.setItem_seq_no(itemseqNo);
		storeIssueMaster.setId(smPK);
		storeIssueMaster.setRequest_qty(qtyIssue);
		return storeIssueMaster;
	}

	
	
}