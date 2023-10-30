package com.shop.urshop.productFeatureValueMap;

import com.shop.urshop.entity.Product;
import com.shop.urshop.entity.ProductFeatureValueMap;
import com.shop.urshop.product.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductFeatureValueMapManager implements ProductFeatureValueMapService {

    private final ProductFeatureValueMapRepository productFeatureValueMapRepository;

    private final FeatureValueRepository featureValueRepository;

    private final ProductRepository productRepository;


    @Autowired
    public ProductFeatureValueMapManager(ProductFeatureValueMapRepository productFeatureValueMapRepository, FeatureValueRepository featureValueRepository, ProductRepository productRepository) {
        this.productFeatureValueMapRepository = productFeatureValueMapRepository;
        this.featureValueRepository = featureValueRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductFeatureValueMap> getAll() {
        return productFeatureValueMapRepository.findAll();
    }

    @Override
    public List<ProductFeatureValueMap> getMapsByFeatureId(int featureId) {
        return productFeatureValueMapRepository.findProductFeatureValueMapByFeatureValue_Id(featureId);
    }

    @Override
    public List<ProductFeatureValueMap> getMapsByProductId(int productId) {
        Optional<Product> products =productRepository.findById(productId);
        Product product = products.get();

        List<ProductFeatureValueMap> maps = new ArrayList<>();
        maps.add(productFeatureValueMapRepository.findByProduct(product));
        return maps;
    }
}
