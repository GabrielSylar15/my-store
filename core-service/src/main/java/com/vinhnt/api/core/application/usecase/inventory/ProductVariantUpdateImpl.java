package com.vinhnt.api.core.application.usecase.inventory;

import com.vinhnt.api.core.application.port.inbound.inventory.ProductVariantCreationOutputDTO;
import com.vinhnt.api.core.application.port.inbound.inventory.ProductVariantDTO;
import com.vinhnt.api.core.application.port.inbound.inventory.ProductVariantUpdate;
import com.vinhnt.api.core.application.port.inbound.inventory.ProductVariantUpdateDTO;
import com.vinhnt.api.core.application.port.outbound.inventory.ProductVariantRepository;
import com.vinhnt.api.core.domain.model.inventory.ProductVariant;
import com.vinhnt.api.core.domain.model.inventory.ProductVariantStatus;
import com.vinhnt.api.core.domain.model.inventory.exception.InvalidProductVariantException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductVariantUpdateImpl implements ProductVariantUpdate {
    private final ProductVariantRepository productVariantRepository;

    public ProductVariantUpdateImpl(ProductVariantRepository productVariantRepository) {
        this.productVariantRepository = productVariantRepository;
    }

    @Override
    public ProductVariantCreationOutputDTO updateProductVariant(ProductVariantUpdateDTO productVariantUpdateDTO) {
        Set<Long> productVariantIds = productVariantUpdateDTO.variants().stream().map(ProductVariantDTO::id).collect(Collectors.toSet());
        List<ProductVariant> productVariants = productVariantRepository.findByProductIdAndIdIn(productVariantUpdateDTO.productId(), productVariantIds.stream().toList());
        if (productVariants.isEmpty()) {
            throw new InvalidProductVariantException("Updated product variant not found");
        }
        if (productVariantIds.size() != productVariants.size()) {
            throw new InvalidProductVariantException("Updated product variant: product variant id is not valid");
        }
        List<ProductVariant> allVariants = productVariantRepository.findByProductIdAndStatus(productVariantUpdateDTO.productId(), ProductVariantStatus.AVAILABLE);
        List<ProductVariant> deletedVariants = allVariants.stream().filter(item -> !productVariantIds.contains(item.getId())).toList();
        Map<Long, ProductVariant> mapProductVariant = productVariants.stream().collect(Collectors.toMap(ProductVariant::getId, item -> item, (_, replacement) -> replacement));
        productVariants = new ArrayList<>();
        for (ProductVariantDTO variant : productVariantUpdateDTO.variants()) {
            ProductVariant productVariant = mapProductVariant.get(variant.id());
            productVariant.updateProductVariantInfo(variant.priceInfo().toProductPriceInfo(), variant.stockQuantity(), variant.sku(), variant.tierIndex());
            productVariants.add(productVariant);
        }
        productVariantRepository.saveAll(productVariants);
        productVariantRepository.deleteAll(deletedVariants);
        return new ProductVariantCreationOutputDTO(productVariantUpdateDTO.productId(), productVariantUpdateDTO.tierVariation(), productVariants);
    }
}
