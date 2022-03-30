package ru.netology.domain;

public class Book extends Product {     //класс Book унаследован от класса Product
    private String author;

    public Book(int id, String name, int price, String author) {        //конструктор
        super(id, name, price);
        this.author = author;
    }

    //геттеры и сеттеры на все поля
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
