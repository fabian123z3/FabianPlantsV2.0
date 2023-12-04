package cl.santotomas.fabianplants;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlantaAdapter extends RecyclerView.Adapter<PlantaAdapter.PlantaViewHolder> {

    private List<Planta> plantaList;
    private Context context;
    private Map<String, Integer> imagenMap; // Mapa para asociar nombres de plantas con recursos de imagen

    public PlantaAdapter(Context context, List<Planta> plantaList) {
        this.context = context;
        this.plantaList = plantaList;
        cargarImagenes(); // Inicializar el mapa de imágenes al crear el adaptador
    }

    // Método para cargar imágenes en el mapa
    private void cargarImagenes() {
        imagenMap = new HashMap<>();
        imagenMap.put("rosa", R.drawable.rosa_imagen);
        imagenMap.put("tulipán", R.drawable.tulipan_imagen);
        imagenMap.put("girasol", R.drawable.girasol_imagen);
        imagenMap.put("orquídea", R.drawable.orquidea_imagen);
        imagenMap.put("menta", R.drawable.menta_imagen);
        imagenMap.put("cactus", R.drawable.cactus_imagen);
        imagenMap.put("aloe vera", R.drawable.aloe_imagen);
        imagenMap.put("bambú", R.drawable.bambu_imagen);
        imagenMap.put("pino", R.drawable.pino_imagen);
        imagenMap.put("caléndula", R.drawable.calendula_imagen);
        // Agrega más asociaciones de nombres de plantas con recursos de imagen según sea necesario
    }

    @NonNull
    @Override
    public PlantaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_planta_cardview, parent, false);
        return new PlantaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantaViewHolder holder, int position) {
        Planta planta = plantaList.get(position);

        // Configurar los datos en la vista
        holder.plantaName.setText(planta.getNombre().substring(0, 1).toUpperCase() + planta.getNombre().substring(1)); // Capitalizar el nombre
        int idImagen = obtenerIdImagen(planta.getNombre().toLowerCase()); // Obtener el ID del recurso de imagen

        Glide.with(context)
                .load(idImagen)
                .placeholder(R.drawable.ic_launcher_foreground) // Imagen de carga mientras se carga la imagen
                .error(R.drawable.arbol) // Imagen de error si no se puede cargar la imagen
                .into(holder.plantaImage);
    }

    @Override
    public int getItemCount() {
        return plantaList.size();
    }

    // Método para obtener el ID del recurso de imagen según el nombre de la planta
    private int obtenerIdImagen(String nombrePlanta) {
        Integer idImagen = imagenMap.get(nombrePlanta);
        return idImagen != null ? idImagen : R.drawable.arbol; // Por defecto, usa "arbol" si no se encuentra la imagen
    }

    public static class PlantaViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView plantaImage;
        TextView plantaName;

        public PlantaViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardViewPlanta);
            plantaImage = itemView.findViewById(R.id.plantaImage);
            plantaName = itemView.findViewById(R.id.plantaName);
        }
    }
}
