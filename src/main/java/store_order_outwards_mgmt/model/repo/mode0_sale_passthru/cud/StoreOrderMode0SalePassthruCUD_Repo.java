package store_order_outwards_mgmt.model.repo.mode0_sale_passthru.cud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import store_order_outwards_mgmt.model.master.StoreOrderOutward;

@Repository("storeOrderMode0SalePassthruCUDRepo")
public interface StoreOrderMode0SalePassthruCUD_Repo extends JpaRepository<StoreOrderOutward, Long> 
{

@Modifying
@Query(value="update STORE_ORDER_OUTWARDS set QTY_ALLOCATED = QTY_ALLOCATED - :neededQty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void subStoreAlloc(@Param(value = "neededQty") Float neededQty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);
	
@Modifying
@Query(value="update STORE_ORDER_OUTWARDS set QTY_ALLOCATED = QTY_ALLOCATED + :neededQty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void addStoreAlloc(@Param(value = "neededQty") Float neededQty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_OUTWARDS set QTY_BOOKED = QTY_BOOKED - :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void subQtyBooked(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_OUTWARDS set QTY_BOOKED = QTY_BOOKED + :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void addQtyBooked(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_OUTWARDS set QTY_REQUESTED = QTY_REQUESTED - :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void subQtyRequested(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_OUTWARDS set QTY_REQUESTED = QTY_REQUESTED + :qty where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void addQtyRequested(@Param(value = "qty") Float qty, @Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_OUTWARDS set IS_BOOKED = 'Y' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateBookStatus(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_OUTWARDS set IS_BOOKED = ' ' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void clearBookStatus(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_OUTWARDS set OKFLAG = 'Y' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateOKFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_OUTWARDS set OKFLAG = ' ' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void clearOKFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_OUTWARDS set DONEFLAG = 'Y' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void updateDoneFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);

@Modifying
@Query(value="update STORE_ORDER_OUTWARDS set DONEFLAG = ' ' where STORE_REQUEST_SEQ_NO = :storeReqSeqNo", nativeQuery = true)
void clearDoneFlag(@Param(value = "storeReqSeqNo") Long storeReqSeqNo);
} 

