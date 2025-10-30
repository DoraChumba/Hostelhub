import joblib
import numpy as np

rf_model = joblib.load("Models/random_forest.pkl")

def recommend(features):
    """
    Example 'features' could be a list like:
    [price_range, location_code, type_code]
    """
    X = np.array([features])
    prediction = rf_model.predict(X)
    return int(prediction[0])
