package resource_location_mgmt.model.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import resource_location_mgmt.model.master.ResourceLocationMaster;
import resource_location_mgmt.model.master.ResourceLocationMasterPK;

@Repository("resourceLocationMasterRepo")
public interface ResourceLocationMaster_Repo extends JpaRepository<ResourceLocationMaster, ResourceLocationMasterPK> 
{
	@Query(value = "SELECT * FROM RESOURCE_LOCATION_MASTER a WHERE ((a.location_seq_no in :locs) and (a.company_seq_no in :cos)) order by resource_seq_no", nativeQuery = true)
	ArrayList<ResourceLocationMaster> getSelectCompanyResourcesLocations(@Param("cos") ArrayList<Long> cos, @Param("locs") ArrayList<Long> locs);

	@Query(value = "SELECT coalesce(qoh,0) FROM RESOURCE_LOCATION_MASTER a WHERE ((a.resource_seq_no = :id) and (a.location_seq_no = :loc) and (a.company_seq_no = :co))", nativeQuery = true)
	Float getResourceQoh(@Param("id") Long id, @Param("co") Long co, @Param("loc") Long loc);
		
	@Query(value = "update RESOURCE_LOCATION_MASTER set qoh = qoh + :qty WHERE ((a.resource_seq_no = :id) and (a.location_seq_no = :loc) and (a.company_seq_no = :co))", nativeQuery = true)
	void setResourceQoh(@Param("id") Long id, @Param("qty") Float qty, @Param("loc") Long loc, @Param("co") Long co);
	
	@Query(value = "DELETE FROM RESOURCE_LOCATION_MASTER a WHERE ((a.location_seq_no in :locs) and (a.company_seq_no in :cos))", nativeQuery = true)
	void delSelectCompanyResourcesLocations(@Param("cos") ArrayList<Long> cos, @Param("locs") ArrayList<Long> locs);

	@Modifying
	@Query(value="update RESOURCE_LOCATION_MASTER set QOH = QOH - :qoh where resource_seq_no = :itemSeqNo", nativeQuery = true)
	void updateItemMasterDeductQty(@Param(value = "qoh") Float qoh, @Param(value = "itemSeqNo") Long itemSeqNo);

	@Nullable
	@Query(value="SELECT coalesce((select qoh from STORE_ITEM_INWARDS where resource_seq_no = :itemSeqNo),0) AS qoh FROM DUAL", nativeQuery = true)
	Float getItemQty(@Param(value = "itemSeqNo") Long itemSeqNo);

	@Modifying
	@Query(value="update STORE_ITEM_INWARDS set QOH = QOH + :qoh where resource_seq_no = :itemSeqNo", nativeQuery = true)
	void updateItemMasterAddQty(@Param(value = "qoh") Float qoh, @Param(value = "itemSeqNo") Long itemSeqNo);

}
