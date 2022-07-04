package dferrero.ecommerce.controller;

import dferrero.ecommerce.Application;
import dferrero.ecommerce.data.dto.RequestProductPriceDTO;
import dferrero.ecommerce.data.entity.Price;
import dferrero.ecommerce.data.view.PriceView;

import static dferrero.ecommerce.util.TestsUtil.buildPriceObject;
import static org.junit.jupiter.api.Assertions.*;

import dferrero.ecommerce.service.EcommerceService;
import dferrero.ecommerce.service.impl.EcommerceServiceImpl;
import dferrero.ecommerce.util.PriceUtils;
import dferrero.ecommerce.util.exceptions.ErrorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {PriceUtils.class, Application.class, EcommerceServiceImpl.class, EcommerceController.class})
public class EcommerceControllerTest {

    @Autowired
    EcommerceService ecommerceService;

    @Autowired
    EcommerceController ecommerceController;

    private Long productId;
    private Long brandId;

    private RequestProductPriceDTO requestProductPriceDTO;

    @BeforeEach
    public void initTests() {
        productId = 35455L;
        brandId = 1L;
        requestProductPriceDTO = new RequestProductPriceDTO();
        requestProductPriceDTO.setProductId(productId);
        requestProductPriceDTO.setBrandId(brandId);
    }

    @Test
    @DisplayName("Controller - 2020-06-14 10:00")
    public void ecommerceControllerTest1() {
        // Obtained data
        ZonedDateTime inputDate = ZonedDateTime.of(
                2020, 6, 14, 10, 0, 0, 0, ZoneId.systemDefault());
        requestProductPriceDTO.setDate(inputDate);

        PriceView obtainedResult = ecommerceController.getProductPrice(requestProductPriceDTO);

        Price obtainedPrice = buildPriceObject(obtainedResult);

        //Expected data
        ZonedDateTime startDate = ZonedDateTime.of(
                2020, 6, 14, 0, 0, 0, 0, ZoneId.systemDefault());
        ZonedDateTime endDate = ZonedDateTime.of(
                2020, 12, 31, 23, 59, 59, 0, ZoneId.systemDefault());

        Float price = new BigDecimal("35.50").floatValue();
        String curr = "EUR";
        Price expectedPrice = buildPriceObject(1L, 1L, startDate, endDate, 35455L, 0L, price, curr);

        // Result
        assertEquals(expectedPrice, obtainedPrice);
    }

    @Test
    @DisplayName("Controller - 2020-06-14 16:00")
    public void ecommerceControllerTest2() {
        // Obtained data
        ZonedDateTime inputDate = ZonedDateTime.of(
                2020, 6, 14, 16, 0, 0, 0, ZoneId.systemDefault());
        requestProductPriceDTO.setDate(inputDate);

        PriceView obtainedResult = ecommerceController.getProductPrice(requestProductPriceDTO);

        Price obtainedPrice = buildPriceObject(obtainedResult);

        //Expected data
        ZonedDateTime startDate = ZonedDateTime.of(
                2020, 6, 14, 15, 0, 0, 0, ZoneId.systemDefault());
        ZonedDateTime endDate = ZonedDateTime.of(
                2020, 6, 14, 18, 30, 0, 0, ZoneId.systemDefault());

        Float price = new BigDecimal("25.45").floatValue();
        String curr = "EUR";
        Price expectedPrice = buildPriceObject(2L, 1L, startDate, endDate, 35455L, 1L, price, curr);

        // Result
        assertEquals(expectedPrice, obtainedPrice);
    }

    @Test
    @DisplayName("Controller - 2020-06-14 21:00")
    public void ecommerceControllerTest3() {
        // Obtained data
        ZonedDateTime inputDate = ZonedDateTime.of(
                2020, 6, 14, 21, 0, 0, 0, ZoneId.systemDefault());
        requestProductPriceDTO.setDate(inputDate);

        PriceView obtainedResult = ecommerceController.getProductPrice(requestProductPriceDTO);

        Price obtainedPrice = buildPriceObject(obtainedResult);

        //Expected data
        ZonedDateTime startDate = ZonedDateTime.of(
                2020, 6, 14, 0, 0, 0, 0, ZoneId.systemDefault());
        ZonedDateTime endDate = ZonedDateTime.of(
                2020, 12, 31, 23, 59, 59, 0, ZoneId.systemDefault());

        Float price = new BigDecimal("35.50").floatValue();
        String curr = "EUR";
        Price expectedPrice = buildPriceObject(1L, 1L, startDate, endDate, 35455L, 0L, price, curr);

        // Result
        assertEquals(expectedPrice, obtainedPrice);
    }

    @Test
    @DisplayName("Controller - 2020-06-15 10:00")
    public void ecommerceControllerTest4() {
        // Obtained data
        ZonedDateTime inputDate = ZonedDateTime.of(
                2020, 6, 15, 10, 0, 0, 0, ZoneId.systemDefault());
        requestProductPriceDTO.setDate(inputDate);

        PriceView obtainedResult = ecommerceController.getProductPrice(requestProductPriceDTO);

        Price obtainedPrice = buildPriceObject(obtainedResult);

        //Expected data
        ZonedDateTime startDate = ZonedDateTime.of(
                2020, 6, 15, 0, 0, 0, 0, ZoneId.systemDefault());
        ZonedDateTime endDate = ZonedDateTime.of(
                2020, 6, 15, 11, 0, 0, 0, ZoneId.systemDefault());

        Float price = new BigDecimal("30.50").floatValue();
        String curr = "EUR";
        Price expectedPrice = buildPriceObject(3L, 1L, startDate, endDate, 35455L, 1L, price, curr);

        // Result
        assertEquals(expectedPrice, obtainedPrice);
    }

    @Test
    @DisplayName("Controller - 2020-06-16 21:00")
    public void ecommerceControllerTest5() {
        // Obtained data
        ZonedDateTime inputDate = ZonedDateTime.of(
                2020, 6, 15, 21, 0, 0, 0, ZoneId.systemDefault());
        requestProductPriceDTO.setDate(inputDate);

        PriceView obtainedResult = ecommerceController.getProductPrice(requestProductPriceDTO);

        Price obtainedPrice = buildPriceObject(obtainedResult);

        //Expected data
        ZonedDateTime startDate = ZonedDateTime.of(
                2020, 6, 15, 16, 0, 0, 0, ZoneId.systemDefault());
        ZonedDateTime endDate = ZonedDateTime.of(
                2020, 12, 31, 23, 59, 59, 0, ZoneId.systemDefault());

        Float price = new BigDecimal("38.95").floatValue();
        String curr = "EUR";
        Price expectedPrice = buildPriceObject(4L, 1L, startDate, endDate, 35455L, 1L, price, curr);

        // Result
        assertEquals(expectedPrice, obtainedPrice);
    }

    @Test
    @DisplayName("Check invalid productId")
    public void checkInvalidProductId() {
        // Obtained data
        ZonedDateTime inputDate = ZonedDateTime.of(
                2020, 6, 15, 21, 0, 0, 0, ZoneId.systemDefault());

        productId = -1L;
        requestProductPriceDTO.setProductId(productId);

        assertThrows(ErrorException.class, () -> {
            ecommerceController.getProductPrice(requestProductPriceDTO);
        });
    }

    @Test
    @DisplayName("Check invalid brandId")
    public void checkInvalidBrandId() {
        // Obtained data
        ZonedDateTime inputDate = ZonedDateTime.of(
                2020, 6, 15, 21, 0, 0, 0, ZoneId.systemDefault());

        brandId = -1L;
        requestProductPriceDTO.setBrandId(brandId);
        assertThrows(ErrorException.class, () -> {
            ecommerceController.getProductPrice(requestProductPriceDTO);
        });
    }

    @Test
    @DisplayName("Check invalid date")
    public void checkInvalidDate() {
        // Obtained data
        ZonedDateTime inputDate = null;
        requestProductPriceDTO.setDate(inputDate);

        assertThrows(ErrorException.class, () -> {
            ecommerceController.getProductPrice(requestProductPriceDTO);
        });
    }

}
