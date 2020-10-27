package com.hn.springbootmobilestore.cart;

import com.hn.springbootmobilestore.entity.Product;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CartObject implements Serializable {

    private Map<Product, Integer> cart;

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void addItemToCart(Product product){
        if(product == null){
            return;
        }

        if(this.cart == null){
            cart = new HashMap<>();
        }
        int quantity = 1;

        for(Product key : this.cart.keySet()){
            if(key.getProductID() == product.getProductID()){
                product = key;
                quantity = this.cart.get(product) + 1;
            }
        }

        this.cart.put(product, quantity);
    }

    public void removeItemCart(int id){
        if(this.cart == null){
            return;
        }

        Iterator itr = this.cart.keySet().iterator();
        while(itr.hasNext()){
            Product dto = (Product) itr.next();
            if(dto.getProductID() == id){
                itr.remove();
                if(this.cart.isEmpty()){
                    this.cart = null;
                }
            }
        }
    }

    public float totalPrice(){
        if(cart == null)  return 0;
        float total = 0;
        for(Product key : this.cart.keySet()){
            total += key.getPrice();
        }
        return total;
    }
}
