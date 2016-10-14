package com.n0hands.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.RelativeLayout;

import com.n0hands.todoapp.model.Category;
import com.n0hands.todoapp.model.TodoItem;

import java.util.List;

public class TodoItemsList extends AppCompatActivity {
    private RecyclerView todoList;
    private TodoItemsAdapter todoItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_items_list);

        this.todoList = (RecyclerView) this.findViewById(R.id.todo_items_list);

        List<TodoItem> todoItems = TodoItem.listAll(TodoItem.class);
        todoItemsAdapter = new TodoItemsAdapter(todoItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        todoList.setLayoutManager(mLayoutManager);
        todoList.setItemAnimator(new DefaultItemAnimator());
        todoList.setAdapter(todoItemsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
