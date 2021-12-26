package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    public static final Book warAndPeace = new Book(1, "warAndPeace", 1550, "tolstoy");
    public static final Book moron = new Book(2, "moron", 760, "dostoevsky");
    public static final Smartphone galaxyA40 = new Smartphone(6, "galaxyA40", 16000, "samsung");
    public static final Smartphone iPhone13 = new Smartphone(7, "iPhone13", 54000, "apple");

    @BeforeEach
    @Test
    public void shouldSaveProduct() {
        repository.save(warAndPeace);
        repository.save(moron);
        repository.save(galaxyA40);
        repository.save(iPhone13);
    }

    @Test
    public void shouldNotFoundException() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(10);
        });
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(7);
        Product[] expected = {warAndPeace, moron, galaxyA40};
        Product[] actual = repository.findAll();
        assertArrayEquals(actual, expected);
    }
}

