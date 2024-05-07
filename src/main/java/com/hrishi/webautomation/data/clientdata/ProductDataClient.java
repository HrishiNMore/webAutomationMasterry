package com.hrishi.webautomation.data.clientdata;

import com.hrishi.webautomation.models.Product;

public class ProductDataClient extends Dataclient {
    public Product getProduct(){
        String filepath=getFilePath("products/products.json");
        return (Product) dataMapper.map(filepath,"megaraDress", Product.class);
    }
}
