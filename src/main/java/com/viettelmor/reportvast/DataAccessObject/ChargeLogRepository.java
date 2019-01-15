package com.viettelmor.reportvast.DataAccessObject;

import com.viettelmor.reportvast.BusinessObject.ChargeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;
import java.util.stream.Stream;

import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;

@Repository
public interface ChargeLogRepository extends JpaRepository<ChargeLog, Long> {
    @Query(
            value = "select * from charge_log where services_code=?1 and trunc(charge_time) >= TO_DATE(?2, 'DD/MM/YYYY') and trunc(charge_time) <= TO_DATE(?3, 'DD/MM/YYYY')",
            countQuery = "select * from charge_log where services_code=?1 and charge_time >= TO_DATE(?2, 'DD/MM/YYYY') and charge_time <= TO_DATE(?3, 'DD/MM/YYYY')",
            nativeQuery = true
    )
    List<ChargeLog> getAllChargeLogByServicesCodeAndDate(String ServicesCode, String From, String To);
}
