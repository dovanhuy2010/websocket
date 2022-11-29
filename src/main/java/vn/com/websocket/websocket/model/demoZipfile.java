package vn.com.websocket.websocket.model;

public class demoZipfile {
//    try {
    //    //tạo một workbook lấy file cần zip từ server
//        Workbook workbook = new XSSFWorkbook(FileCommonUtils.getInputStreamFromResource("template/export/export_search_by_cell.xlsx"));
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        Documentary documentary = documentaryRepository.findById(documentId).orElseThrow(() -> new ValidateException(DOCUMENT_NOT_EXIST));
//        String[] inputValue = inputInvestigate.getInvestigateValue().split("-");
//        //thong tin cong van
//
//        InvestigateInfoDTO investigateInfoDTO = InvestigateInfoDTO.builder().documentNo(documentary.getNoDocument()).unitCode(documentary.getUnitCode())
//                .cell(inputValue[0]).lac(inputValue[1]).type(inputInvestigate.getInvestigateWith()).typeValue(inputInvestigate.getInvestigateValue())
//                .fromDate(formatter.format(inputInvestigate.getStartTime())).toDate(formatter.format(inputInvestigate.getEndTime()))
//                .password(inputInvestigate.getPassword()).build();
//        //du lieu
//
//        List<HistoryPhoneInvestigationResult> historyPhoneNumberResponses = historyPhoneInvestigationResultRepository.getAllHistoryPhone(
//                inputInvestigate.getInputId());
//
//        ExcelUtils.exportByCell(workbook, dynamicColumnDTOS, historyPhoneNumberResponses, investigateInfoDTO);
//        byte[] bytes = ExcelUtils.convertWorkbookToByteArray(workbook);
//        if (!isDownloadSingle) {
//            return bytes;
//        } else {
//            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(UUUU_MMDD_T_HHMMSS_SSSSSSSSS);
    // tên file khi được zip
//            String path = LocalDateTime.now().format(formatter1) + XLSX;
    // ghi dữ liệu vào file
//            FileUtils.writeByteArrayToFile(new File(path), bytes);
//
//            // Protecting the excel file
    //đặt mật khẩu cho file zip
//            try (POIFSFileSystem fs = new POIFSFileSystem()) {
//                EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
//                Encryptor encryptor = info.getEncryptor();
//                encryptor.confirmPassword(inputInvestigate.getPassword());
//                try (OPCPackage opc = OPCPackage.open(path, PackageAccess.READ_WRITE); OutputStream os = encryptor.getDataStream(fs);) {
//                    opc.save(os);
//                }
//                // Write out the encrypted version
//                try (FileOutputStream fos = new FileOutputStream(path)) {
//                    fs.writeFilesystem(fos);
//                }
//            }
//
//            byte[] bytesResult = FileUtils.readFileToByteArray(new File(path));
//            Files.delete(Paths.get(path));
//            return bytesResult;
//        }
}
