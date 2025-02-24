package com.vinhnt.api.core.application.port.inbound.inventory;

import com.vinhnt.api.core.domain.model.inventory.Product;
import com.vinhnt.api.core.domain.model.inventory.ProductStatus;

public interface ProductUpdate {
    Product updateProductInfo(ProductUpdateInfoDTO productUpdateInfoDTO);

    Product updateStockQuantity(Product product, int quantity);

    Product updateProductStatus(Product product, ProductStatus status);
}
