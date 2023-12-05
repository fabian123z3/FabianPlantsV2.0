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

public class PlantaAdapterExoticas extends RecyclerView.Adapter<PlantaAdapterExoticas.PlantaViewHolder> {

    private List<Planta> plantaList;
    private Context context;
    private Map<String, Integer> imagenMap;

    public PlantaAdapterExoticas(Context context, List<Planta> plantaList) {
        this.context = context;
        this.plantaList = plantaList;
        cargarImagenes();
    }

    private void cargarImagenes() {
        imagenMap = new HashMap<>();
        imagenMap.put("Mariguana", R.drawable.girasol_image);
        // Agrega más plantas y sus imágenes según sea necesario
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

        holder.plantaName.setText(planta.getNombre().substring(0, 1).toUpperCase() + planta.getNombre().substring(1));
        int idImagen = obtenerIdImagen(planta.getNombre().toLowerCase());

        Glide.with(context)
                .load(idImagen)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.arbol)
                .into(holder.plantaImage);
    }

    @Override
    public int getItemCount() {
        return plantaList.size();
    }

    private int obtenerIdImagen(String nombrePlanta) {
        Integer idImagen = imagenMap.get(nombrePlanta);
        return idImagen != null ? idImagen : R.drawable.arbol;
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
