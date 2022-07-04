package dferrero.ecommerce.repository;

import dferrero.ecommerce.data.entity.Price;
import dferrero.ecommerce.data.view.PriceView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.ZonedDateTime;
import java.util.List;

@RepositoryRestResource
public interface PricesRepository extends JpaRepository<Price, Long> {

    @Query(value = "SELECT p " +
            "FROM Price p " +
            "JOIN p.brandId b " +
            "WHERE p.productId = :productId " +
            "AND b.id = :brandId " +
            "AND p.startDate <= :inputDate " +
            "AND p.endDate >= :inputDate " +
            "ORDER BY p.priority DESC")
    List<PriceView> findPriceBetweenDates(Long productId, Long brandId, ZonedDateTime inputDate);
}
