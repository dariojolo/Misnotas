package ar.com.dariojolo.misnotas;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapterFavs extends RecyclerView.Adapter<MyHolderFavs> {

        Context context;
        ArrayList<CardModel> listado; //Lista donde se va a guardar la info para mostrar en el RecyclerView

        public MyAdapterFavs(Context context, ArrayList<CardModel> listado) {
            this.context = context;
            this.listado = listado;
        }

        @NonNull
        @Override
        public MyHolderFavs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_fav,null); //Infla el elemento del recyclerview a cargar
            return new MyHolderFavs(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final MyHolderFavs holder, int position) {
            holder.mTitle.setText(listado.get(position).getTitle());
            holder.mDescription.setText(listado.get(position).getDescription());
            holder.mImage.setImageResource(listado.get(position).getImg());

            holder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onItemClickListener(View view, int position) {
                    String gTitle = listado.get(position).getTitle();
                    String gDesc = listado.get(position).getDescription();
                //    BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImage.getDrawable();

                //    Bitmap bitmap = bitmapDrawable.getBitmap();

                    //   ByteArrayOutputStream stream = new ByteArrayOutputStream();

                //    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

                //    byte[]bytes = stream.toByteArray();
                    Toast.makeText(context, "Presionado: " + gTitle, Toast.LENGTH_SHORT).show();

                    /*Intent intent = new Intent(context, DetailActivity.class);

                    intent.putExtra("iTitle", gTitle);
                    intent.putExtra("iDesc", gDesc);
                    intent.putExtra("iImage", bytes);

                    context.startActivity(intent); */
                }
            });
        }

        @Override
        public int getItemCount() {
            return listado.size();
        }
    }
