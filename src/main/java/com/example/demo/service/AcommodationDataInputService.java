package com.example.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Acommodation;
import com.example.demo.entity.AcommodationInfo;
import com.example.demo.entity.Address;
import com.example.demo.entity.BuildingInfo;
import com.example.demo.entity.Contact;
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
            String fileLocatioString = "C:/DemoToyProject/DemoToyProject_BackEnd/src/main/resources/data/new_acommodation_excel_latlng.xlsx";
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

            for (int j = 1; j < sheet.getLastRowNum(); j++) {
                List<String> rowData = data.get(j);
                System.out.println("Padded Row " + j + ": " + rowData);
                Acommodation acommodation = new Acommodation();
                AcommodationInfo acommodationInfo = new AcommodationInfo();
                BuildingInfo buildingInfo = new BuildingInfo();
                Contact contact = new Contact();
                Address address = new Address();

                acommodationInfo.setAco_class(data.get(j).get(7));
                if (data.get(j).get(12) != "" && data.get(j).get(13) != "") {
                    acommodationInfo.setHansil((int) Float.parseFloat(data.get(j).get(12)));
                    acommodationInfo.setYangsil((int) Float.parseFloat(data.get(j).get(13)));
                }
                if (data.get(j).get(8) != "") {
                    buildingInfo.setUpstair((int) Float.parseFloat(data.get(j).get(8)));
                }

                if (data.get(j).get(9) != "") {
                    buildingInfo.setDownstair((int) Float.parseFloat(data.get(j).get(9)));
                }
                if (data.get(j).get(10) != "") {

                    buildingInfo.setStartstair((int) Float.parseFloat(data.get(j).get(10)));
                }
                if (data.get(j).get(11) != "") {
                    buildingInfo.setEndstair((int) Float.parseFloat(data.get(j).get(11)));
                }

                contact.setTel(data.get(j).get(0));

                if (data.get(j).get(1) != "") {
                    String[] addressJibunStrings = data.get(j).get(1).split(" ");
                    address.setSido(addressJibunStrings[0]);
                    address.setSigungu(addressJibunStrings[1]);
                    address.setEupmyun(addressJibunStrings[2]);
                    String addressJibunEnd = Arrays.stream(addressJibunStrings, 3, addressJibunStrings.length)
                            .collect(Collectors.joining(" "));
                    address.setSangse(addressJibunEnd);

                }

                if (data.get(j).get(2) != "") {
                    String[] addressDoroStrings = data.get(j).get(2).split(" ");
                    String addressDoroEnd = Arrays.stream(addressDoroStrings, 0, addressDoroStrings.length)
                            .collect(Collectors.joining(" "));

                    if (addressDoroStrings[2].contains("면")) {
                        addressDoroEnd = Arrays.stream(addressDoroStrings, 3, addressDoroStrings.length)
                                .collect(Collectors.joining(" "));
                        address.setDoro(addressDoroEnd);
                    } else {
                        addressDoroEnd = Arrays.stream(addressDoroStrings, 2, addressDoroStrings.length)
                                .collect(Collectors.joining(" "));
                        address.setDoro(addressDoroEnd);
                    }

                }

                if (data.get(j).get(3) != "") {
                    address.setZip_no(String.format("%d", (int) Float.parseFloat(data.get(j).get(3))));
                }

                if (data.get(j).get(5) != "") {
                    address.setX(Float.parseFloat(data.get(j).get(5)));
                }
                if (data.get(j).get(6) != "") {
                    address.setY(Float.parseFloat(data.get(j).get(6)));
                }
                if (data.get(j).size() >= 16) {
                    if (data.get(j).get(13) != "") {
                        address.setLatitude(Float.parseFloat(data.get(j).get(14)));
                    }

                    if (data.get(j).get(14) != "") {
                        address.setLongitude(Float.parseFloat(data.get(j).get(15)));
                    }
                }

                Adir.save(acommodationInfo);
                Cr.save(contact);
                Br.save(buildingInfo);
                Ar.save(address);

                acommodation.setName(data.get(j).get(4));
                acommodation.setAddress_id(address.getAddress_id());
                acommodation.setBuilding_id(buildingInfo.getBuilding_id());
                acommodation.setContact_id(contact.getContact_id());
                acommodation.setAco_id(acommodationInfo.getAco_id());

                Adr.save(acommodation);

            }

            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
