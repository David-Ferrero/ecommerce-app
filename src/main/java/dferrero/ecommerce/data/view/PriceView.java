package dferrero.ecommerce.data.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public interface PriceView {

    Long getProductId();

    @Value("#{@priceUtils.getBrandId(target)}")
    Long getBrandId();

    Long getPriceList();

    @JsonIgnore
    @Value("#{target.startDate}")
    ZonedDateTime getStartDateZDT();

    default String getStartDate() {
        if (getStartDateZDT() == null) return null;
        return getStartDateZDT().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @JsonIgnore
    @Value("#{target.endDate}")
    ZonedDateTime getEndDateZDT();

    default String getEndDate() {
        if (getEndDateZDT() == null) return null;
        return getEndDateZDT().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    Float getPrice();

    String getCurr();

    @JsonIgnore
    Long getPriority();

}
