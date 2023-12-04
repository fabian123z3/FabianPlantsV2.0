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

import com.bumptech.glide.Glide; // Agrega esta importación para usar Glide

import java.util.List;

public class PlantaAdapter extends RecyclerView.Adapter<PlantaAdapter.PlantaViewHolder> {

    private List<Planta> plantaList;
    private Context context;

    public PlantaAdapter(Context context, List<Planta> plantaList) {
        this.context = context;
        this.plantaList = plantaList;
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
        holder.plantaName.setText(planta.getNombre());

        // Cargar imágenes utilizando Glide
        // Asume que el nombre de la imagen coincide con el nombre de la planta
        String nombreImagen = planta.getNombre().toLowerCase().replace("", "_"); // Convierte a minúsculas y reemplaza espacios
        int idImagen = context.getResources().getIdentifier(nombreImagen, "drawable", context.getPackageName());

        Glide.with(context)
                .load(idImagen)
                .placeholder(R.drawable.rosa_imagen) // Imagen de carga mientras se carga la imagen
                .error(R.drawable.rosa_imagen) // Imagen de error si no se puede cargar la imagen
                .into(holder.plantaImage);

        // Agregar lógica adicional según sea necesario
    }

    @Override
    public int getItemCount() {
        return plantaList.size();
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
