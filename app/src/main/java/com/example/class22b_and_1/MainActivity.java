package com.example.class22b_and_1;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final int CUSTOMS_MAX = 220;
    private static final String TAG = "-->";

    Button submit;
    EditText fullNameInput;
    EditText idInput;
    EditText productPriceInput;
    ImageView success;
    ImageView failed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View c1 = findViewById(R.id.c1);

        // inputs
        fullNameInput = c1.findViewById(R.id.main_EDT_name);
        idInput = c1.findViewById(R.id.main_EDT_identifier);
        productPriceInput = c1.findViewById(R.id.main_LBL_productPrice);

        // images
        success = c1.findViewById(R.id.main_IMG_success);
        failed = c1.findViewById(R.id.main_IMG_failed);

        //button
        submit = c1.findViewById(R.id.main_BTN_submit);

        fullNameInput.setOnClickListener(e -> clearDefaultText(fullNameInput));
        idInput.setOnClickListener(e -> clearDefaultText(idInput));
        productPriceInput.setOnClickListener(e -> clearDefaultText(productPriceInput));

        submit.setOnClickListener(e -> handleClick());

    }

    private void handleClick() {

        try {
            String productPriceStr = productPriceInput.getText().toString();
            int productPrice = Integer.parseInt(productPriceStr);
            if(productPrice > CUSTOMS_MAX){
                failed.setVisibility(View.VISIBLE);
                failed.setImageResource(R.drawable.failed);
            }else{
                failed.setVisibility(View.VISIBLE);
                failed.setImageResource(R.drawable.success);
            }
        }catch (Exception e){
            Log.e(TAG, "handleClick: {}",e.getCause() );
        }
    }


    private void clearDefaultText(EditText textField){
        if(textField != null){
            textField.clearComposingText();
        }
    }
}