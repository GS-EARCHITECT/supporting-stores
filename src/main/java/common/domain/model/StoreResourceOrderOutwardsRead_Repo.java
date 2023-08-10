package common.domain.model;

import java.sql.Timestamp;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("storeResourceOrderOutwardsReadRepo")
public interface StoreResourceOrderOutwardsRead_Repo extends JpaRepository<StoreOrderOutward, Long> 
{

// GET STATUS	
@Query(value = "SELECT is_booked FROM STORE_ORDER_OUTWARDS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Character getIsbookedStatus(@Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT doneflag FROM STORE_ORDER_OUTWARDS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Character getIsDoneStatus(@Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT okflag FROM STORE_ORDER_OUTWARDS where STORE_REQUEST_SEQ_NO=:storeReqSeqNo",nativeQuery = true) 
Character getIsOkStatus(@Param("storeReqSeqNo") Long storeReqSeqNo);

//GET TOTAL QTYs For Requests
@Query(value = "SELECT COALESCE(SUM(qty_allocated),0) FROM STORE_ORDER_OUTWARDS where (upper(trim(doneflag)) <> 'Y' and (resource_seq_no=:itemSeqNo || asset_seq_no=:itemSeqNo) and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn= :mode and REQUESTED_TO_CUSTOMER_SEQ_NO = :tCNo and REQUESTED_TO_SUPPLIER_SEQ_NO = :tSNo)",nativeQuery = true) 
Float getTotalQtyAllocForItem(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode, @Param("tCNo") Long tCNo, @Param("tSNo") Long tSNo);

@Query(value = "SELECT COALESCE(SUM(qty_requested),0) FROM FROM STORE_ORDER_OUTWARDS where (upper(trim(doneflag)) <> 'Y' and (resource_seq_no=:itemSeqNo || asset_seq_no=:itemSeqNo) and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn= :mode and REQUESTED_TO_CUSTOMER_SEQ_NO = :tCNo and REQUESTED_TO_SUPPLIER_SEQ_NO = :tSNo)",nativeQuery = true) 
Float getTotalQtyRequestedForItem(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode, @Param("tCNo") Long tCNo, @Param("tSNo") Long tSNo);

@Query(value = "SELECT COALESCE(SUM(qty_booked),0) FROM STORE_ORDER_OUTWARDS where (upper(trim(doneflag)) <> 'Y' and (resource_seq_no=:itemSeqNo || asset_seq_no=:itemSeqNo) and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn= :mode and REQUESTED_TO_CUSTOMER_SEQ_NO = :tCNo and REQUESTED_TO_SUPPLIER_SEQ_NO = :tSNo)",nativeQuery = true) 
Float getTotalQtyBookedForItem(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode, @Param("tCNo") Long tCNo, @Param("tSNo") Long tSNo);

@Query(value = "SELECT COALESCE(SUM(qty_moved),0) FROM FROM STORE_ORDER_OUTWARDS where (upper(trim(doneflag)) <> 'Y' and (resource_seq_no=:itemSeqNo || asset_seq_no=:itemSeqNo) and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn= :mode and REQUESTED_TO_CUSTOMER_SEQ_NO = :tCNo and REQUESTED_TO_SUPPLIER_SEQ_NO = :tSNo)",nativeQuery = true) 
Float getTotalQtyMovedForItem(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode, @Param("tCNo") Long tCNo, @Param("tSNo") Long tSNo);

//GET QTY For Request
@Query(value = "SELECT COALESCE(qty_allocated,0) FROM STORE_ORDER_OUTWARDS where STORE_REQUEST_SEQ_NO = :storeReqSeqNo",nativeQuery = true) 
Float getQtyAllocForItem(@Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT COALESCE(qty_requested,0) FROM STORE_ORDER_OUTWARDS where STORE_REQUEST_SEQ_NO = :storeReqSeqNo",nativeQuery = true) 
Float getQtyRequestedForItem(@Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT COALESCE(qty_allocated,0) FROM STORE_ORDER_OUTWARDS where STORE_REQUEST_SEQ_NO = :storeReqSeqNo",nativeQuery = true) 
Float getQtyBookedForItem(@Param("storeReqSeqNo") Long storeReqSeqNo);

@Query(value = "SELECT COALESCE(SUM(qty_moved),0) FROM FROM STORE_ORDER_OUTWARDS where STORE_REQUEST_SEQ_NO = :storeReqSeqNo",nativeQuery = true) 
Float getQtyMovedForItem(@Param("storeReqSeqNo") Long storeReqSeqNo);

// GET Orders Before Request
@Query(value = "SELECT COALESCE(SUM(qty_allocated),0) FROM STORE_ORDER_OUTWARDS where (upper(trim(doneflag)) <> 'Y' and (resource_seq_no=:itemSeqNo || asset_seq_no=:itemSeqNo) and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn= :mode and REQUESTED_TO_CUSTOMER_SEQ_NO = :tCNo and REQUESTED_TO_SUPPLIER_SEQ_NO = :tSNo)",nativeQuery = true) 
Float getTotalQtyAllocForItemBeforeRequest(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode, @Param("tCNo") Long tCNo, @Param("tSNo") Long tSNo);

@Query(value = "SELECT COALESCE(SUM(qty_requested),0) FROM FROM STORE_ORDER_OUTWARDS where (upper(trim(doneflag)) <> 'Y' and (resource_seq_no=:itemSeqNo || asset_seq_no=:itemSeqNo) and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn= :mode and REQUESTED_TO_CUSTOMER_SEQ_NO = :tCNo and REQUESTED_TO_SUPPLIER_SEQ_NO = :tSNo)",nativeQuery = true) 
Float getTotalQtyRequestedForItemBeforeRequest(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode, @Param("tCNo") Long tCNo, @Param("tSNo") Long tSNo);

@Query(value = "SELECT COALESCE(SUM(qty_booked),0) FROM STORE_ORDER_OUTWARDS where (upper(trim(doneflag)) <> 'Y' and (resource_seq_no=:itemSeqNo || asset_seq_no=:itemSeqNo) and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn= :mode and REQUESTED_TO_CUSTOMER_SEQ_NO = :tCNo and REQUESTED_TO_SUPPLIER_SEQ_NO = :tSNo)",nativeQuery = true) 
Float getTotalQtyBookedForItemBeforeRequest(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode, @Param("tCNo") Long tCNo, @Param("tSNo") Long tSNo);

@Query(value = "SELECT COALESCE(SUM(qty_moved),0) FROM FROM STORE_ORDER_OUTWARDS where (upper(trim(doneflag)) <> 'Y' and (resource_seq_no=:itemSeqNo || asset_seq_no=:itemSeqNo) and STORE_REQUEST_SEQ_NO<:storeReqSeqNo and mode_txn= :mode and REQUESTED_TO_CUSTOMER_SEQ_NO = :tCNo and REQUESTED_TO_SUPPLIER_SEQ_NO = :tSNo)",nativeQuery = true) 
Float getTotalQtyMovedForItemBeforeRequest(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode, @Param("tCNo") Long tCNo, @Param("tSNo") Long tSNo);

//GET Orders Before Or Between Time
@Query(value = "SELECT COALESCE(SUM(qty_allocated),0) FROM STORE_ORDER_OUTWARDS where (upper(trim(doneflag)) <> 'Y' and (resource_seq_no=:itemSeqNo || asset_seq_no=:itemSeqNo) and FROM_DTTM <= :dTTm and mode_txn= :mode and REQUESTED_TO_CUSTOMER_SEQ_NO = :tCNo and REQUESTED_TO_SUPPLIER_SEQ_NO = :tSNo)",nativeQuery = true) 
Float getTotalQtyAllocForItemBeforeTime(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode, @Param("tCNo") Long tCNo, @Param("tSNo") Long tSNo, @Param("dTTm") Timestamp dTTm);

@Query(value = "SELECT COALESCE(SUM(qty_requested),0) FROM FROM STORE_ORDER_OUTWARDS where (upper(trim(doneflag)) <> 'Y' and (resource_seq_no=:itemSeqNo || asset_seq_no=:itemSeqNo) and FROM_DTTM <= :dTTm and mode_txn= :mode and REQUESTED_TO_CUSTOMER_SEQ_NO = :tCNo and REQUESTED_TO_SUPPLIER_SEQ_NO = :tSNo)",nativeQuery = true) 
Float getTotalQtyRequestedForItemBeforeTime(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode, @Param("tCNo") Long tCNo, @Param("tSNo") Long tSNo, @Param("dTTm") Timestamp dTTm);

@Query(value = "SELECT COALESCE(SUM(qty_booked),0) FROM STORE_ORDER_OUTWARDS where (upper(trim(doneflag)) <> 'Y' and (resource_seq_no=:itemSeqNo || asset_seq_no=:itemSeqNo) and FROM_DTTM <= :dTTm and mode_txn= :mode and REQUESTED_TO_CUSTOMER_SEQ_NO = :tCNo and REQUESTED_TO_SUPPLIER_SEQ_NO = :tSNo)",nativeQuery = true) 
Float getTotalQtyBookedForItemBeforeTime(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode, @Param("tCNo") Long tCNo, @Param("tSNo") Long tSNo, @Param("dTTm") Timestamp dTTm);

@Query(value = "SELECT COALESCE(SUM(qty_moved),0) FROM FROM STORE_ORDER_OUTWARDS where (upper(trim(doneflag)) <> 'Y' and (resource_seq_no=:itemSeqNo || asset_seq_no=:itemSeqNo) and FROM_DTTM <= :dTTm and mode_txn= :mode and REQUESTED_TO_CUSTOMER_SEQ_NO = :tCNo and REQUESTED_TO_SUPPLIER_SEQ_NO = :tSNo)",nativeQuery = true) 
Float getTotalQtyMovedForItemBeforeTime(@Param("storeReqSeqNo") Long storeReqSeqNo, @Param("itemSeqNo") Long itemSeqNo, @Param("mode") Short mode, @Param("tCNo") Long tCNo, @Param("tSNo") Long tSNo, @Param("dTTm") Timestamp dTTm);

//GET All
@Query(value = "SELECT COALESCE(count(*),0) FROM STORE_ORDER_OUTWARDS where upper(trim(doneflag)) <> 'Y'",nativeQuery = true) 
Long getTotalRowCount();

@Query(value = "SELECT * FROM STORE_ORDER_OUTWARDS where upper(trim(doneflag)) <> 'Y' ORDER BY STORE_REQUEST_SEQ_NO, resource_seq_no",nativeQuery = true) 
CopyOnWriteArrayList<StoreOrderInward> getAllRows();

@Query(value = "SELECT * FROM STORE_ORDER_OUTWARDS  where upper(trim(doneflag)) <> 'Y' and MODE_TXN= :mode ORDER BY STORE_REQUEST_SEQ_NO, resource_seq_no",nativeQuery = true) 
CopyOnWriteArrayList<StoreOrderInward> getAllRowsForMode(@Param("mode") Short mode);	
		
@Query(value = "SELECT store_request_seq_no FROM STORE_ORDER_OUTWARDS where upper(trim(doneflag)) <> 'Y' and MODE_TXN= :mode ORDER BY STORE_REQUEST_SEQ_NO",nativeQuery = true) 
CopyOnWriteArrayList<Long> getAllSeqNosForMode(@Param("mode") Short mode);
}
