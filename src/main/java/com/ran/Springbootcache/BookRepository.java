package com.ran.Springbootcache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private List<Book> list;

    BookRepository() {
        list = new ArrayList<>();
        list.add(new Book(101, "Java1 Complete Reference"));
        list.add(new Book(102, "Java2 Complete Reference"));
        list.add(new Book(103, "Java3 Complete Reference"));
        list.add(new Book(104, "Java4 Complete Reference"));
        list.add(new Book(105, "Java5 Complete Reference"));
        list.add(new Book(106, "Java6 Complete Reference"));
        list.add(new Book(107, "Java7 Complete Reference"));
        list.add(new Book(108, "Java8 Complete Reference"));
    }

    @Cacheable("books")
    public String findById(int id) {
        System.out.println("BookRepository findById{} ..."+id);
        sleep();
        return list.stream().filter(b -> b.id == id).findFirst().map(Book::getName).orElse(null);
    }

    private void sleep() {
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
