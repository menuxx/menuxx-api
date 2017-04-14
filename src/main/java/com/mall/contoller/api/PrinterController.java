package com.mall.contoller.api;

import com.mall.model.TPrinter;
import com.mall.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrinterController {

    @Autowired
    PrinterService printerService;

    @GetMapping("printers")
    public List<TPrinter> getPrinterList() {
        return printerService.getPrinterList();
    }

}
