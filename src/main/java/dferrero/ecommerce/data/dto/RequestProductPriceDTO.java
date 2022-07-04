package dferrero.ecommerce.data.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class RequestProductPriceDTO {

    private Long productId;
    private Long brandId;
    private ZonedDateTime date;

}
