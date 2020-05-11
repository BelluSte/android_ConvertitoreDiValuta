package belluste.convertitoredivaluta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText euro, dollari;
    private boolean start = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        euro = findViewById(R.id.editEuro);
        dollari = findViewById(R.id.editDollaro);
    }

    public void doConverti(View view) {

        double in, out;

        if (start) {
            if (euro.getText().length() > 0 && dollari.getText().length() == 0) {
                start = false;
                in = Double.parseDouble(euro.getText().toString());
                out = in * 1.08;
                dollari.setText(String.format("%.2f", out));
            } else if (euro.getText().length() == 0 && dollari.getText().length() > 0) {
                start = false;
                in = Double.parseDouble(dollari.getText().toString());
                out = in / 1.08;
                euro.setText(String.format("%.2f", out));
            } else if (euro.getText().length() > 0 && dollari.getText().length() > 0) {
                Toast err2 = Toast.makeText(getApplicationContext(), "Compila solo uno dei campi Euro/Dollari", Toast.LENGTH_LONG);
                err2.show();
            } else if (euro.getText().length() == 0 && dollari.getText().length() == 0) {
                Toast err3 = Toast.makeText(getApplicationContext(), "Inserisci un valore nel campo Euro/Dollari", Toast.LENGTH_LONG);
                err3.show();
            }
        } else {
            Toast err1 = Toast.makeText(getApplicationContext(), "Premi Reset per azzerare i campi ed eseguire una nuova conversione", Toast.LENGTH_LONG);
            err1.show();
        }
    }

    public void doReset(View view) {
        start = true;
        euro.getText().clear();
        dollari.getText().clear();
    }
}
