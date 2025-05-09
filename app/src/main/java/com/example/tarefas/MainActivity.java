package com.example.tarefas;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics firebaseAnalytics;
    private int[] concluido = new int[10];

    private boolean enviouTodas = false;
    private boolean enviouMetade = false;
    private boolean enviouAlguma = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAnalytics = FirebaseAnalytics.getInstance(this);

        // Ativar coleta automática de dados e não suprimir mensagens
        FirebaseInAppMessaging.getInstance().setAutomaticDataCollectionEnabled(true);
        FirebaseInAppMessaging.getInstance().setMessagesSuppressed(false);

        LinearLayout container = findViewById(R.id.container);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText("Tarefa " + (i + 1));
            container.addView(checkBox);

            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                concluido[index] = isChecked ? 1 : 0;
                verificarTarefas();
            });
        }
    }

    private void verificarTarefas() {
        int totalConcluidas = 0;
        for (int c : concluido) {
            totalConcluidas += c;
        }

        Log.d("FirebaseEvento", "Total concluídas: " + totalConcluidas);

        Bundle params = new Bundle();

        if (totalConcluidas == 10 && !enviouTodas) {
            params.putString("status", "todas");
            firebaseAnalytics.logEvent("tarefas_evento", params);
            Log.d("FirebaseEvento", "Evento: tarefas_evento - status=todas");
            enviouTodas = true;

        } else if (totalConcluidas >= 6 && !enviouMetade) {
            params.putString("status", "metade");
            firebaseAnalytics.logEvent("tarefas_evento", params);
            Log.d("FirebaseEvento", "Evento: tarefas_evento - status=metade");
            enviouMetade = true;

        } else if (totalConcluidas > 0 && !enviouAlguma) {
            params.putString("status", "alguma");
            firebaseAnalytics.logEvent("tarefas_evento", params);
            Log.d("FirebaseEvento", "Evento: tarefas_evento - status=alguma");
            enviouAlguma = true;
        }
    }
}
