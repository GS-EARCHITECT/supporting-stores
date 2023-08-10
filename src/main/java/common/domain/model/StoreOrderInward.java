package common.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the STORE_ORDER_OUTWARDS database table.
 * 
 */
@Entity
@Table(name = "STORE_ORDER_INWARDS")
public class StoreOrderInward implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = -562104474423742470L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_REQUEST_SEQUENCE")
	@SequenceGenerator(name = "STORE_REQUEST_SEQUENCE", sequenceName = "STORE_REQUEST_SEQUENCE", allocationSize = 1)
	@Column(name = "STORE_REQUEST_SEQ_NO")
	private Long storeRequestSeqNo;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "DONEFLAG")
	private Character doneflag;

	@Column(name = "FROM_DTTM")
	private Timestamp fromDttm;

	@Column(name = "IS_BOOKED")
	private Character isBooked;

	@Column(name = "JOB_WORK_SEQ_NO")
	private Long jobWorkSeqNo;

	@Column(name = "LOCATION_SEQ_NO")
	private Long locationSeqNo;

	@Column(name = "MODE_TXN")
	private Long modeTxn;

	@Column(name = "MOVED_QTY")
	private Float movedQty;

	@Column(name = "OKFLAG")
	private Character okflag;

	@Column(name = "QTY_ALLOCATED")
	private Float qtyAllocated;

	@Column(name = "QTY_BOOKED")
	private Float qtyBooked;

	@Column(name = "QTY_REQUESTED")
	private Float qtyRequested;

	@Column(name = "QTY_UNIT_SEQ_NO")
	private Long qtyUnitSeqNo;

	@Column(name = "REQUESTED_TO_CUSTOMER_SEQ_NO")
	private Long requestedToCustomerSeqNo;

	@Column(name = "REQUESTED_TO_SUPPLIER_SEQ_NO")
	private Long requestedToSupplierSeqNo;

	@Column(name = "REQUESTOR_SEQ_NO")
	private Long requestorSeqNo;

	@Column(name = "RESOURCE_SEQ_NO")
	private Long resourceSeqNo;

	@Column(name = "TO_DTTM")
	private Timestamp toDttm;

	public StoreOrderInward() {
	}

	public Long getStoreRequestSeqNo() {
		return this.storeRequestSeqNo;
	}

	public void setStoreRequestSeqNo(Long storeRequestSeqNo) {
		this.storeRequestSeqNo = storeRequestSeqNo;
	}

	public Long getAssetSeqNo() {
		return this.assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Character getDoneflag() {
		return this.doneflag;
	}

	public void setDoneflag(Character doneflag) {
		this.doneflag = doneflag;
	}

	public Timestamp getFromDttm() {
		return this.fromDttm;
	}

	public void setFromDttm(Timestamp fromDttm) {
		this.fromDttm = fromDttm;
	}

	public Character getIsBooked() {
		return this.isBooked;
	}

	public void setIsBooked(Character isBooked) {
		this.isBooked = isBooked;
	}

	public Long getJobWorkSeqNo() {
		return this.jobWorkSeqNo;
	}

	public void setJobWorkSeqNo(Long jobWorkSeqNo) {
		this.jobWorkSeqNo = jobWorkSeqNo;
	}

	public Long getLocationSeqNo() {
		return this.locationSeqNo;
	}

	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
	}

	public Long getModeTxn() {
		return this.modeTxn;
	}

	public void setModeTxn(Long modeTxn) {
		this.modeTxn = modeTxn;
	}

	public Float getMovedQty() {
		return this.movedQty;
	}

	public void setMovedQty(Float movedQty) {
		this.movedQty = movedQty;
	}

	public Character getOkflag() {
		return this.okflag;
	}

	public void setOkflag(Character okflag) {
		this.okflag = okflag;
	}

	public Float getQtyAllocated() {
		return this.qtyAllocated;
	}

	public void setQtyAllocated(Float qtyAllocated) {
		this.qtyAllocated = qtyAllocated;
	}

	public Float getQtyBooked() {
		return this.qtyBooked;
	}

	public void setQtyBooked(Float qtyBooked) {
		this.qtyBooked = qtyBooked;
	}

	public Float getQtyRequested() {
		return this.qtyRequested;
	}

	public void setQtyRequested(Float qtyRequested) {
		this.qtyRequested = qtyRequested;
	}

	public Long getQtyUnitSeqNo() {
		return this.qtyUnitSeqNo;
	}

	public void setQtyUnitSeqNo(Long qtyUnitSeqNo) {
		this.qtyUnitSeqNo = qtyUnitSeqNo;
	}

	public Long getRequestedToCustomerSeqNo() {
		return this.requestedToCustomerSeqNo;
	}

	public void setRequestedToCustomerSeqNo(Long requestedToCustomerSeqNo) {
		this.requestedToCustomerSeqNo = requestedToCustomerSeqNo;
	}

	public Long getRequestedToSupplierSeqNo() {
		return this.requestedToSupplierSeqNo;
	}

	public void setRequestedToSupplierSeqNo(Long requestedToSupplierSeqNo) {
		this.requestedToSupplierSeqNo = requestedToSupplierSeqNo;
	}

	public Long getRequestorSeqNo() {
		return this.requestorSeqNo;
	}

	public void setRequestorSeqNo(Long requestorSeqNo) {
		this.requestorSeqNo = requestorSeqNo;
	}

	public Long getResourceSeqNo() {
		return this.resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Timestamp getToDttm() {
		return this.toDttm;
	}

	public void setToDttm(Timestamp toDttm) {
		this.toDttm = toDttm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetSeqNo == null) ? 0 : assetSeqNo.hashCode());
		result = prime * result + ((locationSeqNo == null) ? 0 : locationSeqNo.hashCode());
		result = prime * result + ((requestedToCustomerSeqNo == null) ? 0 : requestedToCustomerSeqNo.hashCode());
		result = prime * result + ((requestedToSupplierSeqNo == null) ? 0 : requestedToSupplierSeqNo.hashCode());
		result = prime * result + ((resourceSeqNo == null) ? 0 : resourceSeqNo.hashCode());
		result = prime * result + ((storeRequestSeqNo == null) ? 0 : storeRequestSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreOrderInward other = (StoreOrderInward) obj;
		if (assetSeqNo == null) {
			if (other.assetSeqNo != null)
				return false;
		} else if (!assetSeqNo.equals(other.assetSeqNo))
			return false;
		if (locationSeqNo == null) {
			if (other.locationSeqNo != null)
				return false;
		} else if (!locationSeqNo.equals(other.locationSeqNo))
			return false;
		if (requestedToCustomerSeqNo == null) {
			if (other.requestedToCustomerSeqNo != null)
				return false;
		} else if (!requestedToCustomerSeqNo.equals(other.requestedToCustomerSeqNo))
			return false;
		if (requestedToSupplierSeqNo == null) {
			if (other.requestedToSupplierSeqNo != null)
				return false;
		} else if (!requestedToSupplierSeqNo.equals(other.requestedToSupplierSeqNo))
			return false;
		if (resourceSeqNo == null) {
			if (other.resourceSeqNo != null)
				return false;
		} else if (!resourceSeqNo.equals(other.resourceSeqNo))
			return false;
		if (storeRequestSeqNo == null) {
			if (other.storeRequestSeqNo != null)
				return false;
		} else if (!storeRequestSeqNo.equals(other.storeRequestSeqNo))
			return false;
		return true;
	}

	public StoreOrderInward(Long storeRequestSeqNo, Long assetSeqNo, Character doneflag, Timestamp fromDttm,
			Character isBooked, Long jobWorkSeqNo, Long locationSeqNo, Long modeTxn, Float movedQty, Character okflag,
			Float qtyAllocated, Float qtyBooked, Float qtyRequested, Long qtyUnitSeqNo, Long requestedToCustomerSeqNo,
			Long requestedToSupplierSeqNo, Long requestorSeqNo, Long resourceSeqNo, Timestamp toDttm) {
		super();
		this.storeRequestSeqNo = storeRequestSeqNo;
		this.assetSeqNo = assetSeqNo;
		this.doneflag = doneflag;
		this.fromDttm = fromDttm;
		this.isBooked = isBooked;
		this.jobWorkSeqNo = jobWorkSeqNo;
		this.locationSeqNo = locationSeqNo;
		this.modeTxn = modeTxn;
		this.movedQty = movedQty;
		this.okflag = okflag;
		this.qtyAllocated = qtyAllocated;
		this.qtyBooked = qtyBooked;
		this.qtyRequested = qtyRequested;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
		this.requestedToCustomerSeqNo = requestedToCustomerSeqNo;
		this.requestedToSupplierSeqNo = requestedToSupplierSeqNo;
		this.requestorSeqNo = requestorSeqNo;
		this.resourceSeqNo = resourceSeqNo;
		this.toDttm = toDttm;
	}

}