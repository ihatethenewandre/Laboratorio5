package com.example.laboratorio6

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio6.ui.theme.Amarillo

data class Localidad(val nombre: String, val descripcion: String)

val localidades = listOf(
    Localidad("Palais Omnisports", "París, Francia"),
    Localidad("Que Club", "Birmingham, Inglaterra"),
    Localidad("O2 Arena, Londres", "Reino Unido"),
    Localidad("United Center", "Chicago, EE.UU."),
    Localidad("Hammerstein Ballroom", "Nueva York, EE.UU."),
    Localidad("Madison Square Garden", "Nueva York, EE.UU."),
    Localidad("Shrine Expo Hall", "Los Ángeles, EE.UU.")
)

@Composable
fun Pantalla3() {
    Column {
        Spacer(modifier = Modifier.height(90.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(localidades) { localidad ->
                LocalidadItem(localidad = localidad)
            }
        }
    }
}

@Composable
fun LocalidadItem(localidad: Localidad) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Default.LocationOn,
            contentDescription = "",
            tint = Color.Black,
        )
        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = localidad.nombre,
                fontSize = 20.sp,
                color = Amarillo
            )
            Text(
                text = localidad.descripcion,
                fontSize = 16.sp,
                color = Color.Gray
            )
        }
    }
}