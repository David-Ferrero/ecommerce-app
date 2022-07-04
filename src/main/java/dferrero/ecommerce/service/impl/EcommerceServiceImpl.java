package dferrero.ecommerce.service.impl;

import dferrero.ecommerce.data.view.PriceView;
import dferrero.ecommerce.repository.PricesRepository;
import dferrero.ecommerce.service.EcommerceService;
import dferrero.ecommerce.util.enums.ErrorCodes;
import dferrero.ecommerce.util.exceptions.ErrorException;
import dferrero.ecommerce.util.exceptions.ErrorHttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class EcommerceServiceImpl implements EcommerceService {

    private final PricesRepository pricesRepository;

    @Autowired
    public EcommerceServiceImpl(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public PriceView getPriceForProductAndBrandAndDate(Long productId, Long brandId, ZonedDateTime inputDate) {
        validateGetPriceInput(productId, brandId, inputDate);
        List<PriceView> priceViewList = pricesRepository.findPriceBetweenDates(productId, brandId, inputDate);

        return priceViewList.isEmpty() ? null : priceViewList.get(0);
    }

    private void validateGetPriceInput(Long productId, Long brandId, ZonedDateTime inputDate) {
        if (productId == null || productId < 0)
            throw new ErrorException(HttpStatus.BAD_REQUEST, new ErrorHttpStatus(ErrorCodes.INVALID_PRODUCT_ID.name(), ErrorCodes.INVALID_PRODUCT_ID.getCode()));

        if (brandId == null || brandId < 0)
            throw new ErrorException(HttpStatus.BAD_REQUEST, new ErrorHttpStatus(ErrorCodes.INVALID_BRAND_ID.name(), ErrorCodes.INVALID_BRAND_ID.getCode()));

        if (inputDate == null)
            throw new ErrorException(HttpStatus.BAD_REQUEST, new ErrorHttpStatus(ErrorCodes.INVALID_DATE_NULL.name(), ErrorCodes.INVALID_DATE_NULL.getCode()));
    }

}
