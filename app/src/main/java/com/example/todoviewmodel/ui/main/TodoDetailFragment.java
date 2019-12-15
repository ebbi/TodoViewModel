package com.example.todoviewmodel.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.todoviewmodel.R;
import com.example.todoviewmodel.Todo;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodoDetailFragment extends Fragment {

    private MainViewModel mViewModel;
    private Todo mTodo = new Todo();
    private int mTodoIndex = 0;

    private TextView mTextViewTitle;
    private TextView mTextViewDate;
    private EditText mEditTextDetail;
    private CheckBox mIsComplete;
    private CheckBox mIsPending;
    private Button mButtonUpdateDetail;

    public static TodoDetailFragment newInstance() {
        return new TodoDetailFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_todo_detail, container, false);

        mViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        mTodoIndex = mViewModel.getTodoIndex();
        mTodo = mViewModel.getTodo(mTodoIndex);

        mTextViewTitle = view.findViewById(R.id.todo_title);
        mTextViewTitle.setText(mTodo.getTitle());

        mTextViewDate = view.findViewById(R.id.todo_date);
        mTextViewDate.setText(mTodo.getDate().toString());

        mEditTextDetail = view.findViewById(R.id.editTextDetail);
        mEditTextDetail.setText(mTodo.getDetail());

        mIsComplete = view.findViewById(R.id.checkBoxComplete);
        mIsComplete.setChecked(mTodo.isComplete());

        mIsPending = view.findViewById(R.id.checkBoxPending);
        mIsPending.setChecked(mTodo.isPending());

        mButtonUpdateDetail = (Button) view.findViewById(R.id.buttonUpdateDetail);
        mButtonUpdateDetail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                mTodo.setDetail(mEditTextDetail.getText().toString());
                mTodo.setIsComplete(mIsComplete.isChecked());
                mTodo.setIsPending(mIsPending.isChecked());
                mViewModel.setTodo(mTodoIndex, mTodo);

                MainFragment mainFragment = MainFragment.newInstance();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, mainFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });


        return view;

    }

}
