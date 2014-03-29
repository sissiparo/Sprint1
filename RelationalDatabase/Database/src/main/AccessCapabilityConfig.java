package main;

import persistence.PersistenceUtil;
import entity.AccessCapability;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class AccessCapabilityConfig extends SuperConfig {

	public AccessCapabilityConfig() {
		super();
		initialise();
	}

	public void initialise() {
		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook.getSheet(ColumnIndexes.UE__SHEETNO);

		Cell[] row;

		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);

			if (row.length > 0) {
				String concatCapabilities = row[ColumnIndexes.UE_ACCESSCAPABILITY_COLNO]
						.getContents();
				String[] indivCapabilities = concatCapabilities.split(", ");
				for (int j = 0; j < indivCapabilities.length; j++) {
					if (PersistenceUtil
							.findAccessCapability(indivCapabilities[j]) == null) {
						createAccessCapability(indivCapabilities[j]);
					}
				}

			}

		}

	}

	public void createAccessCapability(String accessCapabilityString) {
		AccessCapability accessCapability = new AccessCapability(
				accessCapabilityString);
		PersistenceUtil.persist(accessCapability);
	}

}
