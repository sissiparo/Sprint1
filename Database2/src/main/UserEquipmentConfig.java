package main;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import persistence.PersistenceUtil;
import entity.UserEquipment;

public class UserEquipmentConfig extends SuperConfig {

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

				String manufacturer = row[ColumnIndexes.UE_MANUFACTURER_COLNO]
						.getContents();
				int manufacturerId = PersistenceUtil.findManufacturerByName(
						manufacturer).getManufacturerID();
				int model = PersistenceUtil.findUEModelByName(
						row[ColumnIndexes.UE_MODEL_COLNO].getContents())
						.getModelID();

				createUserEquipment(
						(row[ColumnIndexes.UE_TAC_COLNO].getContents()),
						manufacturerId, model,
						row[ColumnIndexes.UE_UETYPE_COLNO].getContents(),
						row[ColumnIndexes.UE_OS_COLNO].getContents(),
						row[ColumnIndexes.UE_INPUTMODE_COLNO].getContents());

			}

		}
	}

	public void createUserEquipment(String tac, int ueManufacturer,
			int ueModel, String ueTypeID, String ueOperatingSys,
			String ueInputMode) {
		UserEquipment userEquipment = new UserEquipment(tac, ueManufacturer,
				ueModel, ueTypeID, ueOperatingSys, ueInputMode);
		PersistenceUtil.persist(userEquipment);
	}

}
