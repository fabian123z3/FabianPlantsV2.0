package cl.santotomas.fabianplants;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class exoticasmain extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PlantaAdapterExoticas plantaAdapter;
    private List<Planta> nuevoPlantaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exoticasmain);

        recyclerView = findViewById(R.id.ListaExoticos);

        nuevoPlantaList = new ArrayList<>();
        nuevoPlantaList.add(new Planta("MAriguana"));
        nuevoPlantaList.add(new Planta("Pasiflora"));
        nuevoPlantaList.add(new Planta("Strelitzia reginae"));
        nuevoPlantaList.add(new Planta("Ficus lyrata"));
        nuevoPlantaList.add(new Planta("Tillandsia"));
        nuevoPlantaList.add(new Planta("Plumeria"));
        nuevoPlantaList.add(new Planta("Planta carnivora"));
        nuevoPlantaList.add(new Planta("Ceropegia woodii"));
        nuevoPlantaList.add(new Planta("Cattleya"));
        nuevoPlantaList.add(new Planta("Sansevieria cylindrica"));
        // Agrega más plantas según sea necesario

        plantaAdapter = new PlantaAdapterExoticas(this, nuevoPlantaList);
        recyclerView.setAdapter(plantaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
