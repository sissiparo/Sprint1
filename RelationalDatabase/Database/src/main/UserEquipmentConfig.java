package main;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import persistence.PersistenceUtil;
import entity.Manufacturer;
import entity.UEModel;
import entity.UserEquipment;

public class UserEquipmentConfig extends SuperConfig {
	
	private Manufacturer manufacturer;
	private UEModel model;

	public UserEquipmentConfig() {
		super();
		initialise();
	}

	private void initialise() {

		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook.getSheet(ColumnIndexes.UE__SHEETNO);

		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);

			if (row.length > 0) {

				String manufacturerName = row[ColumnIndexes.UE_MANUFACTURER_COLNO]
						.getContents();
				
				manufacturer = PersistenceUtil.findManufacturerByName(
						manufacturerName);
				int manufacturerId = manufacturer.getManufacturerID();
				
				
				model = PersistenceUtil.findUEModelByName(
						row[ColumnIndexes.UE_MODEL_COLNO].getContents());
				
				int modelID = model.getModelId();

				createUserEquipment(
						(row[ColumnIndexes.UE_TAC_COLNO].getContents()),
						manufacturer, model,
						row[ColumnIndexes.UE_UETYPE_COLNO].getContents(),
						row[ColumnIndexes.UE_OS_COLNO].getContents(),
						row[ColumnIndexes.UE_INPUTMODE_COLNO].getContents());

			}

		}
	}

	public void createUserEquipment(String tac, Manufacturer ueManufacturer,
			UEModel ueModel, String ueTypeID, String ueOperatingSys,
			String ueInputMode) {
		UserEquipment userEquipment = new UserEquipment(tac, manufacturer,
				model, ueTypeID, ueOperatingSys, ueInputMode);
		PersistenceUtil.persist(userEquipment);
	}

}
