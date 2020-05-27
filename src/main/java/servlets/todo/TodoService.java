package servlets.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoService {

    private static List<Todo> todos = new ArrayList<Todo>(Arrays.asList(
      new Todo("Learn about programing"),
      new Todo("Programing in Java"),
      new Todo("Programing again and forever")
    ));

    public List<Todo> retriveTodos(){
        return todos;
    }

    public void addTodo(String todo){
        todos.add(new Todo(todo));
    }

    public void deleteTodo(Todo todo){
        todos.remove(todo);
    }

}
