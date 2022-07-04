package dferrero.ecommerce.data.entity;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "brands")
@Getter
@Setter
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_name")
    protected String brandName;

    @OneToMany(
            mappedBy = "brandId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Price> priceList = new ArrayList<>();

    public Brand (Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Brand input = (Brand) o;
        return Objects.equals(id, input.id) && Objects.equals(brandName, input.brandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brandName);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", priceList=" + priceList +
                '}';
    }
}