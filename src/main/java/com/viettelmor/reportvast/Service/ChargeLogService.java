package com.viettelmor.reportvast.Service;

import com.viettelmor.reportvast.BusinessObject.ChargeLog;
import com.viettelmor.reportvast.ViewModel.DataTable;

import java.util.List;
import java.util.stream.Stream;

public interface ChargeLogService {
    List<ChargeLog> getAllChargeLogByServicesCodeAndDate(String ServicesCode, String From, String To);
}
