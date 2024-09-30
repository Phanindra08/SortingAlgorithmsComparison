package edu.charlotte;

import java.util.*;

import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class GeneratingExcel {
    public static void main(String[] args) {
        int[] arraySizesForExecution = new int[] {1000, 2000, 3000, 4000, 5000, 10000, 20000, 40000, 50000, 60000, 80000, 90000, 100000};
        HashMap<Integer, HashMap<Integer, List<Long>>> mapForGeneratingExcel = new HashMap<>();
        Scanner scanningInput = new Scanner(System.in);
        System.out.print("Enter the number of times you want to run the codes with different random inputs: ");
        int numberOfTimesToRunTheCodes = scanningInput.nextInt();
        scanningInput.close();

        for (int sizeOfArrayExecuting : arraySizesForExecution) {
            System.out.println("The size of the array for execution is: " + sizeOfArrayExecuting);
            HashMap<Integer, List<Long>> mapForExecutionTime = new HashMap<>();
            for (int numberOfTimesToRunTheCodesIndex = 0; numberOfTimesToRunTheCodesIndex < numberOfTimesToRunTheCodes; numberOfTimesToRunTheCodesIndex++) {
                mapForExecutionTime.put(numberOfTimesToRunTheCodesIndex + 1, UnSortedInput.mainForUnSortedInput(sizeOfArrayExecuting));
//                mapForExecutionTime.put(numberOfTimesToRunTheCodesIndex + 1, SortedInput.mainForSortedInput(sizeOfArrayExecuting));
//                mapForExecutionTime.put(numberOfTimesToRunTheCodesIndex + 1, ReverseSortedInput.mainForReverseSortedInput(sizeOfArrayExecuting));
            }
            mapForGeneratingExcel.put(sizeOfArrayExecuting, mapForExecutionTime);
        }

        try {
            Workbook workbook = WorkbookFactory.create(false);
            // Creating a new sheet
            Sheet sheet = workbook.createSheet("UnSorted Input Data");
//            Sheet sheet = workbook.createSheet("Sorted Input Data");
//            Sheet sheet = workbook.createSheet("Reverse Sorted Input Data");

            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] headers = {"Size of the Array", "Number of Execution", "Insertion Sort", "Merge Sort", "In-Place Quick Sort", "Modified Quick Sort", "Heap Sort"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            int rowNumber = 1;
            for (Map.Entry<Integer, HashMap<Integer, List<Long>>> rowData : mapForGeneratingExcel.entrySet()) {
                Integer key = rowData.getKey();
                HashMap<Integer, List<Long>> mapForExecutionTime = rowData.getValue();
                for (Map.Entry<Integer, List<Long>> rowData1 : mapForExecutionTime.entrySet()) {
                    Row row = sheet.createRow(rowNumber++);
                    for (int columnNumber = 0; columnNumber < headers.length; columnNumber++) {
                        Cell cell = row.createCell(columnNumber);
                        if (columnNumber == 0 && key instanceof Integer) {
                            cell.setCellValue(key);
                        } else if (columnNumber == 1 && rowData1.getKey() instanceof Integer) {
                            cell.setCellValue(rowData1.getKey());
                        } else if (columnNumber > 1 && rowData1.getValue() instanceof List) {
                            cell.setCellValue(rowData1.getValue().get(columnNumber - 2));
                        }
                    }
                }
            }

            // Adjust column widths
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write the output to a file
            try (FileOutputStream fileOut = new FileOutputStream("UnSortedInput.xlsx")) {
//            try (FileOutputStream fileOut = new FileOutputStream("SortedInput.xlsx")) {
//            try (FileOutputStream fileOut = new FileOutputStream("ReverseSortedInput.xlsx")) {
                workbook.write(fileOut);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Closing the workbook
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel file generated successfully!");
    }
}

