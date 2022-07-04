package dferrero.ecommerce.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@Table(name = "prices")
@Getter
@Setter
@NoArgsConstructor
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_list")
    private Long priceList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brandId;

    @Column(name = "start_date")
    private ZonedDateTime startDate;

    @Column(name = "end_date")
    private ZonedDateTime endDate;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "priority")
    private Long priority;

    @Column(name = "price")
    private Float price;

    @Column(name = "curr")
    private String curr;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Price input = (Price) o;
        return Objects.equals(priceList, input.priceList) && Objects.equals(brandId, input.brandId)
                && Objects.equals(startDate, input.startDate) && Objects.equals(endDate, input.endDate)
                && Objects.equals(productId, input.productId) && Objects.equals(priority, input.priority)
                && Objects.equals(price, input.price) && Objects.equals(curr, input.curr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceList, brandId, startDate, endDate, productId, priority, price, curr);
    }

    @Override
    public String toString() {
        return "Price{" +
                "priceList=" + priceList +
                ", brandId=" + brandId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", productId=" + productId +
                ", priority=" + priority +
                ", price=" + price +
                ", curr='" + curr + '\'' +
                '}';
    }
}