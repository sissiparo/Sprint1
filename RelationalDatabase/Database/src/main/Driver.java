package main;

public class Driver {
	
//	public static void main(String[] args){
//		Driver d = new Driver();
//	}

	public Driver() {

		long startTime = System.nanoTime();
		
		CountryConfig cConfig = new CountryConfig();
		AccessCapabilityConfig acConfig = new AccessCapabilityConfig();
		UE_AccessCapabilityConfig ue_ACC = new UE_AccessCapabilityConfig();
		EventCauseConfig ecConfig = new EventCauseConfig();
		FailureConfig fConfig = new FailureConfig();
		ManufacturerConfig mConfig = new ManufacturerConfig();
		MCCMNCConfig mccmncConfig = new MCCMNCConfig();
		UEModelConfig ueModelConfig = new UEModelConfig();
		UserEquipmentConfig ueConfig = new UserEquipmentConfig();
		BaseDataAndCellTableConfig pe = new BaseDataAndCellTableConfig();
		UserConfig ue = new UserConfig();
		
		long endTime = System.nanoTime();
		
		System.out.println("Upload took " + (endTime-startTime)/1000000000 + " seconds");
	}
}
