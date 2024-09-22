package fi.haagahelia.bookdatabase.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.bookdatabase.domain.Book;
import fi.haagahelia.bookdatabase.domain.BookRepository;
import fi.haagahelia.bookdatabase.domain.CategoryRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;

    @RequestMapping(value = { "/", "/booklist" })
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "bookform";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        repository.deleteById(id);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book = repository.findById(id).orElse(null);
        model.addAttribute("book", book);
        model.addAttribute("categories", crepository.findAll());
        return "bookform";
    }

    // Rest service for getting all books
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) repository.findAll();
    }

    // Rest service for finding a book by id
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long id) {
        Optional<Book> book = repository.findById(id);
        return book.orElse(null);
    }

    // Rest service for finding a book by title
    @RequestMapping(value = "/books/search/title", method = RequestMethod.GET)
    public @ResponseBody List<Book> findBookByTitle(@RequestParam("title") String title) {
        return repository.findByTitle(title);
    }

    // Rest service for adding a book
    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public @ResponseBody Book addBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }
}
