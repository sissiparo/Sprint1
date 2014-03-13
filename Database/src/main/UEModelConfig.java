package main;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import persistence.PersistenceUtil;
import entity.UEModel;

public class UEModelConfig extends SuperConfig {

	public UEModelConfig() {
		super();
		initialise();
	}

	private void initialise() {

		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook.getSheet(ColumnIndexes.UE__SHEETNO);

		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);
			if (PersistenceUtil
					.findUEModelByName(row[ColumnIndexes.UE_MODEL_COLNO]
							.getContents()) == null) {
				createUEModel((row[ColumnIndexes.UE_MODEL_COLNO].getContents()));
			}
		}
	}

	public void createUEModel(String modelName) {

		UEModel ueModel = new UEModel(modelName);
		PersistenceUtil.persist(ueModel);
	}

}
