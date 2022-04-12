package id.ac.uin.latihan.latihan3.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BookCreationDto {
  private List<Book> books;

  public BookCreationDto() {
    this.books = new ArrayList<>();
  }

  public BookCreationDto(List<Book> books) {
    this.books = books;
  }

  public void addBook(Book book) {
    this.books.add(book);
  }
}