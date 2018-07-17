package comq.acadview.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {
    EditText content, title;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        content = findViewById(R.id.et_content);
        title = findViewById(R.id.et_title);
        save = findViewById(R.id.btn_save);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (title.getText().toString().isEmpty()) {
                    Toast.makeText(DetailsActivity.this, "Note is Empty", Toast.LENGTH_LONG).show();
                } else {
                    DBClass dbClass = new DBClass(DetailsActivity.this);
                    dbClass.addData(title.getText().toString(), content.getText().toString());
                    Toast.makeText(DetailsActivity.this, "File Saved", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
