# Laboratorio 5 – Clasificación de tweets usando minería de texto

Modelos de clasificación de texto para determinar si un tweet se refiere a un desastre real o no, a partir del conjunto Natural Language Processing with Disaster Tweets de Kaggle, con limpieza y preprocesamiento del texto, análisis de frecuencias y n-gramas, análisis exploratorio con nubes de palabras, comparación de varios clasificadores, una función de clasificación de tweets nuevos y un análisis de sentimiento con una variable de negatividad.

## Integrantes

• Estuardo André Castro Bonifaz – 23890  
• Juan Marcos Cruz Melara – 23110  
• André Emilio Pivaral López – 23574  

**Universidad del Valle de Guatemala**  
Facultad de Ingeniería  
Departamento de Computación  
Data Science  
  
**Catedrático:** Boris Fernando Becerra Peláez  
**Sección:** 30

## Descripción

El proyecto clasifica tweets del conjunto Natural Language Processing with Disaster Tweets de Kaggle según se refieran a un desastre real o no. El conjunto contiene 7,613 tweets etiquetados con las columnas id, keyword, location, text y target, uno para desastre real y cero para el resto.

El cuaderno resuelve los ejercicios del laboratorio. Limpia y preprocesa el texto conservando aparte el texto original para el análisis de sentimiento, calcula las frecuencias de palabras y de n-gramas por categoría, realiza un análisis exploratorio con nubes de palabras e histogramas, entrena y compara tres modelos de clasificación sobre una representación de unigramas y bigramas ponderada por frecuencia inversa de documento, construye una función que clasifica un tweet nuevo sin preprocesar, analiza el sentimiento de cada tweet con VADER, identifica los tweets más positivos y más negativos por categoría, y crea una variable de negatividad que se incorpora al mejor modelo para medir si mejora la clasificación.

El análisis completo, con las explicaciones e interpretaciones de cada resultado, se encuentra dentro del notebook. El informe en PDF se incluye como entregable aparte.

## Estructura del proyecto

    Laboratorio5/
    ├── data/
    │   ├── processed/
    │   └── raw/
    │       └── train.csv                   dataset etiquetado
    ├── figures/
    │   ├── Figura1.png a Figura6.png       figuras exportadas por el notebook
    │   └── indice_figuras.csv              número y descripción de cada figura
    ├── notebook/
    │   └── Laboratorio5.ipynb
    ├── .gitignore
    ├── Informe.pdf
    └── README.md

## Requisitos

- Python; se utilizó la versión 3.12.0
- Paquetes: pandas, numpy, matplotlib, seaborn, scikit-learn, nltk, wordcloud, scipy, jupyter, ipykernel
- Durante la primera ejecución NLTK descarga los recursos stopwords y vader_lexicon, por lo que se requiere conexión a internet en esa primera corrida
- El dataset se descarga de Kaggle y se coloca en data/raw/train.csv, no se versiona por su tamaño

## Contenido del análisis

- Ejercicio 3. Limpieza y preprocesamiento del texto, conversión a minúsculas, eliminación de url, menciones y símbolos de etiqueta, decodificación de entidades html, conservación del número 911 como marcador, eliminación de puntuación, dígitos y palabras vacías del inglés con NLTK, conservando el texto original para el análisis de sentimiento.
- Ejercicio 4. Frecuencia de palabras en tweets de desastre y de no desastre, y cálculo de bigramas y trigramas por categoría para valorar el aporte del contexto a la clasificación.
- Ejercicio 5. Análisis exploratorio con la palabra más repetida por categoría, nubes de palabras, histograma de las palabras más frecuentes, longitud de los tweets por clase y discusión de las palabras presentes en ambas categorías.
- Ejercicio 6. Entrenamiento y comparación de una regresión logística, un Naive Bayes multinomial y una máquina de vectores de soporte lineal sobre una representación de unigramas y bigramas ponderada por frecuencia inversa de documento, con selección del mejor modelo por medida F1.
- Ejercicio 7. Función que recibe un tweet sin preprocesar, aplica la misma limpieza y representación y devuelve si el tweet se refiere a un desastre o no.
- Ejercicio 8. Análisis de sentimiento por tweet con VADER sobre el texto original, conteo de palabras positivas y negativas y clasificación de cada tweet en positivo, negativo o neutro.
- Ejercicio 9. Identificación de los diez tweets más negativos y los diez más positivos con su categoría, y comparación de la negatividad promedio entre las categorías.
- Ejercicio 10. Creación de una variable de negatividad, incorporación al mejor modelo y comparación del desempeño con y sin la variable.
