package db_homework;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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

    public ToDo convertFromDto(TodoDto todo) {
        var todoDto = modelMapper.map(todo, ToDo.class);
        todoDto.setEvents(todo.getEventsDto().stream().map(Event::new).toList());
        return todoDto;
    }

    public ToDo createFromJson(JSONObject data) {
        if (data.keySet().size() > 2)
            throw new IllegalArgumentException();
        if (!data.containsKey("name") || !data.containsKey("events"))
            throw new IllegalArgumentException();

        var name = (String) data.get("name");
        var events = (JSONArray) data.get("events");

        if (events.size() == 0)
            throw new IllegalArgumentException();

        return new ToDo(name, events.stream().map(obj -> new Event((String) obj)).toList());
    }

    public void saveTodo(ToDo toDo) {
        repository.save(toDo);
    }


}
