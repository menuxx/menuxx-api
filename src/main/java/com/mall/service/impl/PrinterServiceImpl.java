package com.mall.service.impl;

import com.mall.mapper.TPrinterMapper;
import com.mall.model.TPrinter;
import com.mall.model.TPrinterExample;
import com.mall.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrinterServiceImpl implements PrinterService {

    @Autowired
    TPrinterMapper tPrinterMapper;

    @Override
    public List<TPrinter> getPrinterList() {
        TPrinterExample e = new TPrinterExample();
        return tPrinterMapper.selectByExample(e);
    }
}
