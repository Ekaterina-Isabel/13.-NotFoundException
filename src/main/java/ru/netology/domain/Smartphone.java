package ru.netology.domain;

public class Smartphone extends Product {       //класс Smartphone унаследован от класса Product
    private String producer;

    public Smartphone(int id, String name, int price, String producer) {        //конструктор
        super(id, name, price);
        this.producer = producer;
    }

    //геттеры и сеттеры на все поля
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
