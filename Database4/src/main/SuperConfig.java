package main;

public class SuperConfig {
	String workbookFileName;

	public SuperConfig() {
		workbookFileName = "/home/ianmurray/workspace/Database/LargeData.xls";
	}

	public SuperConfig(String workbookfilename) {
		workbookFileName = workbookfilename;
	}

}
