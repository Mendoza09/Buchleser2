package ujcv.edu.hn.buchleser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int RC_SIGN_IN = 42;


    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void Registrarse(View view) {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build());


        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);

        setContentView(R.layout.activity_cart);

    }

    public void botoning(View view) {

        Button btn = (Button) findViewById(R.id.botoning);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),PruebaActivity.class);
                startActivity(intent);
            }
        });
       /* Intent intent = new Intent(this,BooksActivity.class);
        Button button = (Button)findViewById(R.id.botoning);
        startActivity(intent);*/


    }
}






