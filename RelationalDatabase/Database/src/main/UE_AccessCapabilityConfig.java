//package main;
//
//import persistence.PersistenceUtil;
//import entity.UeAccesscapabilityPK;
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//
//public class UE_AccessCapabilityConfig extends SuperConfig {
//
//	public UE_AccessCapabilityConfig() {
//		super();
//		initialise();
//	}
//
//	private void initialise() {
//
//		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
//		Sheet currentSheet = workbook.getSheet(ColumnIndexes.UE__SHEETNO);
//
//		Cell[] row;
//
//		for (int i = 1; i < currentSheet.getRows(); i++) {
//			row = currentSheet.getRow(i);
//
//			if (row.length > 0) {
//
//				String concatCapabilities = row[ColumnIndexes.UE_ACCESSCAPABILITY_COLNO]
//						.getContents();
//				String[] indivCapabilities = concatCapabilities.split(", ");
//				for (int j = 0; j < indivCapabilities.length; j++) {
//					int accessID = PersistenceUtil.findAccessCapability(
//							indivCapabilities[j]).getAccessID();
//					UeAccesscapabilityPK ue_acc = new UeAccesscapabilityPK(
//							row[ColumnIndexes.UE_TAC_COLNO].getContents(),
//							accessID);
//					PersistenceUtil.persist(ue_acc);
//				}
//			}
//		}
//	}
//
//}
