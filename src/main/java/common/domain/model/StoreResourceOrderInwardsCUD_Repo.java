package common.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("storeResourceOrderInwardsRepo")
public interface StoreResourceOrderInwardsCUD_Repo extends JpaRepository<StoreOrderInward, Long> 
{

@Modifying
@Query(value="update STORE_ITEM_INWARDS set QOH = 0 where resource_seq_no = :itemSeqNo", nativeQuery = true)
void updateItemMasterQtyToZero(@Param(value = "itemSeqNo") Long itemSeqNo);

@Modifying
@Query(value="update STORE_ORDER_INWARDS set QTY_ALLOCATED = QTY_ALLOCATED + :neededQty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateStoreAlloc(@Param(value = "neededQty") Float neededQty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_INWARDS set QTY_BOOKED = QTY_BOOKED + :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateQtyBooked(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_INWARDS set IS_BOOKED = 'Y' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateBookStatus(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_INWARDS set OKFLAG = :st where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateOkStatus(@Param(value = "storeReqSeqNo") Long storeReqSeqNo, @Param(value = "st") Character st);

@Modifying
@Query(value="update STORE_ORDER_INWARDS set DONEFLAG = :st where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateDoneStatus(@Param(value = "storeReqSeqNo") Long storeReqSeqNo, @Param(value = "st") Character st);
} 

