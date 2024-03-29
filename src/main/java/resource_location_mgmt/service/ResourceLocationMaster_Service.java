package resource_location_mgmt.service;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import resource_location_mgmt.model.dto.ResourceLocationMaster_DTO;
import resource_location_mgmt.model.master.ResourceLocationMaster;
import resource_location_mgmt.model.master.ResourceLocationMasterPK;
import resource_location_mgmt.model.repo.ResourceLocationMaster_Repo;

@Service("resourceLocationMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceLocationMaster_Service implements I_ResourceLocationMaster_Service 
{

	@Autowired
	private ResourceLocationMaster_Repo resourceLocationMasterRepo;

	public ResourceLocationMaster_DTO newCompanyLocationResource(ResourceLocationMaster_DTO lMaster) 
	{
		ResourceLocationMasterPK resourceLocationMasterPK= new ResourceLocationMasterPK();
		resourceLocationMasterPK.setLocationSeqNo(lMaster.getLocationSeqNo());
		resourceLocationMasterPK.setResourceSeqNo(lMaster.getResourceSeqNo());
		resourceLocationMasterPK.setCompanySeqNo(lMaster.getResourceSeqNo());
		Optional<ResourceLocationMaster> resOptional = resourceLocationMasterRepo.findById(resourceLocationMasterPK);
		ResourceLocationMaster resourceLocationMaster = null;
		ResourceLocationMaster_DTO resourceLocationMasterDTO = null;
		
		if(!resOptional.isPresent())
		{
		resourceLocationMaster = this.setResourceLocationMaster(lMaster);
		resourceLocationMaster.setId(resourceLocationMasterPK);
		resourceLocationMasterDTO=getResourceLocationMaster_DTO(resourceLocationMasterRepo.save(resourceLocationMaster));
		}	
		return resourceLocationMasterDTO;
	}

	public ArrayList<ResourceLocationMaster_DTO> getAllCompanyLocationResources() 
	{
		ArrayList<ResourceLocationMaster> resourceList = (ArrayList<ResourceLocationMaster>) resourceLocationMasterRepo.findAll();
		ArrayList<ResourceLocationMaster_DTO> lMasters = new ArrayList<ResourceLocationMaster_DTO>();
		lMasters = resourceList != null ? this.getResourceLocationMaster_DTOs(resourceList) : null;
		return lMasters;
	}

	public ArrayList<ResourceLocationMaster_DTO> getSelectCompanyResourcesLocations(ArrayList<Long> cos, ArrayList<Long> locs)
	{
		ArrayList<ResourceLocationMaster> lMasters = resourceLocationMasterRepo.getSelectCompanyResourcesLocations(cos, locs);
		ArrayList<ResourceLocationMaster_DTO> resourceLocationMaster_DTOs = new ArrayList<ResourceLocationMaster_DTO>();
		resourceLocationMaster_DTOs = resourceLocationMaster_DTOs != null ? this.getResourceLocationMaster_DTOs(lMasters) : null;
		return resourceLocationMaster_DTOs;
	}
   
	
     public	void setCompanyLocationResourceQoh(Long id, Float qty, Long loc, Long co)
     {
    	ResourceLocationMasterPK resourceLocationMasterPK= new ResourceLocationMasterPK();
 		resourceLocationMasterPK.setLocationSeqNo(loc);
 		resourceLocationMasterPK.setResourceSeqNo(id);
 		resourceLocationMasterPK.setCompanySeqNo(co);
 		
 		if(resourceLocationMasterRepo.existsById(resourceLocationMasterPK))
 		{
 		resourceLocationMasterRepo.setResourceQoh(id, qty, loc, co);	
 		}
 		return;
     }
     	
	public Float getCompanyLocationResourceQoh(Long id, Long co, Long loc)
	{		
		Float qoh = (float) 0;
		ResourceLocationMasterPK resourceLocationMasterPK= new ResourceLocationMasterPK();
 		resourceLocationMasterPK.setLocationSeqNo(loc);
 		resourceLocationMasterPK.setResourceSeqNo(id);
 		resourceLocationMasterPK.setCompanySeqNo(co);
 		
 		if(resourceLocationMasterRepo.existsById(resourceLocationMasterPK))
 		{
 		qoh=resourceLocationMasterRepo.getResourceQoh(id, loc, co);	
 		}
 		
		return qoh;
	}
	
	public void updCompanyResourceLocation(ResourceLocationMaster_DTO lDTO) 
	{
		ResourceLocationMasterPK resourceLocationMasterPK= new ResourceLocationMasterPK();
 		resourceLocationMasterPK.setLocationSeqNo(lDTO.getLocationSeqNo());
 		resourceLocationMasterPK.setResourceSeqNo(lDTO.getResourceSeqNo());
 		resourceLocationMasterPK.setCompanySeqNo(lDTO.getCompanySeqNo());
 		 		
 		if(resourceLocationMasterRepo.existsById(resourceLocationMasterPK))
 		{
 		resourceLocationMasterRepo.save(this.setResourceLocationMaster(lDTO));	
 		}
 	
		return;
	}

	
	public void delAllCompanyLocationResources() 
	{
		resourceLocationMasterRepo.deleteAll();
	}

	public void delSelectCompanyResourcesLocations(ArrayList<Long> cos, ArrayList<Long> locs) 
	{
		resourceLocationMasterRepo.delSelectCompanyResourcesLocations(cos, locs);
		
	}
	
	private ArrayList<ResourceLocationMaster_DTO> getResourceLocationMaster_DTOs(ArrayList<ResourceLocationMaster> lMaster) {
		ResourceLocationMaster_DTO lDTO = null;
		ArrayList<ResourceLocationMaster_DTO> lMasterDTOs = new ArrayList<ResourceLocationMaster_DTO>();		
		for (int i = 0; i < lMaster.size(); i++) {
			lDTO = getResourceLocationMaster_DTO(lMaster.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ResourceLocationMaster_DTO getResourceLocationMaster_DTO(ResourceLocationMaster lMaster) 
	{		
		ResourceLocationMaster_DTO lDTO = new ResourceLocationMaster_DTO();
		lDTO.setLocationSeqNo(lMaster.getId().getLocationSeqNo());		
		lDTO.setResourceSeqNo(lMaster.getId().getResourceSeqNo());
		lDTO.setCompanySeqNo(lMaster.getId().getCompanySeqNo());
		lDTO.setQtySeqNo(lMaster.getQtySeqNo());
		lDTO.setQty(lMaster.getQty());
		return lDTO;
	}

	private ResourceLocationMaster setResourceLocationMaster(ResourceLocationMaster_DTO lDTO) {
		ResourceLocationMaster lMaster = new ResourceLocationMaster();
		ResourceLocationMasterPK resourceLocationMasterPK= new ResourceLocationMasterPK();
 		resourceLocationMasterPK.setLocationSeqNo(lDTO.getLocationSeqNo());
 		resourceLocationMasterPK.setResourceSeqNo(lDTO.getResourceSeqNo());
 		resourceLocationMasterPK.setCompanySeqNo(lDTO.getCompanySeqNo());
 		lMaster.setId(resourceLocationMasterPK);
		lMaster.setQty(lDTO.getQty());
		lMaster.setQtySeqNo(lDTO.getQtySeqNo());
		return lMaster;
	}
}