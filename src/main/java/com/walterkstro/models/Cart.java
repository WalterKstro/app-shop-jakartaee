package com.walterkstro.models;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.walterkstro.models.Currency.formating;

@SessionScoped
@Named
public class Cart implements Serializable {
    private List<Item> list;
    private float total;

    public Cart() {
        list = new ArrayList<>();
    }

    public void addItem(Item item){
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
    public List<Item> getList() {
        return list;
    }

    public float getTotal() {
        return list.stream()
                .map( item -> item.subTotal() )
                .reduce(0f, (prev, current)-> prev + current);
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    public String formatCurrency() {
        return formating(this.getTotal());
    }
}
