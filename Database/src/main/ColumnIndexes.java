package main;

interface ColumnIndexes {

	static final int BASEDATA__SHEETNO = 0;
	static final int BASEDATA_DATE_COLNO = 0;
	static final int BASEDATA_EVENTID_COLNO = 1;
	static final int BASEDATA_FAILURECLASS_COLNO = 2;
	static final int BASEDATA_UETYPE_COLNO = 3;
	static final int BASEDATA_MARKET_COLNO = 4;
	static final int BASEDATA_OPERATOR_COLNO = 5;
	static final int BASEDATA_CELLID_COLNO = 6;
	static final int BASEDATA_DURATION_COLNO = 7;
	static final int BASEDATA_CAUSECODE_COLNO = 8;
	static final int BASEDATA_NEVERSION_COLNO = 9;
	static final int BASEDATA_IMSI_COLNO = 10;
	static final int BASEDATA_HIER3ID_COLNO = 11;
	static final int BASEDATA_HIER32ID_COLNO = 12;
	static final int BASEDATA_HIER321ID_COLNO = 13;

	static final int EVENTCAUSE__SHEETNO = 1;
	static final int EVENTCAUSE_CAUSECODE_COLNO = 0;
	static final int EVENTCAUSE_EVENTID_COLNO = 1;
	static final int EVENTCAUSE_DESCRIPTION_COLNO = 2;

	static final int FAILURECLASS__SHEETNO = 2;
	static final int FAILURECLASS_FAILURECLASS_COLNO = 0;
	static final int FAILURECLASS_DESCRIPTION_COLNO = 1;

	static final int UE__SHEETNO = 3;
	static final int UE_TAC_COLNO = 0;
	static final int UE_MARKETINGNAME_COLNO = 1;
	static final int UE_MANUFACTURER_COLNO = 2;
	static final int UE_ACCESSCAPABILITY_COLNO = 3;
	static final int UE_MODEL_COLNO = 4;
	static final int UE_VENDORNAME_COLNO = 5;
	static final int UE_UETYPE_COLNO = 6;
	static final int UE_OS_COLNO = 7;
	static final int UE_INPUTMODE_COLNO = 8;

	static final int MCCMNC__SHEETNO = 4;
	static final int MCCMNC_MCC_COLNO = 0;
	static final int MCCMNC_MNC_COLNO = 1;
	static final int MCCMNC_COUNTRY_COLNO = 2;
	static final int MCCMNC_OPERATOR_COLNO = 3;

}
