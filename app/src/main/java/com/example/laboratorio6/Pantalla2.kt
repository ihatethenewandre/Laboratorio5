package com.example.laboratorio6

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun EventDetailScreen(eventTitle: String) {
    Spacer(modifier = Modifier.height(90.dp))
    val event = findEventByTitle(eventTitle)

    if (event != null) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Spacer(modifier = Modifier.height(90.dp))
            Box(modifier = Modifier.fillMaxWidth().height(250.dp)) {
                Image(
                    painter = painterResource(id = event.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = event.title, fontSize = 24.sp, color = Color.Black)
            Text(text = event.location, fontSize = 16.sp, color = Color.Gray)
            Text(text = event.dateTime, fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = event.description, fontSize = 14.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(24.dp))
            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                Button(onClick = {}) {
                    Text(text = "Añadir Favorito")
                }
                Button(onClick = {}) {
                    Text(text = "Comprar")
                }
            }
        }
    } else {
        Text("ERROR | Evento No Encontrado", modifier = Modifier.fillMaxSize(), fontSize = 24.sp, color = Color.Red)
    }
}

fun findEventByTitle(title: String): Event? {
    val allEvents = listOf(
        Event("Alive 2007", "Palais Omnisports, París, Francia", "7 de julio, 07:00",
            "Este concierto es parte de la gira 'Alive 2007', donde Daft Punk presenta una mezcla de sus mayores éxitos.", R.drawable.alive2007),
        Event("Alive 1997", "Que Club, Birmingham, Inglaterra", "9 de noviembre, 19:00",
            "Grabado durante la gira 'Daftendirektour', capturando la energía cruda de Daft Punk en sus primeros años.", R.drawable.alive1997),
        Event("Glow In The Dark", "O2 Arena, Londres, Reino Unido", "4 de abril, 04:00",
            "Kanye presenta su álbum 'Graduation' con una producción escénica inspirada en una ópera espacial.", R.drawable.glowinthedark),
        Event("Saint Pablo", "United Center, Chicago, EE.UU.", "22 de febrero, 22:00",
            "Kanye ofrece una experiencia inmersiva interpretando canciones de su álbum 'The Life of Pablo'.", R.drawable.saintpablo),
        Event("Two Dollar Bill", "Hammerstein Ballroom, Nueva York, EE.UU.", "10 de octubre, 10:00",
            "The Strokes interpreta canciones de su álbum debut 'Is This It' para un público reducido.", R.drawable.twodollarbill),
        Event("The Black Parade Is Dead", "Madison Square Garden, Nueva York, EE.UU.", "5 de mayo, 05:00",
            "Un concierto teatral y emotivo, interpretando su icónico álbum 'The Black Parade'.", R.drawable.theblackparadeisdead),
        Event("The Foundations Of Decay", "Shrine Expo Hall, Los Ángeles, EE.UU.", "20 de diciembre, 20:00",
            "El regreso de My Chemical Romance después de una pausa de seis años, emocionando a sus fans.", R.drawable.thefoundationsofdecay)
    )
    return allEvents.find { it.title == title }
}

@Composable
fun Pantalla2(navController: NavController, eventTitle: String) {
    EventDetailScreen(eventTitle)
}