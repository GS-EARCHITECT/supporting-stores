package common.domain.model;

import java.io.Serializable;

public class StoreOrderInward_DTO implements Serializable 
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -260605342577967656L;
	private Long storeRequestSeqNo;
	private Long assetSeqNo;
	private Character doneflag;
	private String fromDttm;
	private Character isBooked;
	private Long jobWorkSeqNo;
	private Long locationSeqNo;
	private Long modeTxn;
	private Float movedQty;
	private Character okflag;
	private Float qtyAllocated;
	private Float qtyBooked;
	private Float qtyRequested;
	private Long qtyUnitSeqNo;
	private Long requestedToCustomerSeqNo;
	private Long requestedToSupplierSeqNo;
	private Long requestorSeqNo;
	private Long resourceSeqNo;
	private String toDttm;

	public StoreOrderInward_DTO() {
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

	public String getFromDttm() {
		return this.fromDttm;
	}

	public void setFromDttm(String fromDttm) {
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

	public String getToDttm() {
		return this.toDttm;
	}

	public void setToDttm(String toDttm) {
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
		StoreOrderInward_DTO other = (StoreOrderInward_DTO) obj;
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

	public StoreOrderInward_DTO(Long storeRequestSeqNo, Long assetSeqNo, Character doneflag, String fromDttm,
			Character isBooked, Long jobWorkSeqNo, Long locationSeqNo, Long modeTxn, Float movedQty, Character okflag,
			Float qtyAllocated, Float qtyBooked, Float qtyRequested, Long qtyUnitSeqNo, Long requestedToCustomerSeqNo,
			Long requestedToSupplierSeqNo, Long requestorSeqNo, Long resourceSeqNo, String toDttm) {
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