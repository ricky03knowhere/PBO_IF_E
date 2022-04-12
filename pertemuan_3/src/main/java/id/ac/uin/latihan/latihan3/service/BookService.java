package id.ac.uin.latihan.latihan3.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import id.ac.uin.latihan.latihan3.model.Book;


@Service
public class BookService {
  static Map<Long, Book> booksDB = new HashMap<>();

  public List<Book> findAll() {
    return new ArrayList<>(booksDB.values());
  }

  public void saveAll(List<Book> books) {
    long nextId = getNextId();
    for (Book book : books) {
      if (book.getId() == 0) {
        book.setId(nextId++);
      }
    }

    Map<Long, Book> bookMap = books.stream().collect(Collectors.toMap(Book::getId, Function.identity()));
    booksDB.putAll(bookMap);
  }

  private Long getNextId() {
    return booksDB.keySet().stream().mapToLong(value -> value).max().orElse(0) + 1;
  }
}
