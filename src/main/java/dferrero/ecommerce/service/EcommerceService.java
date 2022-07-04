package dferrero.ecommerce.service;

import dferrero.ecommerce.data.view.PriceView;

import java.time.ZonedDateTime;

public interface EcommerceService {

    PriceView getPriceForProductAndBrandAndDate(Long productId, Long brandId, ZonedDateTime inputDate);

}
