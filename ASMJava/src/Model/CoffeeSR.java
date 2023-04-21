/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author SON RATTANA
 */
public class CoffeeSR implements Serializable{
    private String Code;
    private String name;
    private int price;
    private String category;
    

    public CoffeeSR(String Code, String name, int price, String category) {
        this.Code = Code;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public CoffeeSR(String code, String name, int price) {
      
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
}
