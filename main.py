import pandas as pd
import re
import string
import nltk
from nltk.corpus import stopwords
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import MultinomialNB
from sklearn.metrics import classification_report, accuracy_score

# Descargar stopwords si no están disponibles
try:
    nltk.data.find('corpora/stopwords')
except LookupError:
    nltk.download('stopwords')

# 1. Descripción de los datos
print("Cargando los datos...")
try:
    df = pd.read_csv('train.csv')
except FileNotFoundError:
    print("Archivo train.csv no encontrado.")

# 2. Preprocesamiento
def clean_text(text):
    text = str(text).lower()
    text = re.sub(r'https?://\S+|www\.\S+', '', text)
    text = re.sub(r'<.*?>+', '', text)
    text = re.sub(r'[%s]' % re.escape(string.punctuation), '', text)
    text = re.sub(r'\n', '', text)
    text = re.sub(r'\w*\d\w*', '', text)
    stop_words = set(stopwords.words('english'))
    text = ' '.join([word for word in text.split() if word not in stop_words])
    return text

if 'df' in locals():
    print("Limpiando datos...")
    df['clean_text'] = df['text'].apply(clean_text)

    # 3. Unigramas y Bigramas
    print("Generando unigramas y bigramas...")
    vectorizer_uni = CountVectorizer(ngram_range=(1, 1), max_features=1000)
    X_uni = vectorizer_uni.fit_transform(df['clean_text'])
    
    vectorizer_bi = CountVectorizer(ngram_range=(2, 2), max_features=1000)
    X_bi = vectorizer_bi.fit_transform(df['clean_text'])

    print("Ejemplo de unigramas:", list(vectorizer_uni.vocabulary_.keys())[:10])
    print("Ejemplo de bigramas:", list(vectorizer_bi.vocabulary_.keys())[:10])

    # 4. Modelo Preliminar de Clasificación
    print("Entrenando modelo preliminar (Naive Bayes)...")
    X = vectorizer_uni.fit_transform(df['clean_text'])
    y = df['target']

    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

    model = MultinomialNB()
    model.fit(X_train, y_train)

    y_pred = model.predict(X_test)
    print("Precisión del modelo preliminar:", accuracy_score(y_test, y_pred))
    print(classification_report(y_test, y_pred))
