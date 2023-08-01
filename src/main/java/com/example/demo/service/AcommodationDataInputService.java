package com.example.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.AcommodationInfoRepository;
import com.example.demo.repository.AcommodationRepository;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.BuildingInfoRepository;
import com.example.demo.repository.ContactRepository;

@Service
public class AcommodationDataInputService {
    @Autowired
    private AcommodationInfoRepository Adir;
    @Autowired
    private AcommodationRepository Adr;
    @Autowired 
    private ContactRepository Cr;
    @Autowired 
    private AddressRepository Ar;
    @Autowired
    private BuildingInfoRepository Br;


    public void ExcelFileReadAcommodation() {
        try {
            // 절대경로 지정
            String fileLocatioString = "C:/demoProject/ToyProject/demo/src/main/resources/data/acommodation_excel.xlsx";
            // 절대경로에서 가져온 파일 변수
            FileInputStream file = new FileInputStream(new File(fileLocatioString));
            // 파일을 workbook으로 만드는 함수
            Workbook workbook = new XSSFWorkbook(file);
            // 워크북에서 시트를 가져옴
            Sheet sheet = workbook.getSheetAt(0);

            // 맵을 사용해서 data객채를 만듬
            Map<Integer, List<String>> data = new HashMap<>();
            int i = 0;
            // 시트를 한줄씩 읽으면서 data에 넣기
            for (Row row : sheet) {
                data.put(i, new ArrayList<String>());

                // 시트 max함수를 이용해서 둘중의 큰것으로 배열 크기 맞추기
                int lastColumn = Math.max(row.getLastCellNum(), 14);

                // 배열을 돌면서 데이터가 있는 칸 속성맞춰주기
                for (int cn = 0; cn < lastColumn; cn++) {
                    Cell cell = row.getCell(cn, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    String cellValue;
                    if (cell == null) {
                        // 배열에 빈 스트링이 있으면 null값 넣기
                        cellValue = "";
                    } else {
                        // null값이 아니면 스트링 포맷에 따라서 속성 부여
                        cellValue = null;
                        switch (cell.getCellType()) {
                            case STRING:
                                String strValue = cell.getRichStringCellValue().getString();
                                cellValue = strValue.isEmpty() ? "" : strValue;
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    cellValue = cell.getDateCellValue() + "";
                                } else {
                                    cellValue = cell.getNumericCellValue() + "";
                                }
                                break;
                            case BOOLEAN:
                                cellValue = cell.getBooleanCellValue() + "";
                                break;
                            case FORMULA:
                                cellValue = cell.getCellFormula() + "";
                                break;
                            default:
                                cellValue = ""; // 기타 셀 타입이라면 빈 문자열로 처리
                        }
                    }
                    // data에 add함수를 이용해서 진짜로 넣기
                    data.get(i).add(cellValue);
                }
                // i값 증가시켜서 반복
                i++;
            }

            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
