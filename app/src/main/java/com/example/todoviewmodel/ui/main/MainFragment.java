package com.example.todoviewmodel.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.todoviewmodel.R;
import com.example.todoviewmodel.Todo;

public class MainFragment extends Fragment {


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    private MainViewModel mViewModel;

    private Todo mTodo = new Todo();
    private int mTodoIndex = 0;
    private TextView mTextViewTitle;
    private TextView mTextViewDate;
    private Button mButtonNext;
    private Button mButtonPrev;
    private Button mButtonTodoDetail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment, container, false);
        mViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        mTodoIndex = mViewModel.getTodoIndex();

        mTextViewTitle = view.findViewById(R.id.todo_title);
        mTextViewDate = view.findViewById(R.id.todo_date);

        mButtonNext = (Button) view.findViewById(R.id.buttonNext);
        mButtonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mTodoIndex = (mTodoIndex + 1) % mViewModel.size();
                mViewModel.setTodoIndex(mTodoIndex);
                mTodo = mViewModel.getTodo(mTodoIndex);
                mTextViewTitle.setText(mTodo.getTitle());
            }
        });

        mButtonPrev = (Button) view.findViewById(R.id.buttonPrev);
        mButtonPrev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mTodoIndex == 0){
                    mTodoIndex = mViewModel.size() - 1;
                } else {
                    mTodoIndex -= 1;
                }
                mViewModel.setTodoIndex(mTodoIndex);
                mTodo = mViewModel.getTodo(mTodoIndex);
                mTextViewTitle.setText(mTodo.getTitle());
            }
        });

        mButtonTodoDetail = (Button) view.findViewById(R.id.buttonTodoDetail);
        mButtonTodoDetail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                mViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
                TodoDetailFragment todoDetailFragment = TodoDetailFragment.newInstance();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, todoDetailFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        // TODO: Use the ViewModel
        mTodo = mViewModel.getTodo(mTodoIndex);
        mTextViewTitle.setText(mTodo.getTitle());
        mTextViewDate.setText(mTodo.getDate().toString());

    }

}
