package dferrero.ecommerce.repository;

import dferrero.ecommerce.Application;
import dferrero.ecommerce.data.entity.Price;
import dferrero.ecommerce.data.view.PriceView;

import static dferrero.ecommerce.util.TestsUtil.buildPriceObject;
import static org.junit.jupiter.api.Assertions.*;

import dferrero.ecommerce.util.PriceUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {PriceUtils.class, Application.class})
public class EcommerceRepositoryTest {

    @Autowired
    PricesRepository pricesRepository;

    private Long productId;
    private Long brandId;

    @Before
    public void initTests() {
        productId = 35455L;
        brandId = 1L;
    }

    @Test
    @DisplayName("Repository - 2020-06-14 10:00")
    public void priceRepositoryTest1() {
        // Obtained data
        ZonedDateTime inputDate = ZonedDateTime.of(
                2020, 6, 14, 10, 0, 0, 0, ZoneId.systemDefault());

        List<PriceView> priceViewList = pricesRepository.findPriceBetweenDates(productId, brandId, inputDate);
        PriceView obtainedResult = priceViewList.get(0);

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
    @DisplayName("Repository - 2020-06-14 16:00")
    public void priceRepositoryTest2() {
        // Obtained data
        ZonedDateTime inputDate = ZonedDateTime.of(
                2020, 6, 14, 16, 0, 0, 0, ZoneId.systemDefault());

        List<PriceView> priceViewList = pricesRepository.findPriceBetweenDates(productId, brandId, inputDate);
        PriceView obtainedResult = priceViewList.get(0);

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
    @DisplayName("Repository - 2020-06-14 21:00")
    public void priceRepositoryTest3() {
        // Obtained data
        ZonedDateTime inputDate = ZonedDateTime.of(
                2020, 6, 14, 21, 0, 0, 0, ZoneId.systemDefault());

        List<PriceView> priceViewList = pricesRepository.findPriceBetweenDates(productId, brandId, inputDate);
        PriceView obtainedResult = priceViewList.get(0);

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
    @DisplayName("Repository - 2020-06-15 10:00")
    public void priceRepositoryTest4() {
        // Obtained data
        ZonedDateTime inputDate = ZonedDateTime.of(
                2020, 6, 15, 10, 0, 0, 0, ZoneId.systemDefault());

        List<PriceView> priceViewList = pricesRepository.findPriceBetweenDates(productId, brandId, inputDate);
        PriceView obtainedResult = priceViewList.get(0);

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
    @DisplayName("Repository - 2020-06-16 21:00")
    public void priceRepositoryTest5() {
        // Obtained data
        ZonedDateTime inputDate = ZonedDateTime.of(
                2020, 6, 15, 21, 0, 0, 0, ZoneId.systemDefault());

        List<PriceView> priceViewList = pricesRepository.findPriceBetweenDates(productId, brandId, inputDate);
        PriceView obtainedResult = priceViewList.get(0);

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

}
