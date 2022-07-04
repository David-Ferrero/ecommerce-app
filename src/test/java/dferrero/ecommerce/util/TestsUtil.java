package dferrero.ecommerce.util;

import dferrero.ecommerce.data.entity.Brand;
import dferrero.ecommerce.data.entity.Price;
import dferrero.ecommerce.data.view.PriceView;

import java.time.ZonedDateTime;

public class TestsUtil {

    public static Price buildPriceObject(Long priceList, Long brandId, ZonedDateTime startDate, ZonedDateTime endDate,
                                   Long productId, Long priority, Float price, String curr) {
        Price result = new Price();
        Brand brand = new Brand(brandId);
        result.setPriceList(priceList);
        result.setBrandId(brand);
        result.setStartDate(startDate);
        result.setEndDate(endDate);
        result.setProductId(productId);
        result.setPriority(priority);
        result.setPrice(price);
        result.setCurr(curr);

        return result;
    }

    public static Price buildPriceObject(PriceView priceView) {
        Price price = new Price();
        price.setPriceList(priceView.getPriceList());
        price.setBrandId(new Brand(priceView.getBrandId()));
        price.setStartDate(priceView.getStartDateZDT());
        price.setEndDate(priceView.getEndDateZDT());
        price.setProductId(priceView.getProductId());
        price.setPriority(priceView.getPriority());
        price.setPrice(priceView.getPrice());
        price.setCurr(priceView.getCurr());

        return price;
    }
}
