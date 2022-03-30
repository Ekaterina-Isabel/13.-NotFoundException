package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();     //вызов конструктора, для создания объекта repository

    Product product1 = new Book(1, "name1", 100, "author1");
    Product product2 = new Book(2, "book1", 110, "author2");
    Product product3 = new Smartphone(3, "smartphone1", 120, "producer1");
    Product product4 = new Smartphone(4, "smartphone2", 130, "producer2");

    @Test
    void shouldAddProductsInRepository() {       //добавь продукты в репозиторий
        repository.save(product1);

        Product[] expected = { product1 };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {     //найди продукт по ID
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);

        Product expected = product2;
        Product actual = repository.findById(2);
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {       //удали продукт по id
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);

        repository.removeById(2);

        Product[] expected = {product1, product3, product4};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldThrowNotFoundException() {       //генерации NotFoundException при попытке удаления несуществующего элемента по id
        repository.save(product1);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(2);
        });
    }
}