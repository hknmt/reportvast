package com.viettelmor.reportvast.Service;

import com.viettelmor.reportvast.BusinessObject.ChargeLog;
import com.viettelmor.reportvast.DataAccessObject.ChargeLogRepository;
import com.viettelmor.reportvast.ViewModel.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ChargeLogServiceImpl implements ChargeLogService {
    @Autowired
    private ChargeLogRepository chargeLogRepository;

    @Override
    public List<ChargeLog> getAllChargeLogByServicesCodeAndDate(String ServicesCode, String From, String To) {
        return chargeLogRepository.getAllChargeLogByServicesCodeAndDate(ServicesCode, From, To);
    }
}
