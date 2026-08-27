import pandas as pd
import re
import string
import nltk
from nltk.corpus import stopwords

# Descargar stopwords si no están disponibles
try:
    nltk.data.find('corpora/stopwords')
except LookupError:
    nltk.download('stopwords')

# 1. Descripción de los datos
# Cargamos los datos
print("Cargando los datos...")
try:
    df = pd.read_csv('train.csv')
    print(df.head())
    print(df.info())
except FileNotFoundError:
    print("Archivo train.csv no encontrado. Por favor descárguelo de Kaggle.")

# 2. Preprocesamiento
def clean_text(text):
    # Convertir a minúsculas
    text = str(text).lower()
    # Quitar URLs
    text = re.sub(r'https?://\S+|www\.\S+', '', text)
    # Quitar caracteres especiales y signos de puntuación
    text = re.sub(r'<.*?>+', '', text)
    text = re.sub(r'[%s]' % re.escape(string.punctuation), '', text)
    # Quitar números
    text = re.sub(r'\n', '', text)
    text = re.sub(r'\w*\d\w*', '', text)
    # Quitar stopwords
    stop_words = set(stopwords.words('english'))
    text = ' '.join([word for word in text.split() if word not in stop_words])
    return text

if 'df' in locals():
    print("Iniciando limpieza de datos...")
    df['clean_text'] = df['text'].apply(clean_text)
    print("Limpieza terminada. Muestra:")
    print(df[['text', 'clean_text']].head())
