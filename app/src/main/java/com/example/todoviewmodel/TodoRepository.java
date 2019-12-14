package com.example.todoviewmodel;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;

public class TodoRepository {

    private static TodoRepository sTodoRepository;

    private ArrayList<Todo> mTodoList;

    public static TodoRepository newInstance() {
        if (sTodoRepository == null) {
            sTodoRepository = new TodoRepository();
        }
        return sTodoRepository;
    }

    private TodoRepository(){
        mTodoList = new ArrayList<>();
        initTestData();
    }

    private void initTestData() {
        for (int i=0; i < 3; i++){
            Todo todo = new Todo();
            todo.setId(i);
            todo.setTitle("Title " + i);
            todo.setDetail("Detail for task " + todo.getTitle());
            todo.setDate(new Date());
            todo.setIsComplete(false);
            todo.setIsPending(false);

            mTodoList.add(todo);
        }
    }

    public ArrayList getTodoList() {
        return this.mTodoList;
    }

    public int size() {
        return mTodoList.size();
    }

    public Todo getTodo(int todoIndex) {
        return this.mTodoList.get(todoIndex);
    }

}
