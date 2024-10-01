package com.example.laboratorio6

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Event(
    val title: String,
    val location: String,
    val dateTime: String,
    val description: String,
    val image: Int
)

@Composable
fun EventListScreen(navController: NavController,  modifier: Modifier = Modifier) {
    val favoriteEvents = listOf(
        Event("Alive 2007", "Palais Omnisports, París, Francia", "7 de julio, 07:00",
            "Este concierto es parte de la gira 'Alive 2007', donde Daft Punk presenta una mezcla de sus mayores éxitos.", R.drawable.alive2007),
        Event("Saint Pablo", "United Center, Chicago, EE.UU.", "22 de febrero, 22:00",
            "Kanye ofrece una experiencia inmersiva interpretando canciones de su álbum 'The Life of Pablo'.", R.drawable.saintpablo),
        Event("Two Dollar Bill", "Hammerstein Ballroom, Nueva York, EE.UU.", "10 de octubre, 10:00",
            "The Strokes interpreta canciones de su álbum debut 'Is This It' para un público reducido.", R.drawable.twodollarbill),
        Event("The Black Parade Is Dead", "Madison Square Garden, Nueva York, EE.UU.", "5 de mayo, 05:00",
            "Un concierto teatral y emotivo, interpretando su icónico álbum 'The Black Parade'.", R.drawable.theblackparadeisdead)
    )

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

    LazyColumn(modifier = modifier) {
        item {
            Spacer(modifier = Modifier.height(90.dp))
        }
        item {
            Text(text = "Eventos Favoritos", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
            EventGrid(events = favoriteEvents, navController)
        }
        item {
            Text(text = "Todos Eventos", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
            EventGrid(events = allEvents, navController)
        }
    }
}

@Composable
fun EventGrid(events: List<Event>, navController: NavController) {
    Column {
        events.chunked(2).forEach { rowEvents ->
            Row(modifier = Modifier.fillMaxWidth()) {
                rowEvents.forEach { event ->
                    EventCard(event = event, modifier = Modifier.weight(1f), navController)
                }
                if (rowEvents.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun EventCard(event: Event, modifier: Modifier = Modifier, navController: NavController) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate("Pantalla2/${event.title}")
            }
    ) {
        Column {
            Image(
                painter = painterResource(id = event.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
            )
            Text(event.title, modifier = Modifier.padding(8.dp), fontSize = 20.sp, color = Color.Black)
            Text(event.dateTime, modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp), fontSize = 12.sp)
        }
    }
}

@Composable
fun Pantalla1(navController: NavController) {
    EventListScreen(navController)
}