from flask import Flask, request, jsonify
import joblib
import numpy as np

app = Flask(__name__)
model = joblib.load("Models/random_forest.pkl")  # Ensure correct path

@app.route("/predict", methods=["POST"])
def predict():
    data = request.get_json()
    rent = data['rent']
    location = data['location']
    amenities = data['amenities']

    features = np.array([[rent, location, amenities]])
    prediction = model.predict(features)[0]

    return jsonify({"recommendation": int(prediction)})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
