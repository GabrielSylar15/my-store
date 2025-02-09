package com.vinhnt.applicationservice.adapter.outbound.product.persistence;

import com.vinhnt.api.core.domain.model.inventory.PreOrder;
import com.vinhnt.api.core.domain.model.inventory.TierVariation;
import com.vinhnt.applicationservice.adapter.outbound.product.persistence.converter.GenericListConverter;
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

    @Convert(converter = PreOrder.class)
    @Column(name = "pre_order")
    private PreOrder preOrder;

    @Column(name = "video")
    private String video;

    @Column(name = "total_sold")
    private Long totalSold;

    @Column(name = "display_priority")
    private Integer displayPriority;

    @Column(name = "status")
    private Integer status;

    @Column(name = "tier_variations")
    @Convert(converter = GenericListConverter.class)
    private List<TierVariation> tierVariations;

    @Column(name = "images")
    @Convert(converter = GenericListConverter.class)
    private List<String> images;

    @Column(name = "weight")
    private Long weight;

    @Column(name = "height")
    private Long height;

    @Column(name = "width")
    private Long width;

    @Column(name = "length")
    private Long length;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Date createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Date updatedAt;
}
