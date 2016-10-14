package odravison.com.br.todoexample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import odravison.com.br.todoexample.R;

public class TaskCreateActivity extends AppCompatActivity {

    Button saveButton;
    Button cancelButton;
    EditText taskDescribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_create);

        saveButton = (Button) findViewById(R.id.save_button);
        cancelButton = (Button) findViewById(R.id.cancel_button);
        taskDescribe  = (EditText) findViewById(R.id.task_describe);

        saveButton.setEnabled(false);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Here is where the controller gonna save the task.
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        taskDescribe.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                enableButton(saveButton, charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                enableButton(saveButton, charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    public void enableButton(Button button, CharSequence charSequence){
        if (charSequence.length() > 0){
            button.setEnabled(true);
        }
        else{
            button.setEnabled(false);
        }
    }
}
