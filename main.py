import pandas as pd

# 1. Descripción de los datos
# Cargamos los datos
print("Cargando los datos...")
try:
    df = pd.read_csv('train.csv')
    print(df.head())
    print(df.info())
except FileNotFoundError:
    print("Archivo train.csv no encontrado. Por favor descárguelo de Kaggle.")
