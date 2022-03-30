package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

public class ProductRepository {
    private Product[] items = new Product[0];       //items - поле, в котором создан Product[] - пустой массив товаров

    public void save(Product item) {        //метод добавления нового объекта item в массив
        int lengh = items.length + 1;       //вычисление длинны нового массива = длинна старого массива + 1
        Product[] tmp = new Product[lengh];     //создание нового массива с вычисленной длинной
        System.arraycopy(items, 0, tmp, 0, items.length);       //метод автоматического копирования элементов из старого массива в новый
        int lastIndex = tmp.length - 1;     //вычисляем номер последней ячейки
        tmp[lastIndex] = item;      //добавляем в последнюю ячейку новый элемент
        items = tmp;        //сохраняем новый массив в поле items старого массива
    }

    public Product[] findAll() {        //метод получить все сохраненные элементы
        return items;
    }

    public Product findById(int id) {       //возвращает объект по id
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {        //удаляет объект по id
        Product product = findById(id);
        if (product == null) {
            throw new NotFoundException("не найден product c id " + id);
        }

        int lenght = items.length - 1;
        Product[] tmp = new Product[lenght];
        int index = 0;      //index - переменная, номер ячейки куда будем копировать
        for (Product item : items) {        //перебор элементов
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;        //сохраняем новый массив в поле items старого массива
    }
}
