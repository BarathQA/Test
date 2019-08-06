//Created by Barath Kumar on 2-Aug-2019

package com.app.test.application.helperLibrary;

import java.util.ArrayList;

import java.util.List;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;

public class changeToHelper {
	
	public static String changeToString(DataTable dtableNames) {
        String expected = new String();
        List<DataTableRow> inputArraySize = dtableNames.getGherkinRows();
        for (int index = 0; index < inputArraySize.size(); index++) {
            expected = inputArraySize.get(index).getCells().get(0).trim();
        }
        return expected;
    }
	
	public static ArrayList<String> changeToArrayList(DataTable dtableNames) {
		ArrayList<String> expArrayList = new ArrayList<String>();
        List<DataTableRow> tdataSize = dtableNames.getGherkinRows();
		for (int tdIndex = 0; tdIndex < tdataSize.size(); tdIndex++) {
			expArrayList.addAll(tdataSize.get(tdIndex).getCells());
	    }
        return expArrayList;
    }
	
}