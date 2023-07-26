package bit.edu.book.controller.admin;

import bit.edu.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Controller
@RequestMapping("/admin/books")
@RequiredArgsConstructor
public class BookAdminController {

    private final BookService bookService;

    @GetMapping
    public String bookList(Model model) {
        model.addAttribute("books", bookService.findAllBook());

        return "/book/list";
    }
}
