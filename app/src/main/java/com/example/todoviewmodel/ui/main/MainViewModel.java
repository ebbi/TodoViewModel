package com.example.todoviewmodel.ui.main;

import androidx.lifecycle.ViewModel;

import com.example.todoviewmodel.Todo;
import com.example.todoviewmodel.TodoRepository;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private int todoIndex = 0;

    private Todo selectedTodo = new Todo();
//    private final MutableLiveData<Todo> selectedTodo = new MutableLiveData<Todo>();

    private TodoRepository todoRepository = TodoRepository.newInstance();

    public int getTodoIndex() {
        return todoIndex;
    }

    public void setTodoIndex(int todoIndex) {
        this.todoIndex = todoIndex;
        selectedTodo = todoRepository.getTodo(todoIndex);
//        selectedTodo.setValue(todoRepository.getTodo(todoIndex));
    }

    public ArrayList getTodoList() {
        return todoRepository.getTodoList();
    }

    public int size(){
        return todoRepository.size();
    }

    public Todo getTodo(int todoIndex) {
        return todoRepository.getTodo(todoIndex);
    }

    public void setTodo(int todoIndex, Todo todo) {
        todoRepository.setTodo(todoIndex, todo);
    }

/*
    public void setSelectedTodo(Todo selectedTodo) {
        this.selectedTodo = selectedTodo;
    }

    public Todo getSelectedTodo() {
        return selectedTodo;
    }
 */

}
