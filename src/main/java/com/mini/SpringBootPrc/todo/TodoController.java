package com.mini.SpringBootPrc.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private  TodoService todoService;

    public TodoController(TodoService todoService) {

        this.todoService = todoService;
    }

    @RequestMapping(value = "to-do-list", method = RequestMethod.GET)
    public String getTodoList(ModelMap model) {

        List<Todo> todos = todoService.findByUser("whs");
        model.put("todos",todos);
        return "todoList";
    }
}
