package comq.acadview.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditDetailsActivity extends AppCompatActivity {
    EditText title, content;
    Button update, delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);
        title = findViewById(R.id.et_title);
        content = findViewById(R.id.et_content);
      //  update = findViewById(R.id.btn_update);
        delete = findViewById(R.id.btn_delete);
        final DBClass dbClass = new DBClass(getApplicationContext());

        Bundle bundle = getIntent().getExtras();

        String str1 = bundle.getString("Title");
        String str2 = bundle.getString("Content");

        title.setText(str1);
        content.setText(str2);

       /* update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBClass dbClass = new DBClass(EditDetailsActivity.this);
                dbClass.onUpdate(title.getText().toString(), content.getText().toString());
                Toast.makeText(EditDetailsActivity.this, "File Updated", Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(EditDetailsActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
*/
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DBClass dbClass = new DBClass(EditDetailsActivity.this);
                dbClass.onDelete(title.getText().toString());
                Intent intent2 = new Intent(EditDetailsActivity.this, MainActivity.class);
                startActivity(intent2);
                Toast.makeText(EditDetailsActivity.this, "Item Deleted", Toast.LENGTH_LONG).show();

            }
        });

    }
}
