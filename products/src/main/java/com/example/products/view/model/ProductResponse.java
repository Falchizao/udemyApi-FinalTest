package com.example.products.view.model;

import java.util.Date;

public class ProductResponse {

     //#region GettersNdSetters
     private String name;    
 
     public String getName() {
         return name;
     }
 
     public void setName(String name) {
         this.name = name;
     }
 
     public String getObservation() {
         return observation;
     }
 
     public void setObservation(String observation) {
         this.observation = observation;
     }
 
     public Date getDate() {
         return date;
     }
 
     public void setDate(Date date) {
         this.date = date;
     }
 
     public Double getValue() {
         return value;
     }
 
     public void setValue(Double value) {
         this.value = value;
     }
 
     public Integer getQuantity() {
         return quantity;
     }
 
     public void setQuantity(Integer quantity) {
         this.quantity = quantity;
     }
 
     public Double getDiscount() {
         return discount;
     }
 
     public void setDiscount(Double discount) {
         this.discount = discount;
     }
 
     public Double getTax() {
         return tax;
     }
 
     public void setTax(Double tax) {
         this.tax = tax;
     }
 
     public Double getTotal() {
         return total;
     }
 
     public void setTotal(Double total) {
         this.total = total;
     }
 
     private String observation;
 
     private Date date;
 
     private Double value;
 
     private Integer quantity;
 
     private Double discount;
 
     private Double tax;
 
     private Double total;
    
}
