package pl.coderslab.beans.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.beans.model.Book;
import pl.coderslab.beans.service.BookService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/books", produces="text/html; charset=utf-8")
public class ManageBookController {

    private BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public String showPosts(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books/all";
    }

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String showAddBooks(Model model){
        model.addAttribute("newbook", new Book());
        return "books/add";
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String processAddBooks(@ModelAttribute("newbook") @Valid Book book, BindingResult result){
        if(result.hasErrors()){
            return "books/add";
        }
        bookService.create(book);
        return "redirect:/admin/books/all";
    }

    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String showEditBooks(@RequestParam long id, Model model){
        model.addAttribute("booktoedit", bookService.read(id).orElseThrow(()->{throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nie ma takiej książki");}));
        return "books/edit";
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public String processEditBooks(@ModelAttribute("booktoedit") @Valid Book book, BindingResult result){
        if(result.hasErrors()){
            return "books/edit";
        }
        bookService.update(book);
        return "redirect:/admin/books/all";
    }

    @RequestMapping(value="/delete", method=RequestMethod.GET)
    public String showDeleteBooks(@RequestParam long id, Model model){
        model.addAttribute("bootodelete", bookService.read(id).orElseThrow(()->{throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nie ma takiej książki");}));
        return "books/delete";
    }

    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public String processDeleteBook(Book book){
        bookService.delete(book.getId());
        return "redirect:/admin/books/all";
    }

    @GetMapping(value="/show")
    public String showShowBook(@RequestParam long id, Model model){
        model.addAttribute("booktoshow", bookService.read(id).orElseThrow(EntityNotFoundException::new));
        return "books/show";
    }



    @ModelAttribute("alltypes")
    public List<String> getBookTypes(){
        return Arrays.asList("SciFi", "Akcja", "Romans", "Biografia", "Gotowanie");
    }

}
