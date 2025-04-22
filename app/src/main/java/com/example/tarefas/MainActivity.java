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

        if (totalConcluidas == 10 && !enviouTodas) {
            firebaseAnalytics.logEvent("todas_tarefas_concluidas", null);
            Log.d("FirebaseEvento", "Evento: todas_tarefas_concluidas");
            enviouTodas = true;
        } else if (totalConcluidas >= 6 && !enviouMetade) {
            firebaseAnalytics.logEvent("tarefas_metade", null);
            Log.d("FirebaseEvento", "Evento: tarefas_metade");
            enviouMetade = true;
        } else if (totalConcluidas > 0 && !enviouAlguma) {
            firebaseAnalytics.logEvent("tarefa_concluida", null);
            Log.d("FirebaseEvento", "Evento: tarefa_concluida");
            enviouAlguma = true;
        }
    }
}
