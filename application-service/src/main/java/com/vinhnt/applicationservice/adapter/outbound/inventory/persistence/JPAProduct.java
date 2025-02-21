package com.vinhnt.applicationservice.adapter.outbound.inventory.persistence;

import com.vinhnt.api.core.domain.model.inventory.ProductStatus;
import com.vinhnt.api.core.domain.model.inventory.TierVariation;
import com.vinhnt.api.core.domain.model.inventory.Video;
import com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.converter.GenericListConverter;
import com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.converter.VideoConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class JPAProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "is_pre_order")
    private Boolean isPreOrder;

    @Column(name = "days_to_ship")
    private Integer daysToShip;

    @Convert(converter = VideoConverter.class)
    @Column(name = "video")
    private Video video;

    @Column(name = "total_sold")
    private Long totalSold;

    @Column(name = "display_priority")
    private Integer displayPriority;

    @Column(name = "status")
    private ProductStatus status;

    @Column(name = "tier_variations")
    @Convert(converter = GenericListConverter.class)
    private List<TierVariation> tierVariations;

    @Column(name = "images")
    @Convert(converter = GenericListConverter.class)
    private List<String> images;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "height")
    private Float height;

    @Column(name = "width")
    private Float width;

    @Column(name = "length")
    private Float length;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    @Column(name = "version")
    @Version
    private Long version;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Date createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Date updatedAt;
}
