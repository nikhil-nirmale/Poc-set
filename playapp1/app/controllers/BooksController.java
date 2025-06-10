package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Book;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.Set;

public class BooksController extends Controller {

    // GET /books - Return all books as JSON
    public Result index() {
        Set<Book> books = Book.allBooks();
        return ok(Json.toJson(books));
    }

    // GET /books/:id - Return one book as JSON
    public Result show(Integer id) {
        Book book = Book.findById(id);
        if (book == null) {
            return notFound(Json.toJson("Book not found"));
        }
        return ok(Json.toJson(book));
    }

    // POST /books - Create a new book from JSON
    public Result save(Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(Json.toJson("Expecting JSON data"));
        }

        Book book = Json.fromJson(json, Book.class);
        Book.add(book);
        return created(Json.toJson(book));
    }

    // PUT /books/:id - Update existing book with JSON data
    public Result update(Integer id, Http.Request request) {
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(Json.toJson("Expecting JSON data"));
        }

        Book existing = Book.findById(id);
        if (existing == null) {
            return notFound(Json.toJson("Book not found"));
        }

        Book updated = Json.fromJson(json, Book.class);
        updated.setId(id);  // preserve original ID
        Book.update(updated);

        return ok(Json.toJson(updated));
    }

    // DELETE /books/:id - Delete a book
    public Result destroy(Integer id) {
        boolean deleted = Book.deleteById(id);
        if (!deleted) {
            return notFound(Json.toJson("Book not found"));
        }
        return ok(Json.toJson("Deleted"));
    }
}
