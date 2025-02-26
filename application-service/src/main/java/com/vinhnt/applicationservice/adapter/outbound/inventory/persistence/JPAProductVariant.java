package com.vinhnt.applicationservice.adapter.outbound.inventory.persistence;

import com.vinhnt.api.core.domain.model.inventory.ProductPriceInfo;
import com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.converter.ListIntegerConverter;
import com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.converter.PriceInfoConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "product_variants")
@Data
public class JPAProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "price_info")
    @Convert(converter = PriceInfoConverter.class)
    private ProductPriceInfo productPriceInfo;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    @Column(name = "sku")
    private String sku;

    @Column(name = "sold")
    private Long sold;

    @Column(name = "tier_index")
    @Convert(converter = ListIntegerConverter.class)
    private List<Integer> tierIndex;

    @Column(name = "version")
    @Version
    private Long version;

    @Column(name = "created_at", updatable = false, insertable = false)
    private Date createdAt;

    @Column(name = "updated_at", updatable = false, insertable = false)
    private Date updatedAt;
}
