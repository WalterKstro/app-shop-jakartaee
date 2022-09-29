package com.walterkstro.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.walterkstro.models.Currency.formating;

public class CartModel {
    private List<ItemModel> list;
    private float total;

    public CartModel() {
        list = new ArrayList<>();
    }

    public void addItem(ItemModel item){
        boolean isItem = list.contains( item );
        if( isItem ){
            list = list.stream()
                    .map( lineItem ->  {
                       if( lineItem.equals(item) ){
                           lineItem.setQuantity( lineItem.getQuantity() + 1 );
                           return lineItem;
                       }
                       return lineItem;
                    })
                    .collect(Collectors.toList());
        }else {
            list.add(item);
        }
    }
    public List<ItemModel> getList() {
        return list;
    }

    public float getTotal() {
        return list.stream()
                .map( item -> item.subTotal() )
                .reduce(0f, (prev, current)-> prev + current);
    }

    public void setList(List<ItemModel> list) {
        this.list = list;
    }

    public String formatCurrency() {
        return formating(this.getTotal());
    }
}
