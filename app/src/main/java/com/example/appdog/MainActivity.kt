package com.example.appdog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdog.data.repositories.RetrofitClient
import com.example.appdog.ui.screen.BreedAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            try {
                // Obtener la lista de razas
                val breedListResponse = RetrofitClient.instance.getBreedList()
                val breeds = breedListResponse.message.keys.toList() // Lista de razas

                val breedImages = mutableListOf<Pair<String, String>>() // Lista de pares (nombre, URL de imagen)

                // Asociar imágenes aleatorias con las razas
                for (breed in breeds) {
                    val imagesResponse = RetrofitClient.instance.getImagesForBreed(breed)
                    if (imagesResponse.status == "success" && imagesResponse.message.isNotEmpty()) {
                        // Elegir una imagen aleatoria para la raza
                        val randomImageUrl = imagesResponse.message.random()
                        breedImages.add(Pair(breed.capitalize(), randomImageUrl))
                    }

                    // Limitar a las primeras 10 razas para no sobrecargar el RecyclerView
                    if (breedImages.size >= 15) break
                }

                // Configurar el adaptador con imágenes aleatorias
                recyclerView.adapter = BreedAdapter(breedImages)

            } catch (e: Exception) {
                e.printStackTrace() // Manejar errores de red
            }
        }
    }
}



