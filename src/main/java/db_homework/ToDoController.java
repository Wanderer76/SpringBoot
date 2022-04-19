package db_homework;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/todo")
public class ToDoController {

    private final TodoService todoService;

    public ToDoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<TodoDto> getAllTodos() {
        return todoService.getAllToDo();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> addTodo(@RequestBody @Valid TodoDto body) {
        ToDo todo = todoService.convertFromDto(body);
        todoService.saveTodo(todo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
