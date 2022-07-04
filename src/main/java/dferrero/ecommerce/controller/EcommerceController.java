package dferrero.ecommerce.controller;


import dferrero.ecommerce.data.dto.RequestProductPriceDTO;
import dferrero.ecommerce.data.view.PriceView;
import dferrero.ecommerce.service.EcommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ecommerce")
public class EcommerceController {

    private final EcommerceService ecommerceService;

    @Autowired
    public EcommerceController(EcommerceService ecommerceService) {
        this.ecommerceService = ecommerceService;
    }

    @GetMapping(value = "/product/price", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PriceView getProductPrice(@RequestBody RequestProductPriceDTO requestProductPriceDTO) {

        return ecommerceService.getPriceForProductAndBrandAndDate(
                requestProductPriceDTO.getProductId(),
                requestProductPriceDTO.getBrandId(),
                requestProductPriceDTO.getDate());

    }

}
