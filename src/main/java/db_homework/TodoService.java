package db_homework;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final ToDoRepository repository;
    private final ModelMapper modelMapper;

    public TodoService(ToDoRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<TodoDto> getAllToDo() {
        var todos = repository.findAll();
        return MapperUtil.convertList(todos, this::convertToDto);
    }

    private TodoDto convertToDto(ToDo todo) {
        var todoDto = modelMapper.map(todo, TodoDto.class);
        todoDto.setEventsDto(todo.getEvents().stream().map(Event::getEvent).toList());
        return todoDto;
    }

    private ToDo convertFromDto(TodoDto todo) {
        var todoDto = modelMapper.map(todo, ToDo.class);
        todoDto.setEvents(todo.getEventsDto().stream().map(Event::new).toList());
        return todoDto;
    }

    public void saveTodo(TodoDto toDo) {
        var todo = convertFromDto(toDo);
        repository.save(todo);
    }
}
