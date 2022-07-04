package dferrero.ecommerce.util;

import dferrero.ecommerce.data.entity.Price;
import org.springframework.stereotype.Service;

@Service
public class PriceUtils {

    public Long getBrandId(Price price) {
        return price.getBrandId() == null ? null : price.getBrandId().getId();
    }

}
