package cl.santotomas.fabianplants;

// ExoticasMain.java
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class exoticasmain extends AppCompatActivity {
    private RecyclerView plantRecyclerView;
    private PlantAdapter plantAdapter;
    private List<Planta> plantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exoticasmain);

        plantRecyclerView = findViewById(R.id.plantRecyclerView);
        plantList = obtenerDatosDePlantas(); // Obtiene datos de plantas (en este ejemplo, solo una planta)
        plantAdapter = new PlantAdapter(plantList);

        plantRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        plantRecyclerView.setAdapter(plantAdapter);

        plantAdapter.setOnItemClickListener(new PlantAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // No se requiere acción especial en esta implementación
            }
        });
    }

    private List<Planta> obtenerDatosDePlantas() {
        List<Planta> lista = new ArrayList<>();
        Planta planta1 = new Planta("Planta Carnívora", "waaaa");
        Planta planta2 = new Planta("Planta Mariguana", "waaaa");
        Planta planta3 = new Planta("Planta Pasiflora", "waaaa");
        Planta planta4 = new Planta("Planta Carnívora", "waaaa");


        lista.add(planta1);
        lista.add(planta2);
        lista.add(planta3);
        lista.add(planta4);
        return lista;
    }
}
