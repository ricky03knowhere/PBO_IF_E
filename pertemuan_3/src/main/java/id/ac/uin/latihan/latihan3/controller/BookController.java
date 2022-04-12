package id.ac.uin.latihan.latihan3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.uin.latihan.latihan3.model.Book;
import id.ac.uin.latihan.latihan3.model.BookCreationDto;
import id.ac.uin.latihan.latihan3.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
  @Autowired
  private BookService bookService;

  @GetMapping
  public String showAll(Model model) {
    model.addAttribute("books", bookService.findAll());
    return "books/allBooks";
  }

  @GetMapping(value = "/create")
  public String showCreateForm(Model model) {
    BookCreationDto booksForm = new BookCreationDto();

    for (int i = 0; i <= 3; i++) {
      booksForm.addBook(new Book());
    }

    model.addAttribute("form", booksForm);

    return "books/createBooksForm";
  }

  @GetMapping(value = "/edit")
  public String showEditForm(Model model) {
    List<Book> books = new ArrayList<>();
    bookService.findAll().iterator().forEachRemaining(books::add);

    model.addAttribute("form", new BookCreationDto(books));

    return "books/editBooksForm";
  }

  @PostMapping
  public String saveBooks(@ModelAttribute BookCreationDto form, Model model) {
    bookService.saveAll(form.getBooks());
    model.addAttribute("books", bookService.findAll());

    return "redirect:/books";

  }
}
