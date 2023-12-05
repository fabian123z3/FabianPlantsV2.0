package cl.santotomas.fabianplants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class fruterasmain extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlantaAdapterExoticas plantaAdapter;
    private List<Planta> nuevoPlantaList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruterasmain);
        recyclerView = findViewById(R.id.ListaFruteras);

        nuevoPlantaList = new ArrayList<>();
        nuevoPlantaList.add(new Planta("Manzano "));
        nuevoPlantaList.add(new Planta("Naranjo "));
        nuevoPlantaList.add(new Planta("Limero "));
        nuevoPlantaList.add(new Planta("Ciruelo"));
        nuevoPlantaList.add(new Planta("Duraznero"));
        nuevoPlantaList.add(new Planta("Palto"));
        nuevoPlantaList.add(new Planta("Granado"));
        nuevoPlantaList.add(new Planta("Ciruelo japonés"));
        nuevoPlantaList.add(new Planta("Papaya"));
        // Agrega más plantas según sea necesario

        plantaAdapter = new PlantaAdapterExoticas(this, nuevoPlantaList);
        recyclerView.setAdapter(plantaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}