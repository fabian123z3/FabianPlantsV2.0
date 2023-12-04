package cl.santotomas.fabianplants;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class comunesmain extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlantaAdapter plantaAdapter;
    private List<Planta> plantaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunesmain);

        recyclerView = findViewById(R.id.listaComunes);

        // Crear datos de ejemplo
        plantaList = new ArrayList<>();
        plantaList.add(new Planta("Rosa"));
        plantaList.add(new Planta("Tulipán"));
        plantaList.add(new Planta("Girasol"));
        plantaList.add(new Planta("Orquídea"));
        plantaList.add(new Planta("Menta"));
        plantaList.add(new Planta("Cactus"));
        plantaList.add(new Planta("Aloe vera"));
        plantaList.add(new Planta("Bambú"));
        plantaList.add(new Planta("Pothos"));
        plantaList.add(new Planta("Caléndula"));

        // Configurar el RecyclerView y el adaptador
        plantaAdapter = new PlantaAdapter(this, plantaList);
        recyclerView.setAdapter(plantaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
