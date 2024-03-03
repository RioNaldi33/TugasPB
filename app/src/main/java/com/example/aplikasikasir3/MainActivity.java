package com.example.aplikasikasir3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox charger, mousePad, pulsa, headset, mouse;
    private EditText jumlahCharger, jumlahMousePad, jumlahPulsa, jumlahHeadset, jumlahMouse;
    private RadioButton membershipRadioButton, nonMembershipRadioButton;
    private Button processButton;
    private TextView receiptTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        charger = findViewById(R.id.charger);
        mousePad = findViewById(R.id.mousePad);
        pulsa = findViewById(R.id.pulsa);
        headset = findViewById(R.id.headset);
        mouse = findViewById(R.id.mouse);
        jumlahCharger = findViewById(R.id.jumlahCharger);
        jumlahMousePad = findViewById(R.id.jumlahMousePad);
        jumlahPulsa = findViewById(R.id.jumlahPulsa);
        jumlahHeadset = findViewById(R.id.jumlahHeadset);
        jumlahMouse = findViewById(R.id.jumlahMouse);
        membershipRadioButton = findViewById(R.id.membershipRadioButton);
        nonMembershipRadioButton = findViewById(R.id.nonMembershipRadioButton);
        processButton = findViewById(R.id.processButton);
        receiptTextView = findViewById(R.id.receiptTextView);

        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatecode();
            }
        });
    }

    private void generatecode() {
        StringBuilder receipt = new StringBuilder();
        double totalHarga = 0;
        int hargaCharger = 20000;
        int hargaMoPed = 10000;
        int hargaPulsa= 10000;
        int hargaHeadset = 50000;
        int hargaMouse= 100000;

        int adminCharger = 2000;
        int adminMoped = 3000;
        int adminPulsa = 2000;
        int adminHeadset = 3000;
        int adminMouse = 4000;

        if (charger.isChecked()) {
            int jumlah = Integer.parseInt(jumlahCharger.getText().toString());
            double subTotal = jumlah * hargaCharger;
            totalHarga += subTotal;
            receipt.append("Charger: ").append(jumlah).append(" pcs \n Harga Rp").append(subTotal).append("\n");
            receipt.append("admin: Rp.").append(adminCharger).append("\n");
        }

        if (mousePad.isChecked()) {
            int jumlah = Integer.parseInt(jumlahMousePad.getText().toString());
            double subTotal = jumlah * hargaMoPed;
            totalHarga += subTotal;
            receipt.append("Mouse pad: ").append(jumlah).append(" pcs \n Harga Rp").append(subTotal).append("\n");
            receipt.append("admin: Rp.").append(adminMoped).append("\n");
        }

        if (pulsa.isChecked()) {
            int jumlah = Integer.parseInt(jumlahPulsa.getText().toString());
            double subTotal = jumlah * hargaPulsa;
            totalHarga += subTotal;
            receipt.append("Pulsa: ").append(jumlah).append(" pcs \n Harga Rp").append(subTotal).append("\n");
            receipt.append("admin: Rp.").append(adminPulsa).append("\n");
        }

        if (headset.isChecked()) {
            int jumlah = Integer.parseInt(jumlahHeadset.getText().toString());
            double subTotal = jumlah * hargaHeadset;
            totalHarga += subTotal;
            receipt.append("Headset: ").append(jumlah).append(" pcs \n Harga Rp").append(subTotal).append("\n");
            receipt.append("admin: Rp.").append(adminHeadset).append("\n");
        }

        if (mouse.isChecked()) {
            int jumlah = Integer.parseInt(jumlahMouse.getText().toString());
            double subTotal = jumlah * hargaMouse;
            totalHarga += subTotal;
            receipt.append("Mouse: ").append(jumlah).append(" pcs \n Harga Rp").append(subTotal).append("\n");
            receipt.append("admin: Rp.").append(adminMouse).append("\n");
        }



        double diskon = 0;
        if (membershipRadioButton.isChecked()) {
            diskon = 0.05 * totalHarga;
        }

        double totalBayar = totalHarga - diskon;

        int totalAdmin = adminCharger;
        receipt.append("\nTotal Harga: Rp").append(totalHarga);
        receipt.append("\nDiskon : Rp").append(diskon);
        receipt.append("\nTotal Bayar: Rp").append(totalBayar);
        receipt.append("\nBiaya Admin: Rp").append(totalAdmin);
        receipt.append("\nHarga Akhir: Rp").append(totalBayar + totalAdmin);
        receiptTextView.setText(receipt.toString());
    }
}